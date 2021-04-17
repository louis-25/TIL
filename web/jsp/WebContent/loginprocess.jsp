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

<%
if(request.getMethod().equals("POST")){
	request.setCharacterEncoding("utf-8"); //인코딩설정
}
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if(id.equals("jsp") && pw.equals("jsp")){
	
		out.println("<h1>정상 로그인 되었습니다.</h1>");
		
		String[] locs = request.getParameterValues("location");
		for(String loc: locs){
		
			out.println("<h3>"+loc+"</h3>");	
					
		
		}
	}
	else {
	
		out.println("<a href='loginform.jsp'>로그인폼으로 이동</a>");//클릭했을때 이동	
	
		RequestDispatcher rd = request.getRequestDispatcher("loginform.jsp");
		rd.forward(request, response); //자동이동
	
	}
%>
<jsp:forward page="loginform.jsp"></jsp:forward><!-- loginform.jsp로 이동 -->
</body>
</html>