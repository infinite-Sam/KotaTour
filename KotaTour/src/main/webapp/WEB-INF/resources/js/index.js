// 약관동의
function go_next() {
	if ($('.agree')[0].checked == true && $('.agree')[1].checked == true) { // 동의함에 체크되어 있으면 회원가입페이지 이동
		var chk = confirm("회원가입을 진행하시겠습니까?");
		if(chk){
			$('#join').attr('action', 'joinForm').submit();
		}
	} else {
		alert("약관에 동의해 주셔야 합니다.");
	}
}

//우편번호 찾기
function execPostCode() {
    new daum.Postcode({
        oncomplete: function(data) {
           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

        	// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
           var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
           var extraRoadAddr = ''; // 도로명 조합형 주소 변수

           // 법정동명이 있을 경우 추가한다. (법정리는 제외)
           // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
           if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
               extraRoadAddr += data.bname;
           }
           // 건물명이 있고, 공동주택일 경우 추가한다.
           if(data.buildingName !== '' && data.apartment === 'Y'){
              extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
           }
           // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
           if(extraRoadAddr !== ''){
               extraRoadAddr = ' (' + extraRoadAddr + ')';
           }
           // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
           if(fullRoadAddr !== ''){
               fullRoadAddr += extraRoadAddr;
           }
           // 우편번호와 주소 정보를 해당 필드에 넣는다.
           console.log(data.zonecode);
           console.log(fullRoadAddr);
           
           document.getElementById('zipNum').value = data.zonecode; //5자리 새우편번호 사용
           document.getElementById('address').value = fullRoadAddr;
       }
    }).open();
}
function idok(){
	  self.close();
}


//폰번호 - 자동삽입
function inputPhoneNumber(obj) { 
    var number = obj.value.replace(/[^0-9]/g, "");
    var phoneNum = "";
	
	 if(number.length < 4) {
	        return number;
	    } else if(number.length < 7) {
	        phoneNum += number.substr(0, 3);
	        phoneNum += "-";
	        phoneNum += number.substr(3);
	    } else if(number.length < 11) {
	        phoneNum += number.substr(0, 3);
	        phoneNum += "-";
	        phoneNum += number.substr(3, 3);
	        phoneNum += "-";
	        phoneNum += number.substr(6);
	    } else {
	        phoneNum += number.substr(0, 3);
	        phoneNum += "-";
	        phoneNum += number.substr(3, 4);
	        phoneNum += "-";
	        phoneNum += number.substr(7);
	    }
	    obj.value = phoneNum;
}

