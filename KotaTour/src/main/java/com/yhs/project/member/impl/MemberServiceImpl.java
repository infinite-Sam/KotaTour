package com.yhs.project.member.impl;

import com.yhs.project.dao.MemberDAO;
import com.yhs.project.dto.MemberDTO;
import com.yhs.project.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public void insertMember(MemberDTO memberDTO) {
        memberDAO.insertMember(memberDTO);
    }

    @Override
    public int idCheck(String id) throws Exception {
        return memberDAO.idCheck(id);
    }

    @Override
    public int emailCheck(String email) throws Exception {
        return memberDAO.emailCheck(email);
    }

    @Override
    public MemberDTO getMemberId(MemberDTO memberDTO) {
        return memberDAO.getMemberId(memberDTO);
    }

    @Override
    public MemberDTO getMemberPassword(MemberDTO memberDTO) {
        return memberDAO.getMemberPassword(memberDTO);
    }
}
