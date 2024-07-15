package com.yhs.project.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yhs.project.dto.BoardDTO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate sst;

	// 전체 게시글 목록조회
	public List<BoardDTO> getBoardList() {

		return sst.selectList("BoardDAO.getBoardList");
	}

	// 내 게시글 목록 조회
	public List<BoardDTO> getMyBoardList(String id) {
		return sst.selectList("BoardDAO.getMyBoardList", id);
	}

	// 게시글 상세보기
	public BoardDTO getBoardDetail(int boardNum) {

		return sst.selectOne("BoardDAO.getBoardDetail", boardNum);
	}

	// 게시글 등록하기
	public void insertBoard(BoardDTO board) {

		sst.insert("BoardDAO.insertBoard", board);
	}

	// 게시글 수정
	public void updateBoard(BoardDTO board) {
		sst.update("BoardDAO.updateBoard", board);
	}

	// 게시글 삭제
	public void deleteBoard(int boardNum) {
		sst.delete("BoardDAO.deleteBoard", boardNum);
	}
}
