package com.yhs.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yhs.project.dto.NoticeDTO;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSessionTemplate sst;
	
	// 공지사항 목록조회
	public List<NoticeDTO> getNoticeList(String name) {

		return sst.selectList("NoticeDAO.getNoticeList", name);
	}

	// 공지사항 상세보기
	public NoticeDTO getNoticeDetail(int noticeNum) {

		return sst.selectOne("NoticeDAO.getNoticeDetail", noticeNum);
	}

	// 공지사항 등록하기
	public void insertNotice(NoticeDTO noticeDTO) {

		sst.insert("NoticeDAO.insertNotice", noticeDTO);
	}
	
	// 공지사항 수정
	public void updateNotice(NoticeDTO noticeDTO) {
		sst.update("NoticeDAO.updateNotice", noticeDTO);
	}
	
	// 공지사항 삭제
	public void deleteNotice(int noticeNum) {
		sst.delete("NoticeDAO.deleteNotice", noticeNum);
	}
	
}
