<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
});//ready end
</script>
</head>
<body>
<%
	String[] filelist = (String[])request.getAttribute("filelist");
	for(String file : filelist) {
		String [] file_split = file.split("[.]");
		String ext = file_split[file_split.length - 1];
		if(!(ext.equals("mp3") || ext.equals("text"))) {
		
%>
			<a href="/pose?image=<%=file%>"><%=file%>(얼굴인식)</a> <img src="/faceimages/<%=file%>" width=100 height=100><br>
<%
		}
	}
%>
</body>
</html>