package com.yhs.project.board.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhs.project.board.BoardService;
import com.yhs.project.dao.BoardDAO;
import com.yhs.project.dto.BoardDTO;

/* service implementation : service인터페이스의 실제 구현체, 비즈니스로직을 실제로 구현,
 * 하나 이상의 DAO나 다른 서비스를 사용하여 복잡한 비즈니스 로직 수행,
 * 트랜잭션 관리가 이루어지는 부분 */
@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDao;

	@Override
	public List<BoardDTO> getBoardList() {
		return boardDao.getBoardList();
	}
	
	@Override
	public List<BoardDTO> getMyBoardList(String id) {
		return boardDao.getMyBoardList(id);
	}

	@Override
	public BoardDTO getBoardDetail(int boardNum) {
		return boardDao.getBoardDetail(boardNum);
	}

	@Override
    @Transactional
    public void insertBoard(BoardDTO board) {
        boardDao.insertBoard(board);
    }

	@Override
	public void updateBoard(BoardDTO board) {
		boardDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(int boardNum) {
		boardDao.deleteBoard(boardNum);
	}

}
