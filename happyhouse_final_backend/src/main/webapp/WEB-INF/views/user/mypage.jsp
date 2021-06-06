<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${root }/style.css">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
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
				<li><a href="${root }/user/logout">로그아웃</a></li>
				<li><a href="${root }/">메인</a></li>
			</ul>
		</div>
	</nav>
	<div class= "container">
		<div class="mypage-li">
	  		<h2>회원 정보 조회</h2>
	  		<h4>* id: ${userinfo.userId}</h4>
			<h4>* 이름: ${userinfo.userName}</h4>
			<h4>* 전화번호: ${userinfo.phone}</h4>
			<h4>* 이메일: ${userinfo.email}</h4>
			<div class="mypage-mv">
				<a href="${root }/user/modify">회원 정보 수정</a>
				<a href="${root }/user/delete_user">회원 탈퇴</a>
      		</div>
       </div>
	</div>	
</body>
</html>
