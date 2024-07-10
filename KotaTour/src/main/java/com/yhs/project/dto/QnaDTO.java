package com.yhs.project.dto;

public class QnaDTO {

	private int qnaNum; // 게시글번호
	private String title; // 제목
	private String content; // 내용
	private String reply; // 답변
	private String id; // 등록한사람
	private String indate; // 등록일
	private String rep; // 답변여부

	public int getQnaNum() {
		return qnaNum;
	}

	public void setQnaNum(int qnaNum) {
		this.qnaNum = qnaNum;
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

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
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

	public String getRep() {
		return rep;
	}

	public void setRep(String rep) {
		this.rep = rep;
	}

	@Override
	public String toString() {
		return "QnaDTO [qnaNum=" + qnaNum + ", title=" + title + ", content=" + content + ", reply=" + reply + ", id="
				+ id + ", indate=" + indate + ", rep=" + rep + "]";
	}

}
