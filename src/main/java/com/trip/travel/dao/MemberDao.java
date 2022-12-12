package com.trip.travel.dao;

import com.querydsl.core.NonUniqueResultException;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.travel.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import static com.trip.travel.vo.QMemberVo.memberVo;

@Repository
@RequiredArgsConstructor
public class MemberDao {

    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public void save(MemberVo memberVo) {
        em.persist(memberVo);
    }

    public MemberVo findByEmail(String email) {
        try {
            return queryFactory.selectFrom(memberVo)
                    .where(memberVo.email.eq(email))
                    .fetchOne();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }

}
