<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String result = (String)request.getAttribute("objectdetectionResult");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
		
	$("#result").text('<%=result%>')
	var json = JSON.parse('<%=result%>');
	$("#count").text("탐지객체수 = "+json.predictions[0].num_detections+"개");
	$("#names").text("객체이름 = "+json.predictions[0].detection_names+"개");
	$("#confidence").text("확률 = ");
	for(var i =0; i< json.predictions[0].num_detections; i++) {
		$("#confidence").append
		(parseInt(parseFloat(json.predictions[0].detection_scores) * 100) + "% ");
	}
	//캔버스에 이미지 로드
	//var imagecanvas = $("#imagecanvas"); // jquery객체타입
	//var context = imagecanvas.getContext("2d"); //getContext는 jquery타입에는 getContext가 없기때문에  htmlobject타입을 사용해야함
	
	var imagecanvas = document.getElementById("imagecanvas"); //htmlobject타입
	var context = imagecanvas.getContext("2d");
	context.fillStyle="red";
	context.font = "15px batang";
	context.strokeStyle="green";
	context.lineWidth=3
	
	//이미지 로드
	var image = new Image();
	image.src = '/faceimages/<%=request.getParameter("image")%>';
	image.onload = function() {
		context.drawImage(image, 0, 0, image.width, image.height);
		var names = json.predictions[0].detection_names;
		var confidence = json.predictions[0].detection_scores;
		var boxes = json.predictions[0].detection_boxes;
		//좌표값읽기
		for(var i = 0; i< names.length; i++) {
			if(confidence[i] >= 0.9) {
				var y1 = boxes[i][0] * image.height ;  //가로시작지점
				var x1 = boxes[i][1] * image.width; //세로시작지점
				var y2 = boxes[i][2] * image.height;  //가로종료지점
				var x2 = boxes[i][3] * image.width; //세로종료지점
				//이름 : 99%출력
				context.fillText(names[i] + ":" + parseInt(confidence[i]*100)+"%", x1+10, y1+10);
				
				//사각형 그리기
				context.strokeRect(x1, y1, x2-x1, y2-y1);
			}// if end
		}//for end
	}//onload end
	
	
});
</script>
<%-- <script>
window.onload = function() {	
	//javascript로 json파싱
	var result = document.getElementById("result");
	var count = document.getElementById("count");
	var names = document.getElementById("names");
	var confidence = document.getElementById("confidence");
	<%String result = (String)request.getAttribute("objectdetectionResult");%>
	result.innerHTML += '<%=result%>'
	
	var json = JSON.parse('<%=result%>'); //js문자열형태 -> json형태 변환
	count.innerHTML = "탐지객체수 = "+json.predictions[0].num_detections+"개";
	names.innerHTML = "객체이름 = "+json.predictions[0].detection_names+"개";
	confidence.innerHTML = "확률 ";
	for(var i =0; i< json.predictions[0].detection_scores.length; i++) {
		confidence.innerHTML +=
		parseInt(parseFloat(json.predictions[0].detection_scores) * 100)+"% ";
	}	
	
	// num_detections : 탐지객체수
	// detection_names : 객체이름
	// 확률
}// window onload end
</script> --%>
</head>
<body>

<div id="result"></div>
<div id="count"></div>
<div id="names"></div>
<div id="confidence"></div>
<canvas id="imagecanvas" width=500 height=500 style="border: 2px solid red"></canvas>
</body>
</html>