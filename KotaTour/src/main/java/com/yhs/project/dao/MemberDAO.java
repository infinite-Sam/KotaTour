package com.yhs.project.dao;

import com.yhs.project.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

    @Autowired
    private SqlSessionTemplate sst;

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

    // 아이디 찾기
    public MemberDTO getMemberId(MemberDTO memberDTO) {
        return sst.selectOne("MemberDAO.getMemberId", memberDTO);
    }

    // 비밀번호 찾기
    public MemberDTO getMemberPassword(MemberDTO memberDTO) {
        return sst.selectOne("MemberDAO.getMemberPassword", memberDTO);
    }

}
