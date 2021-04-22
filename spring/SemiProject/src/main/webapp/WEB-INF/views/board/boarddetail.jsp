<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
li{background-color:pink;
margin : auto;
width : 300px;}
</style>
<script src="<%=request.getContextPath() %>/resources/jquery-3.2.1.min.js"></script>
<script>

</script>
</head>
<body>
<h1 id="title">boarddetail를 출력합니다</h1>

<br>
<div id="content">
	<table border="3">
		<caption><tr><td>번호</td><td>제목</td><td>작성자</td><td>조회수</td></tr></caption>
		
		<tr><td>${dto.seq}</td><td>${dto.title}</td><td>${dto.writer}</td><td>${dto.viewcount}</td></tr>
		
		</table>
		<h3>${dto.contents}</h3>		
	<h2>페이지번호</h2>
	<span><a href="boardlist">1&nbsp;</a></span>
	<span><a href="boardlist">2&nbsp;</a></span>
	<span><a href="boardlist">3&nbsp;</a></span>
	<span><a href="boardlist">4&nbsp;</a></span>
</div>
</body>
</html>