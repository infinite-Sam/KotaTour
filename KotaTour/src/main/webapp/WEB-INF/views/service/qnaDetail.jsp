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
			<td>${qnaDTO.content}
		</tr>
		<tr>
			<th height="300px;">답변 내용</th>
			<td>${qnaDTO.reply}
		</tr>
	</table>
	<div class="clear"></div>
	<div id="buttons">
		<input type="button" value="목록보기" class="submit"
			onclick="location.href='getQnaList'">
		<input type="button" value="수정하기" class="submit"
			onclick="location.href='qnaUpdateForm?qnaNum=${qnaDTO.qnaNum}'">
		<input type="button" value="삭제하기" class="submit"
			onclick="qnaDelete(${qnaDTO.qnaNum})">
	</div>
</form>
<%@ include file="../footer.jsp"%>