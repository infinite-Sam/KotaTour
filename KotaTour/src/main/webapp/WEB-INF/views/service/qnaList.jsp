<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<form name="formm" class="qnaList" method="post" style="min-height: 600px;">
	<h2>자주묻는질문</h2>
	<table id="andList">
		<tr class = "titleline">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
		<c:forEach items="${aqnaList}" var="aqndDTO">
			<tr style="text-align: center;">
				<td>${aqndDTO.aqseq}</td>
				<td><a href="aqna_view?aqseq=${aqndDTO.aqseq}"> ${aqndDTO.title} </a></td>
				<td>${aqndDTO.name} </td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${loginMember.memberType=='0'}">
		<input type="button" value="등록하기" class="submit"
		onclick="location.href='aqnaWriteForm'">
	</c:if>
	
	<c:if test="${loginMember.memberType=='1'}">
	<h2 style="position: relative; margin-top: 30px;">문의내역</h2>
	<table id="andList">
		<tr class="titleline">
			<th><span style="margin-left: 170px;">제목</span></th>
			<th>등록일</th>
			<th>답변 여부</th>
		</tr>
		<c:forEach items="${qnaList}" var="qnaDTO">
			<tr style="text-align: center;">
				<td><a href="qna_view?qseq=${qnaDTO.qseq}"><span style="margin-left: 170px;">${qnaDTO.title}</span></a></td>
				<td>${qnaVO.indate}</td>
				<td><c:choose>
						<c:when test="${qnaDTO.rep==1}"> no </c:when>
						<c:when test="${qnaDTO.rep==2}"> yes </c:when>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>
		<input type="button" value="문의하기" class="submit"
		onclick="location.href='qnaWriteForm'">
	</c:if>
</form>
<%@ include file="../footer.jsp"%>