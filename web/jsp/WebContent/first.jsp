<%@ page 
language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.util.Date"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="http:/jquery/jquery-3.2.1.min.js"></script>
</script>
</head>
<body>
<h1> jsp 파일입니다.</h1>
<h3> 
<%
	Date now = new Date();
	out.println(now);
%></h3>
</body>
</html>