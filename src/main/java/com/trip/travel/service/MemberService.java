package com.trip.travel.service;

import com.trip.travel.dao.MemberDao;
import com.trip.travel.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberDao memberDao;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void joinMember(MemberVo memberVo) {
        memberVo.setPassword(encodePassword(memberVo.getPassword()));
        memberVo.setIntroduction("자기소개를 입력해주세요.");
        memberVo.setJoinDate(LocalDateTime.now(ZoneId.of("Asia/Seoul")));
        memberVo.setProfileImage("default_profile");
        memberDao.save(memberVo);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public MemberVo login(String email, String password) {
        MemberVo member = memberDao.findByEmail(email);
        if (Objects.nonNull(member) && !passwordEncoder.matches(password, member.getPassword())) {
            return null;
        }
        return member;
    }
}
