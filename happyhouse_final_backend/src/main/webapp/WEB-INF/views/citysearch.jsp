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

	$(document).ready(function (){
		
	
		$.ajax({
			url:'${root}/apt/city_list',
			type:'POST',
			contentType:'application/json;charset=utf-8',
			dataType:'json',
			success:function(city){
				console.log(city);
				makeCity(city);
			},
			error:function(xhr,status,msg){
				console.log("상태값 : " + status + " Http에러메시지 : "+msg);
			}
		});

		
		$("#city").change(function(){
			$("#gugun").empty();
			let cityname = JSON.stringify({
				"city" : $("#city").val()
			}); 
				
			$.ajax({
				url:'${root}/apt/gugun_list',
				type:'POST',
				contentType:'application/json;charset=utf-8',
				dataType:'json',
				data: cityname,
				success:function(gugun){
					makeGugun(gugun);
				},
				error:function(xhr,status,msg){
					console.log("상태값 : " + status + " Http에러메시지 : "+msg);
				}
			});

		});
		
		$("#gugun").change(function(){
			let gugunname = JSON.stringify({
				"city" : $("#city").val(),
				"gugun" : $("#gugun").val()
			}); 
				
			$.ajax({
				url:'${root}/apt/dong_list',
				type:'POST',
				contentType:'application/json;charset=utf-8',
				dataType:'json',
				data: gugunname,
				success:function(dong){
					makeDong(dong);
				},
				error:function(xhr,status,msg){
					console.log("상태값 : " + status + " Http에러메시지 : "+msg);
				}
			});
		});
		
		$("#dong").change(function(){
			let cityinfo = JSON.stringify({
				"city" : $("#city").val(),
				"gugun" : $("#gugun").val(),
				"dong" : $("#dong").val()
			}); 
				
			$.ajax({
				url:'${root}/apt/apart_list',
				type:'POST',
				contentType:'application/json;charset=utf-8',
				dataType:'json',
				data: cityinfo,
				success:function(apts){
					console.log(apts);
					makeList(apts);
				},
				error:function(xhr,status,msg){
					console.log("상태값 : " + status + " Http에러메시지 : "+msg);
				}
			});
		});
    });
	
	function makeCity(items) {

		$("#city").remove(".option");
		$(items).each(function(index, items){
			
			let str = `
				<option>${'${items}'}</option>
			`;
			
			$("#city").append(str);
			
		});
	};
	
	
	function makeGugun(items) {

		$("#gugun").remove(".option");
		$(items).each(function(index, items){
			
			let str = `
				<option>${'${items}'}</option>
			`;
			
			$("#gugun").append(str);
			
		});
	};
	
	function makeDong(items) {

		$("#dong").remove(".option");
		$(items).each(function(index, items){
			
			let str = `
				<option>${'${items}'}</option>
			`;
			
			$("#dong").append(str);
			
		});
	};
	
	function makeList(apts) {
		$("#citylist").empty();
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
			
			$("#citylist").append(str);
		});
	};
	
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
		
		<!-- container 시작 -->
		<div class="city-main">
			<div class="city-title">시/도 별 검색</div>
			<div class="select-list">
				<div>
					<select id="city">
						<option class=".option">--시도선택--</option>	
					</select>
				</div>
				<div>
					<select id="gugun">
						<option class=".option">--구군선택--</option>	
					</select>
				</div>
				<div>
					<select id="dong">
						<option class=".option">--동선택--</option>
					</select>
				</div>
			</div>
		</div>
			
		<!-- 목록 출력 -->
		<div class="city-list-container">
		  	<table class="city-list-table">
		    	<thead>
			      	<tr>
			        	<th>아파트명</th>
			        	<th>면적</th>
			        	<th>층수</th>
			        	<th>거래일</th>
			        	<th>지번주소</th>
			      	</tr>
		    	</thead>
		    	<tbody id="citylist">
		    	</tbody>
			</table>
		</div>
	</div>
</body>
</html>