//회원가입 입력확인
function formCheck(form) {
	var idchk = $('.idCheck1').css('display');
	var emailchk = $('#mailChkResult');
	var chk = confirm("입력한 정보대로 회원가입 하시겠습니까?");
	if(chk){
		//유효성 검사
		if(form.name.value == "") { // 이름 미입력시
			alert('이름을 입력하세요.');
			form.name.focus() ;
			return ;
		} else if(form.id.value == "") { // 아이디 미입력시
			alert('아이디를 입력하세요.');
			form.id.focus() ;
			return ;
		} else if (idchk == 'none') {
			alert("아이디 중복체크를 해주세요!");
			form.id.focus();
			return;
		} else if(form.password.value == "") { // 비밀번호 미입력시
			alert('비밀번호를 입력하세요.');
			form.password.focus() ;
			return ;
		} else if(form.password.value.length < 10 || form.password.value.length > 16) { // 비밀번호 글자수 틀릴시
			alert('비밀번호는 10 ~ 16자 사이로 입력하세요.');
			form.password.focus() ;
			return ;
		} else if(form.pwdCheck.value != form.password.value) {
			alert('비밀번호가 일치하지 않습니다.');
			form.pwdCheck.focus() ;
			return ;
		} else if(form.email.value == "") {
			alert('e-mail을 입력하세요.');
			form.email.focus() ;
			return ;
		} else if(emailchk.hasClass("correct") ==false) {
			alert('e-mail인증을 완료하세요.');
			form.mailcodeChk.focus() ;
			return ;
		}  else if(form.phoneNum.value == "") {
			alert('휴대폰 번호를 입력하세요.');
			form.phoneNum.focus() ;
			return ;
		} else if(form.zipNum.value == "") {
			alert('우편번호를 입력하세요.');
			form.zipNum.focus() ;
			return ;
		} else if(form.address.value == "") {
			alert('주소를 입력하세요.');
			form.address.focus() ;
			return ;
		} else {
			alert('회원가입이 완료되었습니다.');
			$("#join").attr("action", "joinAction").submit();
		}
		form.reset();
	}
}
	
	/**
	 *  아이디, 비밀번호 찾기 관련 스크립트 참수
	 */
	function findInfoForm() {
		var url = "findIdForm";
		window.open(url, "_blank_1", 
				"width=700, height=650, left=500, top=100");
	}
	function findPwdForm() {
		var url = "findPasswordForm";
		window.open(url, "_blank_1", 
				"width=700, height=650, left=500, top=100");
	}
	/*
	 * 아이디를 찾기 위해 find_pwd URL 요청 전송
	 * 이름, 이메일, 전화번호가 입력되었는지 확인
	 */
	function findMemberId() {
		/* 이름과 이메일 입력 확인 */
		if ($("#name").val() == "") {
			alert("이름을 입력해 주세요!");
			$("#name").focus();
		} else if ($("#email").val() == "") {
			alert("이메일을 입력해 주세요!");
			$("#email").focus();
		} else if ($("#phoneNum").val() == "") {
			alert("전화번호를 입력해 주세요!");
			$("#phoneNum").focus();
		} else {
			$("#findId").attr("action", "findIdAction").submit();
		}
	}
	/*
	 * 비밀번호를 찾기 위해 find_pwd URL 요청 전송
	 * 이름, 이메일, 전화번호가 입력되었는지 확인
	 */
	function findMemberPwd() {
		/* 이름과 이메일 입력 확인 */
		if ($("#name").val() == "") {
			alert("이름을 입력해 주세요!");
			$("#name").focus();
		} else if ($("#id").val() == "") {
			alert("아이디를 입력해 주세요!");
			$("#id").focus();
		} else if ($("#email").val() == "") {
			alert("이메일을 입력해 주세요!");
			$("#email").focus();
		} else if ($("#phoneNum").val() == "") {
			alert("전화번호를 입력해 주세요!");
			$("#phoneNum").focus();
		} else {
			$("#findPwd").attr("action", "findPasswordAction").submit();
		}
	}

	/*
	 * 아이디, 이름, 비밀번호를 입력하여 비밀번호 찾기 요청
	 */
	function findPassword() {

		if ($("#id2").val() == "") {
			alert("아이디를 입력해 주세요!");
			$("#id2").focus();
		} else if ($("#name2").val() == "") {
			alert("이름을 입력해 주세요!");
			$("#name2").focus();
		} else if ($("#email2").val() == "") {
			alert("이메일을 입력해 주세요!");
			$("#email2").focus();
		} else {
			$("#findPW").attr("action", "find_password").submit();
		}
	}
	
	/* 공지사항 */
	function noticeWrite(){
		var chk = confirm("공지사항을 등록하시겠습니까?");
		if(chk){
			alert("등록이 완료되었습니다.");
		}
	}
	function noticeDelete(noticeNum){ // 공지사항삭제
		var chk = confirm("공지사항을 삭제하시겠습니까?");
		if(chk){
			location.href="deleteNotice?noticeNum="+noticeNum;
			alert("삭제가 완료되었습니다.");
		}
	}
	function noticeUpdate(){ // 공지사항수정
		var chk = confirm("공지사항을 수정하시겠습니까?");
		if(chk){
			alert("수정이 완료되었습니다.");
		}
	}
