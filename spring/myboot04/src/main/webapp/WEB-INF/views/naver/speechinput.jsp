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
<h1>stt ���񽺸� ���� ���� ����</h1>
<%
String[] langs = {"Kor", "Eng", "Jpn", "Chn"};
String[] langnames = {"�ѱ���", "����", "�Ϻ���", "�߱���"};
%>
<form action="/speech">
	���� :
	<%for(int i=0; i< langs.length; i++){ %>
	<input type=radio name="lang" value="<%=langs[i]%>"><%=langnames[i]%>
	<%
	}
	%>
	<br>
	���ϼ��� :	
	<!-- mp3���� -->
	<select name="image">
	<% 
	String[] filelist = (String[])request.getAttribute("filelist"); 
	for(String file : filelist) { // *.mp3�� ��������
		String[] f_split = file.split("[.]"); //.�� �νĽ�Ű���� [] �ȿ� �־�����Ѵ�
		String ext = f_split[f_split.length-1];
		if(ext.equals("mp3")){
	%>
		<option value="<%=file%>"><%=file %></option>	 	
	<%
		}//if end
	}//for end
	%>
	</select>
	<br>
	<input type=submit value="�ؽ�Ʈ�� ��ȯ��û">
</form>
</body>
</html>