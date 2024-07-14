<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<%@ include file="css.jsp"%>

<html>
<head>
<title>KotaTour</title>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>

<body>
	<header>
		<div id="logo">
			<a href="/index"> <img src="images/logo.png">
			</a>
		</div>
		<c:choose>
			<c:when test="${empty sessionScope.loginMember}">
				<div id="go-login">
					<a href="loginForm">로그인</a> | <a href="contractForm">회원가입</a>
				</div>
				<div class="search3">
					<form id="searchForm" method="get">
						<select id="searchOption" class="form-control" name="searchOption">
							<!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
							<option value="all" <c:out value="${searchOption == 'all'?'selected':''}"/>>전체</option>
							<option value="title" <c:out value="${searchOption == 'title'?'selected':''}"/>>제목</option>
							<option value="content" <c:out value="${searchOption == 'content'?'selected':''}"/>>내용</option>
							<option value="id" <c:out value="${searchOption == 'id'?'selected':''}"/>>작성자</option>
						</select> <input type="text" id="keyword" name="keyword" class="form-control" placeholder="검색어를 입력하세요" autocomplete="off" value="${criteria.keyword}" />
						<button type="button" id="btnSearch" onclick="search()">검색</button>
					</form>
				</div>
				<div class="header-menu">
					<nav>
						<ul>
							<li class="dd">
								<div class="dd-menu" style="border-top: 2px solid red; padding: 5px;">
									<a href="book_list_cate1?cate1=d">여행정보</a>
								</div>
								<div class="dd-content">
									<a href="book_list_cate2?cate1=d&cate2=1">관광지도</a> <a href="book_list_cate2?cate1=d&cate2=2">월별 날씨</a> <a href="book_list_cate2?cate1=d&cate2=3">월별 축제</a>
								</div>
							</li>
							<li class="dd">
								<div class="dd-menu" style="border-top: 2px solid orange; padding: 5px;">
									<a href="book_list_cate1?cate1=f">패키지</a>
								</div>
								<div class="dd-content">
									<a href="book_list_cate2?cate1=f&cate2=1">반딧불이 투어</a> <a href="book_list_cate2?cate1=f&cate2=2">시티 투어</a> <a href="book_list_cate2?cate1=f&cate2=3">섬 투어</a>
								</div>
							</li>
							<li class="dd">
								<div class="dd-menu" style="border-top: 2px solid blue; padding: 5px;">
									<a href="bestSeller">자유게시판</a>
								</div>
							</li>
							<li class="dd">
								<div class="dd-menu" style="border-top: 2px solid purple; padding: 5px;">
									<a href="#" style="cursor: default;">service</a>
								</div>
								<div class="dd-content">
									<a href="getNoticeList">공지사항</a> <a href="getQnaList">QnA</a>
								</div>
							</li>
						</ul>
					</nav>
				</div>
			</c:when>
			<c:when test="${loginMember.memberType=='1'}">
				<div id="go-login">${sessionScope.loginMember.id}님
					환영합니다. &nbsp;&nbsp;&nbsp; <a href="logoutAction">로그아웃</a> | <a href="memberDetailForm">마이페이지</a>
				</div>
				<div class="search3">
					<form id="searchForm" method="get">
						<select id="searchOption" class="form-control" name="searchOption">
							<!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
							<option value="all" <c:out value="${searchOption == 'all'?'selected':''}"/>>전체</option>
							<option value="title" <c:out value="${searchOption == 'title'?'selected':''}"/>>제목</option>
							<option value="content" <c:out value="${searchOption == 'content'?'selected':''}"/>>내용</option>
							<option value="id" <c:out value="${searchOption == 'id'?'selected':''}"/>>작성자</option>
						</select> <input type="text" id="keyword" name="keyword" class="form-control" placeholder="검색어를 입력하세요" autocomplete="off" value="${criteria.keyword}" />
						<button type="button" id="btnSearch" onclick="search()">검색</button>
					</form>
				</div>
				<div class="header-menu">
					<nav>
						<ul>
							<li class="dd">
								<div class="dd-menu" style="border-top: 2px solid red; padding: 5px;">
									<a href="book_list_cate1?cate1=d">여행정보</a>
								</div>
								<div class="dd-content">
									<a href="book_list_cate2?cate1=d&cate2=1">관광지도</a> <a href="book_list_cate2?cate1=d&cate2=2">월별 날씨</a> <a href="book_list_cate2?cate1=d&cate2=3">월별 축제</a>
								</div>
							</li>
							<li class="dd">
								<div class="dd-menu" style="border-top: 2px solid orange; padding: 5px;">
									<a href="book_list_cate1?cate1=f">패키지</a>
								</div>
								<div class="dd-content">
									<a href="book_list_cate2?cate1=f&cate2=1">반딧불이 투어</a> <a href="book_list_cate2?cate1=f&cate2=2">시티 투어</a> <a href="book_list_cate2?cate1=f&cate2=3">섬 투어</a>
								</div>
							</li>
							<li class="dd">
								<div class="dd-menu" style="border-top: 2px solid blue; padding: 5px;">
									<a href="bestSeller">자유게시판</a>
								</div>
							</li>
							<li class="dd">
								<div class="dd-menu" style="border-top: 2px solid purple; padding: 5px;">
									<a href="#" style="cursor: default;">service</a>
								</div>
								<div class="dd-content">
									<a href="getNoticeList">공지사항</a> <a href="getQnaList">QnA</a>
								</div>
							</li>
						</ul>
					</nav>
				</div>
			</c:when>
			<c:otherwise>
				<div id="go-login">
					${sessionScope.loginMember.name}님 환영합니다. &nbsp;&nbsp;&nbsp; <a href="logoutAction">로그아웃</a> | <a href="adminMemberList">회원관리</a>
				</div>
				<div class="search3">
					<form id="searchForm" method="get">
						<select id="searchOption" class="form-control" name="searchOption">
							<!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
							<option value="all" <c:out value="${searchOption == 'all'?'selected':''}"/>>전체</option>
							<option value="title" <c:out value="${searchOption == 'title'?'selected':''}"/>>제목</option>
							<option value="content" <c:out value="${searchOption == 'content'?'selected':''}"/>>내용</option>
							<option value="id" <c:out value="${searchOption == 'id'?'selected':''}"/>>작성자</option>
						</select> <input type="text" id="keyword" name="keyword" class="form-control" placeholder="검색어를 입력하세요" autocomplete="off" value="${criteria.keyword}" />
						<button type="button" id="btnSearch" onclick="search()">검색</button>
					</form>
				</div>
				<div class="header-menu">
					<nav>
						<ul>
							<li class="dd">
								<div class="dd-menu" style="border-top: 2px solid red; padding: 5px;">
									<a href="book_list_cate1?cate1=d">여행정보</a>
								</div>
								<div class="dd-content">
									<a href="book_list_cate2?cate1=d&cate2=1">관광지도</a> <a href="book_list_cate2?cate1=d&cate2=2">월별 날씨</a> <a href="book_list_cate2?cate1=d&cate2=3">월별 축제</a>
								</div>
							</li>
							<li class="dd">
								<div class="dd-menu" style="border-top: 2px solid orange; padding: 5px;">
									<a href="book_list_cate1?cate1=f">패키지</a>
								</div>
								<div class="dd-content">
									<a href="book_list_cate2?cate1=f&cate2=1">반딧불이 투어</a> <a href="book_list_cate2?cate1=f&cate2=2">시티 투어</a> <a href="book_list_cate2?cate1=f&cate2=3">섬 투어</a>
								</div>
							</li>
							<li class="dd">
								<div class="dd-menu" style="border-top: 2px solid blue; padding: 5px;">
									<a href="bestSeller">자유게시판</a>
								</div>
							</li>
							<li class="dd">
								<div class="dd-menu" style="border-top: 2px solid purple; padding: 5px;">
									<a href="#" style="cursor: default;">service</a>
								</div>
								<div class="dd-content">
									<a href="getNoticeList">공지사항</a> <a href="getQnaList">QnA</a>
								</div>
							</li>
						</ul>
					</nav>
				</div>
			</c:otherwise>
		</c:choose>

	</header>