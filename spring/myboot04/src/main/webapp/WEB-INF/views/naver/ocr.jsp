<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.2.1.min.js"></script>
<body>
<script>
window.onload = function() {
	let div = document.getElementById("ocrResult");
	
	<%
	String image = request.getParameter("image");
	String ocrResult = (String)request.getAttribute("ocrResult");
	JSONObject obj = new JSONObject(ocrResult);
	JSONArray images = (JSONArray)obj.get("images");
	JSONObject oneimage = (JSONObject)images.get(0);
	JSONArray fields = (JSONArray)oneimage.get("fields");
	//out.println("fields: "+fields);

	for(int i = 0; i< fields.length(); i++){
		/* for(Object one : fields) {	
		JSONObject inferText = (JSONObject)((JSONObject)one).get("inferText");
		out.println(inferText);
	}  */
		JSONObject onefield = (JSONObject)fields.get(i);
		String inferText = (String)onefield.get("inferText");
		%>
		div.innerHTML += "<%=inferText %> ";
		<% 
	}
	%>

}

</script>
</head>

<img src="/faceimages/<%=image%>"><br>
<div id="ocrResult">
<!-- inferText 출력하되 lineBreak true 이면 줄바꿈 출력<br> -->
</div>

</body>
</html>