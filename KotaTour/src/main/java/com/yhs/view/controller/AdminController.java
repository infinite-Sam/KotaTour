package com.yhs.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yhs.project.dto.MemberDTO;
import com.yhs.project.member.MemberService;

@Controller
@SessionAttributes("adminMember")
public class AdminController {

	@Autowired
	private MemberService memberService;

	// 관리자 회원목록 조회
	@GetMapping(value = "adminMemberList")
	public String getMemberList(MemberDTO memberDTO, Model model) {
		List<MemberDTO> memberList = memberService.getMemberList();
		model.addAttribute("memberList", memberList);
		return "admin/member/memberList";
	}

	// 관리자 회원삭제
	@RequestMapping(value = "adminDeleteMember")
	public String memberDelete(MemberDTO memberDTO) {
		memberService.deleteMember(memberDTO.getId());
		return "redirect:adminMemberList";
	}
}
