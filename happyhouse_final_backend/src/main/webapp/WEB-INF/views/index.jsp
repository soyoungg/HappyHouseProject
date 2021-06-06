<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Happy House</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${root }/style.css">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
</head>
<body>
	<div class="wrap">
		<!-- 상단 nav -->
		<nav class="nav">
			<!-- 왼쪽 메뉴 -->
			<div>
				<ul class="lists navlist">
					<li><a href="#">공지사항</a></li>
					<li><a href="#">오늘의 뉴스</a></li>
					<li><a href="#">주변 탐방</a></li>
					<c:if test="${userinfo != null}">
						<li><a href="${root }/???">관심 지역 설정</a></li>
						<li><a href="${root }/???">관심 지역 둘러보기</a></li>
					</c:if>
				</ul>
			</div>
			<!-- 오른쪽 메뉴 -->
			<div>
				<ul class="lists navlist">
					<c:if test="${userinfo == null}">
						<li><a href="${root }/user/login">로그인</a></li>
						<li><a href="${root }/user/regist">회원가입</a></li>
					</c:if>
					<c:if test="${userinfo != null}">
						<li><a href="${root }/user/logout">로그아웃</a></li>
						<li><a href="${root }/user/mypage">마이페이지</a></li>
					</c:if>
				</ul>
			</div>
		</nav>
		<!-- 중단 content -->
		<div class="main-content">
			<h1>행복한 우리 집</h1>
			<!-- 이미지 -->
			<div class="main-img">
			</div>
			<!-- 검색 메뉴 -->
			<div class="search">
				<a href="${root }/user/citysearch">시도별 검색</a>
				<a href="${root }/user/aptsearch">아파트별 검색</a>
			</div>
		</div>
		<!-- 하단 footer -->
		<footer>
			<div class="foot">
				<ul class="lists">
					<li><a href="#">개인정보처리방침</a></li>
					<li><a href="#">이용약관</a></li>
					<li><a href="#">오시는길</a></li>
					<li>© SSAFY	Corp.</li>
				</ul>
			</div>
		</footer>
	</div>
</body>
</html>