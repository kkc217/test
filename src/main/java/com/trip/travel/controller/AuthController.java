package com.trip.travel.controller;

import com.trip.travel.service.MemberService;
import com.trip.travel.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String joinForm() {
        return "auth/join";
    }

    @PostMapping("/join")
    public String join(
            MemberVo memberVo,
            HttpServletResponse response) throws IOException {
        memberService.joinMember(memberVo);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('회원가입을 축하드립니다.');</script>");
        return "auth/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        MemberVo memberVo = memberService.login(email, password);

        if (memberVo == null) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('아이디 또는 비밀번호를 확인해주시기 바랍니다.'); history.go(-1);</script>");
            out.flush();
            return null;
        }

        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(60 * 60);
        session.setAttribute("loginMember", memberVo);

        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(
            HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "redirect:/";
    }

}
