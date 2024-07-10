<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<form name="formm" class="qnaDetail" method="post">
	<h2>QnA</h2>
	<table id="qna">
		<tr>
			<th width="100px">제목</th>
			<td>${qnaDTO.title}</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${qnaDTO.indate}</td>
		</tr>
		<tr>
			<th height="300px;">질문내용</th>
			<td>${qnaDTO.content}</td>
		</tr>
		<tr>
			<th height="300px;">답변 내용</th>
			<td>${qnaDTO.reply}</td>
		</tr>
	</table>
	<div class="clear"></div>
	<c:if test="${loginMember.memberType eq '1'}">
	<div id="buttons">
		<input type="button" value="목록보기" class="submit"
			onclick="location.href='getQnaList'">
		<input type="button" value="수정하기" class="submit"
			onclick="location.href='qnaUpdateForm?qnaNum=${qnaDTO.qnaNum}'">
		<input type="button" value="삭제하기" class="submit"
			onclick="qnaDelete(${qnaDTO.qnaNum})">
	</div>
	</c:if>
	<c:if test="${loginMember.memberType eq '0'}">
	<div id="buttons">
		<input type="button" value="목록보기" class="submit"
			onclick="location.href='getQnaList'">
		<input type="button" value="답변하기" class="submit"
			onclick="location.href='qnaAnswerForm?qnaNum=${qnaDTO.qnaNum}'">
	</div>
	</c:if>
</form>
<%@ include file="../footer.jsp"%>