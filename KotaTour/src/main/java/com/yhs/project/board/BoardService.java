package com.yhs.project.board;

import java.util.List;

import com.yhs.project.dto.BoardDTO;


/* service : 비즈니스 로직을 정의하는 인터페이스로 핵심 기능을 선언, 트랜잭션 경계를 정의 */
public interface BoardService {

	List<BoardDTO> getBoardList();
	
	List<BoardDTO> getMyBoardList(String id);

	BoardDTO getBoardDetail(int boardNum);

	void insertBoard(BoardDTO board);
	
	void updateBoard(BoardDTO board);
	
	void deleteBoard(int boardNum);
	
}
