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
<h1>닮은 연예인 찾아주기</h1>
<%--
<%="닮은 연예인이름="+faceResult %><br>
<%="확률"+faceResult%>
 --%>
<%
/* 
예전방식
String faceResult = (String)request.getAttribute("faceResult");
out.println(faceResult+"<br>");
String faceInfo[] = faceResult.split("\"faces\"");
out.println(faceInfo[1]+"<br>");
String celeInfo[] = faceInfo[1].split("\"celebrity\":");
out.println(celeInfo[celeInfo.length - 1]+"<br>");
String one = celeInfo[celeInfo.length - 1];
int valueIndex = one.indexOf("\"value\":");
int valueLength = "\"value\":".length();
int confiIndex = one.indexOf("\"confidence\":");
int confiLength = "\"confidence\":".length();
out.println(celeInfo[celeInfo.length - 1].substring(valueIndex + valueLength, confiIndex-1) + "<br>"); //confiIndex-1앞까지 가져와라
out.println(celeInfo[celeInfo.length - 1].substring(confiIndex + confiLength, confiIndex+confiLength+8) + "<br>"); */

%>
<%
//자바 String을 json으로 변환
String faceResult = (String)request.getAttribute("faceResult");
JSONObject obj = new JSONObject(faceResult);
Object imsi = obj.get("faces");//faces:[celebrity: {value:..},{confidence:..},{}]
JSONArray faces = (JSONArray)imsi;
boolean find = false;
for(Object cele : faces){
	JSONObject celebrity = (JSONObject) ((JSONObject)cele).get("celebrity");
	find = true;
	//String value = (String)celebrity.get("value");
	//String confidence = (String)celebrity.get("confidence");
	BigDecimal confidence = (BigDecimal)celebrity.get("confidence");
	//confidence	
	out.println("닮은 연예인이름="+celebrity.get("value")+", 닮은 확률="
	+ Math.round(confidence.doubleValue() * 100)+"%<br>");

}
	/* JSONObject cele = (JSONObject)faces.get("celebrity"); */
if(find == false) {
	out.println("닮은 연예인을 찾을 수가 없습니다.<br>");
}
String image = request.getParameter("image");
%>

<%-- <h1>${faceResult}</h1> --%>
</body>
</html>