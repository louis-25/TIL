<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>

${requestScope.message}
<h1>로그인 폼</h1>
<form action="el_loginprocess.jsp" method="post"> <!-- http://127.0.0.1:9090/servlettest/login -->
아이디입력 : <input type=text name=id><br>
암호입력 : <input type=password name=pw><br>
로그인 가능 장소:
<input type=checkbox name="location" value="집">집
<input type=checkbox name="location" value="학교">학교
<input type=checkbox name="location" value="회사">회사
<input type=checkbox name="location" value="카페">카페

<input type=submit value="로그인버튼"><br>
</form>
</body>
</html>