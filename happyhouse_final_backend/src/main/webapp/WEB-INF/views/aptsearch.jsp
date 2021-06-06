<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:set var="root" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Happy House</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${root }/style.css">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#searchAPT").click(function(){
			if($("#aptName").val() == ""){
				alert("값을 입력하세요");
				return;
			} else{
				let aptinfo = JSON.stringify({
					"apt": $("#aptName").val()
				});
				
				$.ajax({
					url:'${root}/apt/apt_list',
					type:'POST',
					contentType:'application/json;charset=utf-8',
					dataType:'json',
					data: aptinfo,
					success:function(apts){
						makeList(apts);
					},
					error:function(xhr,status,msg){
						console.log("상태값 : " + status + " Http에러메시지 : "+msg);
					}
				});
			}
		});
	});

	function makeList(apts) {
			$("#aptlist").empty();
			$(apts).each(function(index, apt) {
				
				let str = `
					<tr>
						<td>${'${apt.aptName}'}</td>
						<td>${'${apt.area}'}</td>
						<td>${'${apt.floor}'}</td>
						<td>${'${apt.dealYear}'}.${'${apt.dealMonth}'}.${'${apt.dealDay}'}</td>
						<td>${'${apt.dong}'} ${'${apt.jibun}'}</td>
					</tr>
				`;
				
				$("#aptlist").append(str);
			});
		}
</script>
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

		<!-- 중단 content -->
		<div class="apt-main">
			<div class="apt-title">아파트 이름으로 검색</div>
			<div>
				<form action= "" method="post" id="aptform">
					<input type="text" name="aptName" id="aptName">
					<button type="button" class="btn btn-primary" id="searchAPT">검색</button>
				</form>
			</div>		
		</div>
 		
 		<!-- 목록 출력 -->
		<div class="apt-list-container">
		  	<table class="apt-list-table">
		    	<thead>
			      	<tr>
			        	<th>아파트명</th>
			        	<th>면적</th>
			        	<th>층수</th>
			        	<th>거래일</th>
			        	<th>지번주소</th>
			      	</tr>
		    	</thead>
		    	<tbody id="aptlist">
		    	</tbody>
			</table>
		</div>
	</div>
</body>
</html>