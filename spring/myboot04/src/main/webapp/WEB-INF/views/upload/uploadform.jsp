<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<h1>파일 업로드폼 </h1>
<form action="<%=request.getContextPath() %>/fileupload"
method=post enctype="multipart/form-data">
전송자 <input type=text name="name" value="전송하는 사람"><br>
전송자 <input type=text name="description" value="파일 설명"><br>
파일명1 : <input type="file" name=file1><br>
파일명2 : <input type="file" name=file2><br>
<input type = submit value="파일전송">

</form>
</body>
</html>