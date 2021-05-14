<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script>
window.onload = function() {
	var json = JSON.parse('<%=request.getAttribute("speechResult") %>');
	var text = json.text;
	var result = document.getElementById("result");
	result.innerHTML += text;
}
</script>
<div id="result2"></div>
<textarea id="result" rows=5 cols=100>
mp3를 텍스트 변환 출력
</textarea><br>
<audio src="/faceimages/<%=request.getParameter("image") %>" controls="controls"></audio>
</body>
</html>