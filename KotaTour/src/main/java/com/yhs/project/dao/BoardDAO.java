package com.yhs.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yhs.project.dto.BoardDTO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate sst;
	
	// 게시글 목록조회
	public List<BoardDTO> getBoardList(String id) {

		return sst.selectList("BoardDAO.getBoardList", id);
	}

	// 게시글 상세보기
	public BoardDTO getBoardDetail(int boardNum) {

		return sst.selectOne("BoardDAO.getBoardDetail", boardNum);
	}

	// 게시글 등록하기
	public void insertBoard(BoardDTO boardDTO) {

		sst.insert("BoardDAO.insertBoard", boardDTO);
	}
	
	// 게시글 수정
	public void updateBoard(BoardDTO boardDTO) {
		sst.update("BoardDAO.updateBoard", boardDTO);
	}
	
	// 게시글 삭제
	public void deleteBoard(int boardNum) {
		sst.delete("BoardDAO.deleteBoard", boardNum);
	}
}
