<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div class="noticeWrap">
	<form name="formm" class="noticeDetail" method="post">
		<h1>공지사항</h1>
		<div class="noticeTitle">
			<h2>${noticeDTO.title}</h2>
			<p>${noticeDTO.name}&nbsp; | &nbsp; ${noticeDTO.indate}
			<p>
		</div>
		<div class="noticeContent">${noticeDTO.content}</div>
		<div id="buttons">
			<input type="button" value="목록보기" class="submit"
				onclick="location.href='getNoticeList'">
				<c:if test="${loginMember.memberType eq '0'}">
					<input type="button" value="수정" class="submit"
						onclick="location.href='updateNoticeForm?noticeNum=${noticeDTO.noticeNum}'">
					<input type="button" value="삭제" class="submit"
						onclick="noticeDelete(${noticeDTO.noticeNum})">
				</c:if>
		</div>
	</form>
</div>
<%@ include file="../footer.jsp"%>