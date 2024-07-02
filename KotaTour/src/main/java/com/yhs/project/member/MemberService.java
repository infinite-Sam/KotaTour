package com.yhs.project.member;

import com.yhs.project.dto.MemberDTO;

public interface MemberService {

    // 회원 가입
    void insertMember(MemberDTO memberDTO);

    // id 중복검사
    public int idCheck(String id) throws Exception;

    // 이메일 중복검사
    public int emailCheck(String email) throws Exception;

    // id 찾기
    MemberDTO getMemberId(MemberDTO memberDTO);

    // password찾기
    MemberDTO getMemberPassword(MemberDTO memberDTO);

}
