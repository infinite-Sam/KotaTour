package com.yhs.project.notice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhs.project.dao.NoticeDAO;
import com.yhs.project.dto.NoticeDTO;
import com.yhs.project.notice.NoticeService;


@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<NoticeDTO> getNoticeList(String name) {
		return noticeDAO.getNoticeList(name);
	}

	@Override
	public NoticeDTO getNoticeDetail(int noticeNum) {
		return noticeDAO.getNoticeDetail(noticeNum);
	}

	@Override
	public void insertNotice(NoticeDTO noticeDTO) {
		noticeDAO.insertNotice(noticeDTO);
	}

	@Override
	public void updateNotice(NoticeDTO noticeDTO) {
		noticeDAO.updateNotice(noticeDTO);
	}

	@Override
	public void deleteNotice(int noticeNum) {
		noticeDAO.deleteNotice(noticeNum);
	}

	
}
