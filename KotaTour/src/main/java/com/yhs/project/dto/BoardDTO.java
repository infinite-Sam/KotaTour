package com.yhs.project.dto;

public class BoardDTO {

	private int boardNum; // 게시글번호
	private String title; // 제목
	private String content; // 내용
	private String id; // 등록한사람
	private String indate; // 등록일
	private int replyCount; // 댓글 개수

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardNum=" + boardNum + ", title=" + title + ", content=" + content + ", id=" + id
				+ ", indate=" + indate + ", replyCount=" + replyCount + "]";
	}

}
