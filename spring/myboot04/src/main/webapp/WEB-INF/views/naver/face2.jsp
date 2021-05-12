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
<h1>얼굴인식 서비스</h1>
<%--
<%="닮은 연예인이름="+faceResult %><br>
<%="확률"+faceResult%>
 --%>

<%
//String image = request.getParameter("image");
//자바 String을 json으로 변환
String image = request.getParameter("image");
String faceResult2 = (String)request.getAttribute("faceResult2");
//out.println(faceResult2);

JSONObject obj = new JSONObject(faceResult2);
JSONArray faces = (JSONArray)obj.get("faces");
for(Object one : faces) {	
	JSONObject roi = (JSONObject)((JSONObject)one).get("roi");
	JSONObject emotion = (JSONObject)((JSONObject)one).get("emotion");
	JSONObject gender = (JSONObject)((JSONObject)one).get("gender");
	JSONObject age = (JSONObject)((JSONObject)one).get("age");
	
	int x = (int)roi.get("x");
	int y = (int)roi.get("y");
	int width = (int)roi.get("width");
	int height = (int)roi.get("height");
	
	out.println("얼굴 x좌표= "+x+" 얼굴 y좌표= "+y+" 가로크기= "+width+" 세로크기= "+height+"<br>"
			+"성별= "+gender.get("value")+" 나이= "+age.get("value")+" 표정= "+emotion.get("value")+"<br>");
	
	//추가
	//표정, 성별, 나이
}

%>

<%-- <h1>${faceResult}</h1> --%>
<img src="/faceimages/<%=image %>" width=200px>
</body>
</html>