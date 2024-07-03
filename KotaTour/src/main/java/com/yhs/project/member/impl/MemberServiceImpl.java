package com.yhs.project.member.impl;

import com.yhs.project.dao.MemberDAO;
import com.yhs.project.dto.MemberDTO;
import com.yhs.project.member.MemberService;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

	@Override
	public void updateMemberInfo(MemberDTO memberDTO) {
		memberDAO.updateMemberInfo(memberDTO);
	}

	@Override
	public List<MemberDTO> getMemberList() {
		return memberDAO.getMemberList();
	}

	@Override
	public void deleteMember(String id) {
		memberDAO.deleteMember(id);
	}

	@Override
	public int loginID(MemberDTO memberDTO) {
		return memberDAO.loginID(memberDTO);
	}

	@Override
	public MemberDTO getMemberInfo(String id) {
		return memberDAO.getMemberInfo(id);
	}

	@Override
	public int confirmID(String id) {
		return memberDAO.confirmID(id);
	}

	// 이메일 보내기
	// org.springframework.mail.javamail.JavaMailSender
	private JavaMailSender javaMailSender;

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public boolean send(String subject, String text, String from, String to, String filePath) {
		// javax.mail.internet.MimeMessage
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			// org.springframework.mail.javamail.MimeMessageHelper
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setSubject(subject);
			helper.setText(text, true);
			helper.setFrom(from);
			helper.setTo(to);

			// 첨부 파일 처리
			if (filePath != null) {
				File file = new File(filePath);
				if (file.exists()) {
					helper.addAttachment(file.getName(), new File(filePath));
				}
			}
			javaMailSender.send(message);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}
}
