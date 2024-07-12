<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<form id="join" action="joinForm" method="post" name="formm" style="margin-top: 80px;">
	<table style="width: 100%; text-align: center;">
		<tr>
			<td align=center>
				<div class="stepLine">
					<div title="이용약관" class="stepDot activeStep"></div>
					<div title="정보입력" class="stepDot"></div>
					<div title="가입완료" class="stepDot"></div>
				</div> <br>
			<br>
			<br>
			</td>
		</tr>

		<tr>
			<td align=center>
				<!--이용약관 테이블 시작-->
				<table>
					<tr>
						<td>
							<div>
								<font color="#f67001" size=4>01</font> <font size=3>이용약관</font>
							</div>
						</td>
					</tr>
					<tr>
						<td align=center><textarea name="tos" rows=15 cols=100>
제 1 조 (목적) 
이 이용약관(이하 '약관')은 주식회사 KotaTour(이하 회사라 합니다)와 이용 고객(이하 '회원')간에 회사가 제공하는 서비스의 가입조건 및 이용에 관한 다음의 제반 사항과 기타 기본적인 사항을 구체적으로 규정함을 목적으로 합니다.

제 2 조 (이용약관의 효력 및 변경) 
(1) 이 약관은 KotaTour 웹사이트(www.KotaTour.com 이하 'KotaTour 웹')에서 온라인으로 공시함으로써 효력을 발생하며, 합리적인 사유가 발생할 경우 관련법령에 위배되지 않는 범위 안에서 개정될 수 있습니다. 개정된 약관은 온라인에서 공지함으로써 효력을 발휘하며, 이용자의 권리 또는 의무 등 중요한 규정의 개정은 사전에 공지합니다.
(2) 회사는 합리적인 사유가 발생될 경우에는 이 약관을 변경할 수 있으며, 약관을 변경할 경우에는 지체 없이 이를 사전에 공시합니다.
(3) 이용고객은 변경된 약관에 동의하지 않으면, 언제나 "서비스" 이용을 중단하고, 이용계약을 해지할 수 있습니다. 약관의 효력발생일 이후의 계속적인 "서비스" 이용은 약관의 변경사항에 대한 이용고객의 동의로 간주됩니다.

제 3 조 (약관외 준칙) 
(1) 이 약관은 회사가 제공하는 개별서비스에 관한 이용안내(이하 서비스별 안내라 합니다)와 함께 적용합니다.
(2) 이 약관에 명시되지 아니한 사항에 대해서는 별도의 세부 약관, 상관행, 회사의 공지, 이용안내, 관계법령 및 서비스별 안내의 취지에 따라 적용할 수 있습니다. 

제 4 조 (용어의 정의) 
(1) "이용자" 또는”회원”이란 "KotaTour"에 접속하여 본 약관에 따라 "KotaTour"에 가입하여, 이용 고객의 식별과 이용고객의 서비스 이용을 위하여 이용고객 본인이 직접 선정하고 회사가 부여하는 문자와 숫자 조합인 ‘이용자번호(ID)’와 그에 따라 일치된 이용고객임을 확인하기 위하여 이용고객 본인이 선정한 ‘비밀번호’를 이용하여 "JSTL"이 제공하는 서비스를 받는 자를 말합니다.
(2) 이 약관에서 사용하는 용어의 정의는 제1항에서 정하는 것을 제외하고는 관계법령 및 서비스별 안내에서 정하는 바에 의합니다. 

제 2 장 이용계약 체결

제 5 조 (이용 계약의 성립)
(1) 이용계약은 이용고객의 본 이용약관 내용에 대한 동의와 이용신청에 대하여 회사의 이용승낙으로 성립하여 이용약관에 대한 동의는 이용신청 당시 해당 JSTL 웹의 '동의함' 버튼을 누름으로써 의사표시를 합니다.

