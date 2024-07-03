package com.yhs.project.dao;

import com.yhs.project.dto.MemberDTO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sst;

	// 회원 상세정보 조회
	public MemberDTO getMemberInfo(String id) {
		return sst.selectOne("MemberDAO.getMemberInfo", id);
	}

	// 회원가입
	public void insertMember(MemberDTO memberDTO) {
		sst.insert("MemberDAO.insertMember", memberDTO);
	}

	// 아이디 중복 검사
	public int idCheck(String id) {
		return sst.selectOne("MemberDAO.idCheck", id);
	};

	// 이메일 중복 검사
	public int emailCheck(String email) {
		return sst.selectOne("MemberDAO.emailCheck", email);
	};

	// 회원 ID 존재 여부확인
	public int confirmID(String id) {
		String pwd = sst.selectOne("MemberDAO.confirmID", id);
		if (pwd != null) {
			return 1;
		} else {
			return -1;
		}
	}

	// 아이디 찾기
	public MemberDTO getMemberId(MemberDTO memberDTO) {
		return sst.selectOne("MemberDAO.getMemberId", memberDTO);
	}

	// 비밀번호 찾기
	public MemberDTO getMemberPassword(MemberDTO memberDTO) {
		return sst.selectOne("MemberDAO.getMemberPassword", memberDTO);
	}

	// 회원 정보 변경
	public void updateMemberInfo(MemberDTO memberDTO) {
		sst.update("MemberDAO.updateMemberInfo", memberDTO);
	}

	public List<MemberDTO> getMemberList() {
		return sst.selectList("MemberDAO.getMemberList");
	}

	public void deleteMember(String id) {
		sst.delete("MemberDAO.deleteMember", id);
	}

	// 회원로그인
	public int loginID(MemberDTO memberDto) {
		int result = -1; // 기본 -1
		String password = null; // 입력한 비밀번호

		// 아이디를 조건으로 비밀번호를 가져옴
		password = sst.selectOne("MemberDAO.confirmID", memberDto.getId());

		// DB에서 조회한 password와 사용자가 입력한 password 비교
		if (password == null) { // 비밀번호를 입력하지 않았을때
			result = -1;
		} else if (password.equals(memberDto.getPassword())) { // password가 일치하는 경우
			result = 1;
		} else { // 비밀번호가 일치하지 않는 경우
			result = 0;
		}
		return result;
	}

}
