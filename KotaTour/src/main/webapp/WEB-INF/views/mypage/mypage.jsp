<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sidemenu.jsp"%>

<div style="margin-top: 100px;">
	<form method="post" id="mypage" action="updateMemberForm?id=${member.id}" name="formm" autocomplete="off" style="margin-top: 200px;">
		<div class="container">
			<div class="insert">
				<table class="join">
					<tr>
						<td class="col1" style="width: 100px; font-size: 15px; font-weight: bold; text-align: center;">Name</td>
						<td class="col2" style="width: 500px; padding-left: 20px; font-size: 15px;">${member.name}</td>
					</tr>
					<tr>
						<td class="col1" style="width: 100px; font-size: 15px; font-weight: bold; text-align: center;">ID</td>
						<td class="col2" style="width: 500px; padding-left: 20px; font-size: 15px;">${member.id}</td>
					</tr>
					<tr>
						<td class="col1" style="width: 100px; font-size: 15px; font-weight: bold; text-align: center;">E-Mail</td>
						<td class="col2" style="width: 500px; padding-left: 20px; font-size: 15px;">${member.email}</td>
					</tr>
					<tr>
						<td class="col1" style="width: 100px; font-size: 15px; font-weight: bold; text-align: center;">Phone</td>
						<td class="col2" style="width: 500px; padding-left: 20px; font-size: 15px;">${member.phoneNum}</td>
					</tr>
					<tr>
						<td class="col1" style="width: 100px; font-size: 15px; font-weight: bold; text-align: center;">Address</td>
						<td class="col2" style="width: 500px; padding-left: 20px; font-size: 15px;">[${member.zipNum}]&nbsp;${member.address}</td>
					</tr>
				</table>
			</div>
			<div class="create">
				<input class="but4" type="submit" value="정보수정"> 
				<input class="but3" type="button" id="deleteMember" value="회원탈퇴" onclick="location.href='deleteMember?id=${member.id}'">
			</div>
		</div>
	</form>
</div>
<%@ include file="../footer.jsp"%>
