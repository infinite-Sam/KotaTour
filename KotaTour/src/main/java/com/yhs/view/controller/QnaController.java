package com.yhs.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yhs.project.dto.AqnaDTO;
import com.yhs.project.dto.MemberDTO;
import com.yhs.project.dto.QnaDTO;
import com.yhs.project.qna.QnaService;


@Controller
public class QnaController {

	@Autowired
	private QnaService qnaService;

	// 내 질문 목록 조회
	@GetMapping(value="getQnaList")
	public String getQnaList(HttpSession session, Model model) {
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		if (loginMember == null) { // 로그인이 되어있지 않다면
			List<AqnaDTO> aqnaList = qnaService.getAqnaList("관리자");
			model.addAttribute("aqnaList", aqnaList);
			return "service/qnaList";
		} else {
			List<QnaDTO> getQnaList = qnaService.getQnaList(loginMember.getId());
			model.addAttribute("qnaList", getQnaList);

			List<AqnaDTO> getAqnaList = qnaService.getAqnaList("관리자");
			model.addAttribute("aqnaList", getAqnaList);
			
			List<QnaDTO> getMemberQnaList = qnaService.getMemberQnaList();
			model.addAttribute("getMemberQnaList", getMemberQnaList);

			return "service/qnaList";
		}
	}
	
	// qna 작성 화면
	@GetMapping(value="qnaWriteForm")
	public String qnaWriteForm(HttpSession session) {
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		if (loginMember == null) {
			return "member/loginForm";
		} else {
			return "service/qnaWriteForm";	// 로그인이 되어있다면 qna작성 화면이동
		}
	}

	// qna 작성기능
	@PostMapping(value="qnaWriteAction")
	public String qnaWriteAction(QnaDTO qnaDTO, HttpSession session) {
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");

		if (loginMember == null) {
			return "member/loginForm";
		} else {
			qnaDTO.setId(loginMember.getId());
			qnaService.insertQna(qnaDTO);
			return "redirect:getQnaList"; // 작성완료후  qna 목록으로 이동
		}
	}

	// qna상세보기
	@GetMapping(value="getQnaDetail")
	public String getQnaDetail(QnaDTO qnaDTO, AqnaDTO aqnaDTO, HttpSession session, Model model) {
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		if (loginMember == null) {
			return "member/loginForm";
		} else {
			QnaDTO qna = qnaService.getQnaDetail(qnaDTO.getQnaNum());
			AqnaDTO aqna = qnaService.getAQnaDetail(aqnaDTO.getAqnaNum());
			model.addAttribute("qnaVO", qna);
			model.addAttribute("aqnaVO", aqna);
			return "service/qnaDetail";
		}
	}

	// 질문 수정 화면
	@GetMapping(value="qnaUpdateForm")
	public String qnaUpdateForm(QnaDTO qnaDTO, HttpSession session, Model model) {
		QnaDTO qna = qnaService.getQnaDetail(qnaDTO.getQnaNum());
		model.addAttribute("qna", qna);
		return "service/qnaUpdate";
	}
	
	// 질문 수정 기능
	@PostMapping(value="qnaUpdateAction")
	public String qnaUpdateAction(QnaDTO qnaDTO, HttpSession session) {
			MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
			qnaDTO.setId(loginMember.getId());
			qnaService.updateQna(qnaDTO);
			return "redirect:getQnaDetail?qnaNum="+qnaDTO.getQnaNum(); // 작성완료후  공지사항 목록으로 이동
	}
	// 질문 삭제 기능
	@RequestMapping(value = "deleteQna")
	public String deleteQna(QnaDTO qnaDTO) {
		qnaService.deleteQna(qnaDTO.getQnaNum());
		return "redirect:getQnaList";
	}
	
	// aqna상세보기
	@GetMapping(value="getAqnaDetail")
	public String getAqnaDetail(AqnaDTO aqnaDTO, HttpSession session, Model model) {
		AqnaDTO aqna = qnaService.getAQnaDetail(aqnaDTO.getAqnaNum());
		model.addAttribute("aqnaVO", aqna);
		return "service/aqnaDetail";
	}

}
