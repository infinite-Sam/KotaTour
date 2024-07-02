package com.yhs.view.controller;

import com.yhs.project.dto.MemberDTO;
import com.yhs.project.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loginMember")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 약관동의 화면
    @PostMapping(value = "/contractForm")
    public String contractForm() {
        System.out.println("약관동의");
        return "member/contractForm";
    }

    // 회원가입 화면 출력
    @PostMapping(value = "/joinForm")
    public String joinForm() {

        System.out.println("회원가입");
        return "member/joinForm";
    }

    // 아이디 중복 검사
    @PostMapping(value = "/idCheck")
    @ResponseBody
    public String idCheck(String id) throws Exception {
        int result = memberService.idCheck(id);
        if (result != 0) {
            return "fail"; // 아이디 중복
        } else {
            return "success";
        }
    }

    // 이메일 중복 검사
    @PostMapping(value = "/emailCheck")
    @ResponseBody
    public String emailCheck(String email) throws Exception {
        int result = memberService.emailCheck(email);
        if (result != 0) {
            return "fail"; // 이메일 중복
        } else {
            return "success";
        }
    }

    // 회원가입 기능
    @PostMapping(value = "/join")
    public String joinAction(MemberDTO memberDTO) {
        memberService.insertMember(memberDTO);
        return "member/joinComplete";
    }

}
