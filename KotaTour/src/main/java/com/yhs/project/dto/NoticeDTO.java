package com.yhs.project.dto;

public class NoticeDTO {
	private int noticeNum; // 공지번호
	private String title; // 제목
	private String content; // 내용
	private String name; // 등록한사람(관리자)
	private String indate; // 등록일

	public int getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "NoticeDTO [noticeNum=" + noticeNum + ", title=" + title + ", content=" + content + ", name=" + name
				+ ", indate=" + indate + "]";
	}

}
