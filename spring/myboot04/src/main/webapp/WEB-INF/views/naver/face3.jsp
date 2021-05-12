<%@page import="java.math.BigDecimal"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String image = request.getParameter("image");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/jquery-3.2.1.min.js"></script>
<script>
    window.onload = function(){
       var samplecanvas = document.getElementById("samplecanvas");
       var samplecontext = samplecanvas.getContext("2d");
       var image = new Image();
       image.src = "faceimages/<%=image%>";
       image.onload = function(){
          samplecontext.drawImage(image, 0,0,image.width,image.height);
          
          <%
         //자바 String을 json 변환
         String faceResult2 = (String)request.getAttribute("faceResult2");
         //out.println(faceResult2);

         JSONObject obj = new JSONObject(faceResult2);
         JSONArray faces = (JSONArray)obj.get("faces"); // [], {}

         for(Object one : faces){
            
            JSONObject roi = (JSONObject)((JSONObject)one).get("roi");
            int x = (int)roi.get("x");
            int y = (int)roi.get("y");
            int width = (int)roi.get("width");
            int height = (int)roi.get("height");
            
            
            
             //out.println("얼굴 x좌표=" + x +"얼굴 y좌표=" + y +"가로크기=" + width +"세로크기=" + height + "<br>");
             %>
             var x = <%=x %>;
             var y = <%=y %>;
             var width = <%=width %>;
             var height = <%=height %>;   
             var faceImage = samplecontext.getImageData(x,y,width,height);
             var targetcanvas = document.getElementById("targetcanvas");
             var targetcontext = targetcanvas.getContext("2d");
             targetcontext.putImageData(faceImage,50,50);
          <%    
         }
         %>
       
       }
       
    }
</script>
</head>
<body>
<h1>얼굴 인식 서비스</h1>


<h3>이미지 전체 캔버스</h3>
<canvas id="samplecanvas" width=500 height=500 style="border : solid 2px pink"></canvas>
<h3>얼굴만캔버스</h3>
<canvas id="targetcanvas" width=300 height=300 style="border : solid 2px pink"></canvas>
</body>
</html>