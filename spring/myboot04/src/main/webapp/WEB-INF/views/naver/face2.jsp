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
<h1>���ν� ����</h1>
<%--
<%="���� �������̸�="+faceResult %><br>
<%="Ȯ��"+faceResult%>
 --%>

<%
//String image = request.getParameter("image");
//�ڹ� String�� json���� ��ȯ
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
	
	out.println("�� x��ǥ= "+x+" �� y��ǥ= "+y+" ����ũ��= "+width+" ����ũ��= "+height+"<br>"
			+"����= "+gender.get("value")+" ����= "+age.get("value")+" ǥ��= "+emotion.get("value")+"<br>");
	
	//�߰�
	//ǥ��, ����, ����
}

%>

<%-- <h1>${faceResult}</h1> --%>
<img src="/faceimages/<%=image %>" width=200px>
</body>
</html>