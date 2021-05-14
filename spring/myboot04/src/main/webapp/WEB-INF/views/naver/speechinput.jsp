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
<h1>stt 서비스를 위한 파일 선택</h1>
<%
String[] langs = {"Kor", "Eng", "Jpn", "Chn"};
String[] langnames = {"한국어", "영어", "일본어", "중국어"};
%>
<form action="/speech">
	언어선택 :
	<%for(int i=0; i< langs.length; i++){ %>
	<input type=radio name="lang" value="<%=langs[i]%>"><%=langnames[i]%>
	<%
	}
	%>
	<br>
	파일선택 :	
	<!-- mp3파일 -->
	<select name="image">
	<% 
	String[] filelist = (String[])request.getAttribute("filelist"); 
	for(String file : filelist) { // *.mp3만 보여주자
		String[] f_split = file.split("[.]"); //.을 인식시키려면 [] 안에 넣어줘야한다
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
	<input type=submit value="텍스트로 변환요청">
</form>
</body>
</html>