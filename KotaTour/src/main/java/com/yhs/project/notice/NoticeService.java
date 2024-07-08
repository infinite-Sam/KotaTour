package com.yhs.project.notice;

import java.util.List;

import com.yhs.project.dto.NoticeDTO;



public interface NoticeService {

	List<NoticeDTO> getNoticeList(String name);

	NoticeDTO getNoticeDetail(int noticeNum);

	void insertNotice(NoticeDTO noticeDTO);
	
	void updateNotice(NoticeDTO noticeDTO);
	
	void deleteNotice(int noticeNum);
}
