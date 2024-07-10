<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<c:if test="${loginMember.memberType eq '0'}">
	<%@ include file="../admin/member/sidemenu.jsp" %>
</c:if>
<form name="formm" class="qnaList" method="post"
	style="min-height: 600px;">
	<h2>자주묻는질문</h2>
	<table id="andList">
		<tr class="titleline">
			<th>제목</th>
			<th>작성자</th>
		</tr>
		<c:forEach items="${aqnaList}" var="aqndDTO">
			<tr style="text-align: center;">
				<td><a href="getAqnaDetail?aqnaNum=${aqndDTO.aqnaNum}">
						${aqndDTO.title} </a></td>
				<td>${aqndDTO.name}</td>
			</tr>
		</c:forEach>
	</table>
	<!-- admin으로 로그인시 -->
	<c:if test="${loginMember.memberType=='0'}">
		<input type="button" value="등록하기" class="submit"
			onclick="location.href='aqnaWriteForm'">
		<h2 style="position: relative; margin-top: 30px;">전체 회원 문의 내역</h2>
		<table id="andList">
			<tr class="titleline">
				<th><span style="margin-left: 170px;">제목</span></th>
				<th>등록일</th>
				<th>작성자</th>
				<th>답변 여부</th>
			</tr>
			<c:forEach items="${getMemberQnaList}" var="qnaDTO">
				<tr style="text-align: center;">
					<td><a href="getQnaDetail?qnaNum=${qnaDTO.qnaNum}">
					<span style="margin-left: 170px;">${qnaDTO.title}</span></a></td>
					<td>${qnaDTO.indate}</td>
					<td>${qnaDTO.id}</td>
					<td><c:choose>
							<c:when test="${qnaDTO.rep==1}"> no </c:when>
							<c:when test="${qnaDTO.rep==2}"> yes </c:when>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<!-- 일반회원 로그인시 -->
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
					<td><a href="getQnaDetail?qnaNum=${qnaDTO.qnaNum}"><span
							style="margin-left: 170px;">${qnaDTO.title}</span></a></td>
					<td>${qnaDTO.indate}</td>
					<td><c:choose>
							<c:when test="${qnaDTO.rep==1}"> 답변대기중 </c:when>
							<c:when test="${qnaDTO.rep==2}"> 답변완료 </c:when>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
		<input type="button" value="문의하기" class="submit"
			onclick="location.href='qnaWriteForm'">
	</c:if>
</form>
<%@ include file="../footer.jsp"%>