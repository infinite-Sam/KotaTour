<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<%@ include file="sidemenu.jsp"%>
<form name="formm" class="qnaList" method="post">
	<h2 style="position: relative; margin-top: 30px;">회원관리</h2>
	<table id="andList">
		<tr class="titleline">
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>phone</th>
			<th></th>
		</tr>
		<c:forEach items="${memberList}" var="member">
			<c:if test="${member.memberType=='1'}">
				<tr style="text-align: center;">
					<td>${member.name}</td>
					<td>${member.id}</td>
					<td>${member.password}</td>
					<td>${member.email}</td>
					<td>${member.phoneNum}</td>
					<td><a href="adminDeleteMember?id=${member.id}">삭제</a></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</form>

<%@ include file="../../footer.jsp"%>
