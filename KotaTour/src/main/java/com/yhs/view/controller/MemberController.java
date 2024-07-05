package com.yhs.view.controller;

import com.yhs.project.dto.MemberDTO;
import com.yhs.project.member.MemberService;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("loginMember")
public class MemberController {

	// 이메일 인증
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MemberService memberService;

	// 약관동의 화면 이동
	@GetMapping(value = "/contractForm")
	public String contractForm() {
		return "member/contractForm";
	}

	// 회원가입 화면 출력
	@PostMapping(value = "/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}

	// 아이디 중복 검사
	@PostMapping(value = "/idCheckAction")
	@ResponseBody
	public String idCheckAction(String id) throws Exception {
		int result = memberService.idCheck(id);
		if (result != 0) {
			return "fail"; // 아이디 중복
		} else {
			return "success";
		}
	}

	// 이메일 중복 검사
	@PostMapping(value = "/emailCheckAction")
	@ResponseBody
	public String emailCheckAction(String email) throws Exception {
		int result = memberService.emailCheck(email);
		if (result != 0) {
			return "fail"; // 이메일 중복
		} else {
			return "success";
		}
	}

	// 회원가입 이메일 인증
	@GetMapping(value = "/mailCheck")
	@ResponseBody
	public String mailCheck(@RequestParam("email") String email) throws Exception {
		/* 인증번호(난수) 생성 */
		Random random = new Random();
		// 111111 ~ 999999 범위의 숫자를 얻기 위해서 nextInt(888888) + 111111를 사용
		int checkNum = random.nextInt(888888) + 111111;
		/* 이메일 양식 */
		// applicationContext.xml에 삽입한 자신의 이메일 계정의 이메일 주소
		String from = "gkstoa3326@gmail.com"; // 보내는 이
		// 수신받을 이메일, 뷰로부터 받은 이메일 주소인 변수 email을 사용
		String to = email; // 받는 이
		// 보낼 이메일 제목
		String title = "KotaTour 회원가입 이메일 인증코드 입니다.";
		// 이메일 내용
		String content = "KotaTour를 이용해주셔서 감사합니다." + "<br><br>" + "인증코드는 " + checkNum + "입니다." + "<br>"
				+ "해당 인증코드를 인증번호 확인란에 기입하여 주세요.";
		String num = "";
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mmh = new MimeMessageHelper(mail, true, "UTF-8");
			mmh.setFrom(from);
			mmh.setTo(to);
			mmh.setSubject(title);
			mmh.setText(content, true);
			mailSender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		num = Integer.toString(checkNum);
		return num;
	}

	// 회원가입 기능
	@PostMapping(value = "/joinAction")
	public String joinAction(MemberDTO memberDTO) {
		memberService.insertMember(memberDTO);
		return "member/joinComplete";
	}

	// 로그인 화면 표시
	@GetMapping(value = "/loginForm")
	public String loginView() {
		return "member/loginForm";
	}

	// 로그인 기능
	@PostMapping(value = "/loginAction")
	public String loginAction(MemberDTO memberDTO, Model model) {

		MemberDTO loginMember = null;
		int result = memberService.loginID(memberDTO);
		if (result == 1) { // 사용자 인증 성공
			loginMember = memberService.getMemberInfo(memberDTO.getId());
			model.addAttribute("loginMember", loginMember);
			return "redirect:index"; // 이전 페이지로 리다이렉트
		} else {

			return "member/loginFail";
		}
	}

	// 로그아웃
	@GetMapping(value = "/logoutAction")
	public String logoutAction(SessionStatus status) {
		status.setComplete(); // 현재 세션을 종료
		return "member/loginForm";
	}

	// id/pw 찾기 화면
	@GetMapping(value = "/findIdForm")
	public String findIdForm() {
		return "member/findId";
	}

	@GetMapping(value = "/findPasswordForm")
	public String findPasswordForm() {
		return "member/findPassword";
	}

	// id 찾기
	@GetMapping(value = "/findIdAction")
	public String findIdAction(MemberDTO memberDTO, Model model) {
		MemberDTO member = memberService.getMemberId(memberDTO);
		if (member != null) { // 사용자 아이디가 존재한다면
			model.addAttribute("message", "1");
			model.addAttribute("id", member.getId());
		} else {
			model.addAttribute("message", "-1");
		}
		return "member/findIdResult";
	}

	// 비밀번호 찾기
	@GetMapping(value = "/findPasswordAction")
	public String findPasswordAction(MemberDTO memberDTO, Model model) {
		MemberDTO member = memberService.getMemberPassword(memberDTO);

		if (member != null) { // 사용자 아이디가 존재한다면
			model.addAttribute("message", "1");
			model.addAttribute("id", member.getId());
			model.addAttribute("password", member.getPassword());
		} else {
			model.addAttribute("message", "-1");
		}
		return "member/findPasswordResult";
	}

	// 회원정보 상세보기
	@RequestMapping(value = "/memberDetailForm")
	public String memberDetailForm(MemberDTO memberDTO, HttpSession session, Model model) {

		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");

		if (loginMember == null) {
			return "member/loginForm";
		}
		MemberDTO member = memberService.getMemberInfo(loginMember.getId());
		model.addAttribute("member", member);

		return "mypage/mypage";
	}

	// 회원정보 변경 폼
	@RequestMapping(value = "/updateMemberForm")
	public String updateMemberForm(MemberDTO memberDTO, Model model, HttpSession session) {

		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");

		if (loginMember == null) {
			return "member/loginForm";
		}
		MemberDTO member = memberService.getMemberInfo(loginMember.getId());
		model.addAttribute("memberDTO", member);

		return "mypage/updateInfoForm";
	}

	// 회원정보 변경
	@RequestMapping(value = "/updateMemberAction", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateMember(MemberDTO memberDTO, Model model, HttpSession session) {
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");

		if (loginMember == null) {
			return "member/loginForm";
		}
		memberDTO.setId(loginMember.getId());
		memberService.updateMemberInfo(memberDTO);
		return "redirect:memberDetailForm";
	}

	// 회원탈퇴
	@RequestMapping(value = "/deleteMember")
	public String deleteMember(MemberDTO memberDTO) {
		memberService.deleteMember(memberDTO.getId());
		return "redirect:logoutAction";
	}

}