제 6 조 (서비스 이용 신청) 
(1) 회원으로 가입하여 본 서비스를 이용하고자 하는 이용고객은 회사에서 요청하는 제반 정보(이름, 주민등록번호, 연락처 등)를 제공하여야 합니다.
(2) 모든 회원은 반드시 회원 본인의 이름과 주민등록번호를 제공하여야만 서비스를 이용할 수 있으며, 실명으로 등록을 한 사용자만이 권리를 주장할 수 없습니다.
(3) 회원가입은 반드시 실명으로만 가입할 수 있습니다.
(4) 타인의 명의(이름 및 주민등록번호)를 도용하여 이용신청을 한 회원의 모든 ID는 삭제되며, 관계법령에 따라 처벌을 받을 수 있습니다. 
(5) 회사는 본 서비스를 이용하는 회원에 대하여 등급별로 구분하여 이용시간, 이용회수, 서비스 메뉴 등을 세분하여 이용에 차등을 둘 수 있습니다.

-- 이하생략
                </textarea></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="agree">이용약관에 동의합니다.<br>
						<br>
						<br></td>
					</tr>
					<tr>
						<td>
							<div>
								<font color="#f67001" size=4>02</font> <font size=3>개인정보 수집 및 이용에 대한 안내</font>
							</div>
						</td>
					</tr>
					<tr>
						<td align=center><textarea name="tos" rows=15 cols=100>
1. 개인정보 수집항목 및 수집목적
회사는 고객에게 서비스 제공에 관한 계약이행 및 주문에 대한 관리, 관계법령의 준수와 보다 나은 서비스를 위하여 개인정보를 수집하고 있으며,
수집항목 및 목적은 다음과 같습니다.
① 수집항목
- 물품주문시 : 성명, 주소, 전화번호, 이메일주소, 주문비밀번호와 물품수령인의 성명, 배송주소, 전화번호
- 대금결제시 : 은행계좌정보 또는 신용카드정보
- 현금영수증 발급시 : 전화번호
- 주문정보 확인시 : 방문일시, 거래내역
② 수집목적
- 서비스 제공에 관한 계약이행 : 요금정산, 배송, 고객상담 및 민원처리
- 주문관리 : 본인확인, 개인식별, 분쟁조정을 위한 기록보존, 불만처리, 고지사항 전달
- 마케팅 활용 : 서비스 이용 통계, 접속빈도 파악
- 법령의 준수 : 서비스와 관련하여 법령에 따른 기록의 보존 및 제공

2. 개인정보 보유 및 이용기간
회사는 거래완결시까지 관계법령(전자상거래 등에서의 소비자보호에 관한 법률 등)에 따라 회사가 개인정보 및 기록보유 의무나 권한을 가진 기간
동안 개인정보를 보유하고 이용하게 됩니다.,
① 계약 및 청약철회 등에 관한 기록 : 5년
② 대금결제 및 재화 등의 공급에 관한 기록 : 5년
③ 소비자의 불만 또는 분쟁처리에 관한 기록 : 3년
④ 표시, 광고에 관한 기록 : 6개월
3. 개인정보 파기절차 및 그 방법
고객의 개인정보는 원칙적으로 개인정보의 수집 및 이용목적이 달성되면 지체없이 파기합니다.
회사의 개인정보 파기절차 및 방법은 다음과 같습니다.
① 파기절차
- 고객이 입력한 정보는 목적이 달성된 후 별도의 DB로 옮겨져(종이의 경우 별도의 서류함) 내부 방침 및 기타 관련 법령에 의한 정보보호 사유에 따라(보유 및 이용기간 참조) 일정 기간 저장된후 파기됩니다.
② 파기방법- 전자적 파일 형태로 저장된 개인정보는 기록을 재생할 수 없는 기술적 방법을 사용하여 삭제합니다.
- 종이에 출력된 개인정보는 분쇄기로 분쇄하거나 소각을 통하여 파기합니다.

--이하 생략
                </textarea></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="agree">개인정보 수집 및 이용에 대한 안내에 동의합니다.</td>
					</tr>
				</table>

			</td>
		</tr>
	</table>

	<br> <br>
	<div class="contractbtn">
		<input type="button" value="약관동의" class="but4" class="submit" onclick="go_next()">
		<button type="button" class="but3" style="margin: 10px;" onclick="window.history.back()">취소</button>
	</div>
</form>


<%@ include file="../footer.jsp"%>
