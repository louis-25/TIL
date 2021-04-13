<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</script>
</head>
<body>
<h1>%{param.id} 회원님 로그인되었습니다.</h1>
<h1>암호는 %{param.pw} 입니다</h1>
${paramValues.location[0] }를 선택하셨습니다.
<%request.setCharacterEncoding("utf-8");
request.setAttribute("message", "정상적으로 저장되었습니다");%>
<jsp:forward page="el_loginform.jsp"/>
	

</body>
</html>