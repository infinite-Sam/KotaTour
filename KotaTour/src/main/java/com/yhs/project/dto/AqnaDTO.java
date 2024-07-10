package com.yhs.project.dto;

public class AqnaDTO {

	private int aqnaNum; // 게시글번호
	private String title; // 제목
	private String questions; // 내용
	private String answer; // 답변
	private String name; // 등록한사람

	public int getAqnaNum() {
		return aqnaNum;
	}

	public void setAqnaNum(int aqnaNum) {
		this.aqnaNum = aqnaNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AqnaDTO [aqnaNum=" + aqnaNum + ", title=" + title + ", questions=" + questions + ", answer=" + answer
				+ ", name=" + name + "]";
	}

}
