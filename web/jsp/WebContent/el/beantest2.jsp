<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "board.BoardDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</script>
</head>
<body>
<jsp:useBean id="dto" class="board.BoardDTO" scope="request"/>

<jsp:setProperty property="title" name="dto" value="<%=request.getParameter(\"title\") %>"/>
<jsp:setProperty property="contents" name="dto" value="<%=request.getParameter(\"contents\") %>"/>
<jsp:setProperty property="writer" name="dto" value="<%=request.getParameter(\"writer\") %>"/>
<jsp:setProperty property="password" name="dto" value="<%=Integer.parseInt(request.getParameter(\"password\")) %>"/>

제목 확인2:<jsp:getProperty property="title" name="dto"/>
내용 확인2:<jsp:getProperty property="contents" name="dto"/>
작성자 확인2:<jsp:getProperty property="writer" name="dto"/>
암호 확인2:<jsp:getProperty property="password" name="dto"/>


</body>
</html>