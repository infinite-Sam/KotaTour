package com.yhs.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yhs.project.board.BoardService;
import com.yhs.project.dto.BoardDTO;
import com.yhs.project.dto.MemberDTO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	// 게시글 작성 화면이동
	@GetMapping(value="boardWriteForm")
	public String boardWriteform(HttpSession session) {
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		if (loginMember == null) {
			return "member/loginForm";
		} else {
			return "board/boardWrite";	// 로그인이 되어있다면 게시글작성 화면이동
		}
	}
	
	// 게시글 작성기능
	@PostMapping(value = "boardWriteAction")
	public String boardWriteAction(BoardDTO boardDTO, HttpSession session, @RequestParam("imageFiles") MultipartFile[] imageFiles, HttpServletRequest request) {
	    MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
	    
	    List<String> fileUrls = new ArrayList<>();
	    String fileName = "";
	    
	    for (MultipartFile uploadFile : files) {
	        if (!uploadFile.isEmpty()) {
	            fileName = uploadFile.getOriginalFilename();
	            // 파일 업로드 경로 설정
	            String uploadPath = session.getServletContext().getRealPath("WEB-INF/resources/images/board");
	            try {
	                File file = new File(uploadPath + "/" + fileName);
	                uploadFile.transferTo(file);
	                fileUrls.add("WEB-INF/resources/images/board/" + fileName);
	            } catch (IllegalStateException | IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    boardDTO.setFileUrls(fileUrls);
	    boardDTO.setId(loginMember.getId());
	    boardService.insertBoard(boardDTO);
	    return "redirect:getMyBoardList";
	}
	
	// 게시글 작성기능
		@PostMapping(value = "boardWriteAction")
		public String boardWriteAction(BoardDTO boardDTO, @RequestParam("file") MultipartFile file, HttpSession session) {
			
		    MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		    
		 // 파일 업로드 처리
	        if (!file.isEmpty()) {
	            String originalFilename = file.getOriginalFilename();
	            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
	            String savedFilename = UUID.randomUUID().toString() + extension;

	            File dest = new File(UPLOAD_PATH + savedFilename);
	            try {
	                file.transferTo(dest);
	                // 파일 경로를 게시글 내용에 추가
	                String fileUrl = "/uploads/" + savedFilename;
	                boardDTO.setContent(boardDTO.getContent() + "<br><img src='" + fileUrl + "'>");
	            } catch (IOException e) {
	                e.printStackTrace();
	                // 파일 업로드 실패 처리
	            }
	        }

		    boardDTO.setId(loginMember.getId());
		    boardService.insertBoard(boardDTO);
		    return "redirect:getMyBoardList";
		}
	
	// 전체 게시글 목록 조회
	@GetMapping(value="getBoardList")
	public String getBoardList(HttpSession session, Model model) {
		System.out.println("전체 게시글 목록 조회");
		List<BoardDTO> boardList = boardService.getBoardList();
		model.addAttribute("BoardList", boardList);

		return "board/boardList";
	}
	
	// 내 게시글 목록 조회
	@GetMapping(value="getMyBoardList")
	public String getMyBoardList(HttpSession session, Model model) {
		System.out.println("내 게시글 목록 조회");
			MemberDTO loginMember = (MemberDTO)session.getAttribute("loginMember");
			List<BoardDTO> getMyBoardList = boardService.getMyBoardList(loginMember.getId());
			model.addAttribute("getMyBoardList", getMyBoardList);

			return "board/myBoardList";
	}

	// 게시글 상세보기
	@GetMapping(value="getBoardDetail")
	public String getBoardDetail(BoardDTO board, HttpSession session, Model model) {
		System.out.println("게시글 상세보기");
		BoardDTO getBoardNum = boardService.getBoardDetail(board.getBoardNum());
		model.addAttribute("boardDTO", getBoardNum);
		return "board/boardDetail";
	}
	
	// 게시글 수정 화면
	@GetMapping(value="updateBoardForm")
	public String updateBoardForm(BoardDTO board, HttpSession session, Model model) {
		BoardDTO boardNum = boardService.getBoardDetail(board.getBoardNum());
		model.addAttribute("board", boardNum);
		return "board/boardUpdate";
	}
	
	// 게시글 수정 기능
	@PostMapping(value="updateBoard")
	public String updateBoardAction(BoardDTO board, HttpSession session) {
		MemberDTO loginMember = (MemberDTO)session.getAttribute("loginMember");
			board.setId(loginMember.getId());
			boardService.updateBoard(board);
			return "redirect:getBoardDetail?boardNum="+board.getBoardNum();
	}
	
	// 게시글 삭제 기능
	@RequestMapping(value = "deleteBoard")
	public String deleteBoard(BoardDTO board) {
		boardService.deleteBoard(board.getBoardNum());
		return "redirect:getMyBoardList";
	}
	
	
}
