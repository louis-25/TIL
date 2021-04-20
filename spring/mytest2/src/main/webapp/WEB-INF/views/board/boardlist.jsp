<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
li {
	background-color: pink;
	margin: auto;
	width:300px;
}
</style>
<script src="resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<h1>게시물 보여주기</h1>
<ul>
<c:forEach items="${boardlist}" var="board">
	<li>${board.seq}
	</li>
</c:forEach>

</ul>
</body>
</html>