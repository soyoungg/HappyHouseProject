<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호찾기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${root }/style.css">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#Find").click(function() {
			if($("#userid").val() == "") {
				alert("아이디를 입력하세요");
				return;
			} else if($("#username").val() == "") {
				alert("이름을 입력하세요");
				return;
			} else {
				$("#findform").attr("action", "${root}/user/findPw").submit();
		
			}
		});
	});
	
</script>
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
				<c:if test="${userinfo == null}">
					<li><a href="${root }/user/regist">회원가입</a></li>
					<li><a href="${root }/">메인</a></li>
				</c:if>
				<c:if test="${userinfo != null}">
					<li><a href="${root }/user/logout">로그아웃</a></li>
					<li><a href="${root }/user/mypage">마이페이지</a></li>
					<li><a href="${root }/">메인</a></li>
				</c:if>
			</ul>
		</div>
	</nav>

	<div class="find-container">
		<div class="find-form">
			<form action="" method="post" id="findform">
				<label for="userid">ID:</label> 
				<input type="text" class="form-control" id="userid" name="userId">
				<label for="username">이름:</label> 
				<input type="text" class="form-control" id="username" name="userName">
				<button type="button" class="btn btn-primary find-btn" id="Find">비밀번호 찾기</button>
			</form>
		</div>
	</div>

	
</body>
</html>
