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
$(document).ready(function(){
	
});
</script>
</head>
<body>
<style>
 body {
 background-color: aqua;
 }
 #title {
 	border : 2px solid blue;
 	border-radius: 7px; 	
 	text-align: center;
 	text-shadow: 2px 2px 2px gray;
 	color: green;
 	margin: auto;
 	width: 500px;
 	box-shadow: -5px -5px 5px red;
 }
 
 #content {
 	text-align: center;
 }
 table {
 	margin: auto;
 	background-color: gray;
 }
 table caption {
 	color: gray;
 }
</style>
<h1 id="title">boardlist를 출력합니다</h1>
<div id=search_form>
<form action="boardsearch.html" method="get">	
<select label="제목">
	<optgroup label="제목" >
		<option> 제목1</option>
		<option> 제목2</option>
		<option> 제목3</option>
		<option> 제목4</option>
	</optgroup>
</select>
	검색어:
	<input type=text>
	<input type=submit value="검색" src="boardsearch.html">
</form>
</div>
<br>
<div id="content">
	<table border="3">
		<caption><tr><td>번호</td><td>제목</td><td>작성자</td><td>조회수</td></tr></caption>
		<c:forEach items="${boardlist}" var="board">
		<tr><td>${board.seq}</td><td><a href="<%=request.getContextPath() %>/board/detail?seq=${board.seq}">${board.title}</a></td><td>${board.writer}</td><td>${board.viewcount}</td></tr>
		</c:forEach>
		</table>
	<h2>페이지번호</h2>
	<span><a href="/semi/board/list?page=1">1&nbsp;</a></span>
	<span><a href="/semi/board/list?page=2">2&nbsp;</a></span>
	<span><a href="/semi/board/list?page=3">3&nbsp;</a></span>
	<span><a href="/semi/board/list?page=4">4&nbsp;</a></span><br>
	<input type=button value="글쓰기" onclick="location.href='/semi/board/write'">
	<input type=button value="로그아웃" onclick="location.href='/semi/login'">
</div>
</body>
</html>