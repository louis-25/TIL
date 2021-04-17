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
<%String session_id = (String)session.getAttribute("session_id"); 
if(session_id.equals("jsp")){
	out.println(" 내 후기 1 ");
	out.println(" 내 후기 2 ");
}
%>
</body>
</html>