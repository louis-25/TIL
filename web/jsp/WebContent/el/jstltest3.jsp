<%@page import="java.util.HashMap"%>
<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, board.BoardDAO, board.BoardDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</script>
</head>
<body>
	<!-- 1-10정수 총합 -->
	<h1>1-10 정수 총합</h1>
	<% int sum = 0; %>
	<c:set var="sum" value="<%=sum %>"/>
	<c:forEach begin="1" end="10" step="1" var="index">
		${index}까지의 총합= ${sum = sum + index}<br>
	</c:forEach>
	<%String[] colors={"빨강", "노랑", "초록", "파랑","보라","검정","흰색"}; %>
	
	<c:forEach items="<%=colors %>" var="col">
	${col}<br>
	</c:forEach>
	
	<c:forEach items="${el_colors}" var="col">
	${col}<br>
	</c:forEach>
	
	<% BoardDAO dao = new BoardDAO(); 
	   ArrayList<BoardDTO> list = dao.getBoardList();
	   pageContext.setAttribute("boardlist", list);
	%>
	<c:forEach items="${boardlist}" var="board">
	${board.title}:${board.contents}:${board.writer}:${board.viewcount}<br>
	</c:forEach>
	
	<%
		HashMap<String, String> map = new HashMap<String, String>();
	map.put("red", "빨강");
	map.put("blue", "파랑");
	map.put("green", "초록");
	map.put("white", "흰색");
	map.put("black", "검정");
	pageContext.setAttribute("colorsMap", map);
	%>
	<c:forEach items="${colorsMap}" var="col" varStatus="st">
	조회된 ${st.count} 번째 데이터: ${col.key} - ${col.value }<br>
	</c:forEach>
	
	
	
</body>
</html>