<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<c:if test="${loginMember.memberType eq '0'}">
	<%@ include file="../admin/member/sidemenu.jsp"%>
</c:if>
<form name="formm" class="noticeList" method="post">
	<h2>공지사항</h2>
	<table>
		<tr class="titleline">
			<th>제목</th>
			<th>작성일</th>
			<th>작성자</th>
		</tr>
		<c:forEach items="${getNoticeList}" var="noticeDTO">
			<tr style="text-align: center;">
				<td><a href="getNoticeDetail?noticeNum=${noticeDTO.noticeNum}"> ${noticeDTO.title} </a></td>
				<td>${noticeDTO.indate}</td>
				<td>${noticeDTO.name}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${loginMember.memberType eq '0'}">
		<input type="button" value="공지사항등록" class="submit" onclick="location.href='noticeWriteForm'">
	</c:if>
</form>

<%@ include file="../footer.jsp"%>
