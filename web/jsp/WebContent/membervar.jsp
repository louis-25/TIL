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
<%! 
String msg = "멤버변수테스트";
String test1(){
	return msg;
}
%>

<% 
String msg2 = "지역변수테스트"; //_jspService 지역변수 
out.println(test1());
%>
</body>
</html>