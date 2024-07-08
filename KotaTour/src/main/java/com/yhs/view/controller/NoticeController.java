package com.yhs.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yhs.project.dto.NoticeDTO;
import com.yhs.project.notice.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	// 공지사항 목록 조회
	@GetMapping(value="getNoticeList")
	public String getNoticeList(HttpSession session, Model model) {
		System.out.println("공지사항 목록 조회");
		List<NoticeDTO> getNoticeList = noticeService.getNoticeList("관리자");
		model.addAttribute("getNoticeList", getNoticeList);

		return "service/noticeList";
	}

	// 공지사항 상세보기
	@GetMapping(value="getNoticeDetail")
	public String qnaView(NoticeDTO noticeDTO, HttpSession session, Model model) {
		System.out.println("공지사항 상세보기");
		NoticeDTO notice = noticeService.getNoticeDetail(noticeDTO.getNoticeNum());
		model.addAttribute("noticeDTO", notice);
		return "service/noticeDetail";
	}
	
}
