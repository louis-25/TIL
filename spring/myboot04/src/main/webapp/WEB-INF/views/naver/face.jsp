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
<h1>���� ������ ã���ֱ�</h1>
<%--
<%="���� �������̸�="+faceResult %><br>
<%="Ȯ��"+faceResult%>
 --%>
<%
/* 
�������
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
out.println(celeInfo[celeInfo.length - 1].substring(valueIndex + valueLength, confiIndex-1) + "<br>"); //confiIndex-1�ձ��� �����Ͷ�
out.println(celeInfo[celeInfo.length - 1].substring(confiIndex + confiLength, confiIndex+confiLength+8) + "<br>"); */

%>
<%
//�ڹ� String�� json���� ��ȯ
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
	out.println("���� �������̸�="+celebrity.get("value")+", ���� Ȯ��="
	+ Math.round(confidence.doubleValue() * 100)+"%<br>");

}
	/* JSONObject cele = (JSONObject)faces.get("celebrity"); */
if(find == false) {
	out.println("���� �������� ã�� ���� �����ϴ�.<br>");
}
String image = request.getParameter("image");
%>

<%-- <h1>${faceResult}</h1> --%>
</body>
</html>