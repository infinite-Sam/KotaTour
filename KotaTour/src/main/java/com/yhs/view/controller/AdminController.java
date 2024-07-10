package com.yhs.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yhs.project.dto.AqnaDTO;
import com.yhs.project.dto.MemberDTO;
import com.yhs.project.dto.NoticeDTO;
import com.yhs.project.member.MemberService;
import com.yhs.project.notice.NoticeService;
import com.yhs.project.qna.QnaService;

@Controller
@SessionAttributes("adminMember")
public class AdminController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private QnaService qnaService;

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
	
	/*
	 * // 공지사항 상세보기
	 * 
	 * @GetMapping(value="AdminGetNoticeDetail") public String
	 * getNoticeDetail(NoticeDTO noticeDTO, HttpSession session, Model model) {
	 * NoticeDTO notice = noticeService.getNoticeDetail(noticeDTO.getNoticeNum());
	 * model.addAttribute("NoticeDTO", notice); return "admin/service/noticeDetail";
	 * }
	 * 
	 * // 공지사항 목록 조회
	 * 
	 * @GetMapping(value="getNoticeList") public String getNoticeList(HttpSession
	 * session, Model model) { List<NoticeDTO> noticeList =
	 * noticeService.getNoticeList("관리자"); model.addAttribute("noticeList",
	 * noticeList);
	 * 
	 * return "service/noticeList"; }
	 */
		
		// 공지사항 작성 화면
		@GetMapping(value="noticeWriteForm")
		public String noticeWriteForm(HttpSession session) {
				return "admin/service/noticeWrite";	// 로그인이 되어있다면 notice작성 화면이동
		}
		
		// 공지사항 작성기능
		@PostMapping(value="noticeWriteAction")
		public String noticeWriteAction(NoticeDTO noticeDTO, HttpSession session) {
				noticeDTO.setName("관리자");
				noticeService.insertNotice(noticeDTO);
				return "redirect:getNoticeList"; // 작성완료후  공지사항 목록으로 이동
		}
		
		// 공지사항 수정 화면
		@GetMapping(value="updateNoticeForm")
		public String updateNoticeForm(NoticeDTO noticeDTO, HttpSession session, Model model) {
			NoticeDTO notice = noticeService.getNoticeDetail(noticeDTO.getNoticeNum());
			model.addAttribute("notice", notice);
			return "admin/service/noticeUpdate";	// 로그인이 되어있다면 notice작성 화면이동
		}
		
		// 공지사항 수정 기능
		@PostMapping(value="updateNoticeAction")
		public String updateNoticeAction(NoticeDTO noticeDTO, HttpSession session) {
				noticeDTO.setName("관리자");
				noticeService.updateNotice(noticeDTO);
				return "redirect:getNoticeDetail?noticeNum="+noticeDTO.getNoticeNum();
		}
		
		// 공지사항 삭제 기능
		@RequestMapping(value = "deleteNotice")
		public String deleteNotice(NoticeDTO noticeDTO) {
			noticeService.deleteNotice(noticeDTO.getNoticeNum());
			return "redirect:getNoticeList";
		}
		
		// 자주묻는질문 등록화면 이동
		@GetMapping(value="aqnaWriteForm")
		public String aqnaWriteForm(HttpSession session) {
				return "admin/service/aqnaWrite";
		}
		
		// 자주묻는질문 등록 기능
		@PostMapping(value="aqnaWriteAction")
		public String aqnaWriteAction(AqnaDTO aqnaDTO, HttpSession session) {
				aqnaDTO.setName("관리자");
				qnaService.insertAqna(aqnaDTO);
				return "redirect:getQnaList";
		}
		
		// 자주묻는질문 수정 화면
		@GetMapping(value="aqnaUpdateForm")
		public String aqnaUpdateForm(AqnaDTO aqnaDTO, HttpSession session, Model model) {
			AqnaDTO aqna = qnaService.getAQnaDetail(aqnaDTO.getAqnaNum());
			model.addAttribute("aqna", aqna);
			return "admin/service/aqnaUpdate";
		}
		
		// 자주묻는질문 수정 기능
		@PostMapping(value="aqnaUpdateAction")
		public String aqnaUpdateAction(AqnaDTO aqnaDTO, HttpSession session) {
				aqnaDTO.setName("관리자");
				qnaService.updateAqna(aqnaDTO);
				return "redirect:getAqnaDetail?aqnaNum="+aqnaDTO.getAqnaNum(); // 작성완료후  공지사항 목록으로 이동
		}
		// 자주묻는질문 삭제 기능
		@RequestMapping(value = "deleteAqna")
		public String deleteAqna(AqnaDTO aqnaDTO) {
			qnaService.deleteAqna(aqnaDTO.getAqnaNum());
			return "redirect:getQnaList";
		}
}
