package com.yhs.project.member;

import java.util.List;

import com.yhs.project.dto.MemberDTO;

public interface MemberService {

	// 회원 가입
	void insertMember(MemberDTO memberDTO);

	// id 중복검사
	public int idCheck(String id) throws Exception;

	// 이메일 중복검사
	public int emailCheck(String email) throws Exception;

	/**
	 * 이메일 전송
	 * 
	 * @param subject  제목
	 * @param text     내용
	 * @param from     보내는 메일 주소
	 * @param to       받는 메일 주소
	 * @param filePath 첨부 파일 경로: 첨부파일 없을시 null
	 **/
	public boolean send(String subject, String text, String from, String to, String filePath);

	// id 찾기
	MemberDTO getMemberId(MemberDTO memberDTO);

	// password찾기
	MemberDTO getMemberPassword(MemberDTO memberDTO);

	// 회원정보변경
	void updateMemberInfo(MemberDTO memberDTO);

	// 회원 목록 조회
	List<MemberDTO> getMemberList();

	// 회원 삭제
	void deleteMember(String id);

	// 회원 로그인
	int loginID(MemberDTO memberDTO);

	// 회원 상세정보 조회
	MemberDTO getMemberInfo(String id);

	// 회원아이디 존재여부 확인
	int confirmID(String id);

}
