<%@page import="java.math.BigDecimal"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% 
String[] filelist = (String[])request.getAttribute("filelist"); 
for(String file : filelist) {
%>
	<a href="http://127.0.0.1:9091/face2?image=<%=file%>"><%=file%>(���ν�)</a>
	<%-- <img alt="<%file%>" src="resources/static/images/"<%=file%>><br> <!-- �ش����� �̹��� ��� -->--%> 
	<img src="/faceimages/<%=file%>" width=200px><br>
<%
}
%>

<h1>${fileInput}</h1>
<a href="http://127.0.0.1:9091/face?file=${fileInput}">��������</a>
</body>
</html>