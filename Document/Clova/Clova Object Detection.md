# CLOVA Object Detection

이미지 내 사람 및 자동차 등 객체의 타입과 위치를 감지하여 정보를 제공함

<br>

### Controller

```java
package naver.cloud;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NaverController {
	@Autowired
	NaverObjectDetectionService objectdetectionservice;		
	
	@RequestMapping("/objectdetectioninput")
	public ModelAndView objectdetectioninput() {
		File f = new File("C:/Users/정동현/Desktop/images");		
		String[] filelist = f.list();		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/objectdetectioninput");
		
		return mv;
	}
	
	@RequestMapping(value="/objectdetection", method=RequestMethod.GET)
	public ModelAndView objectdetection(String image) {//경로없이 파일명만 전달
		String result = objectdetectionservice.test(image); //객체 탐지 서비스
		ModelAndView mv = new ModelAndView();
		mv.addObject("objectdetectionResult", result);
		mv.setViewName("/naver/objectdetection");
		return mv;
	}
}

```

<br>

### NaverService

```java
package naver.cloud;

public interface NaverService {
	String test();

	String test(String file);
}

```

<br>

### NaverObjectDetectionService.java

```java
package naver.cloud;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Service;

@Service
public class NaverObjectDetectionService implements NaverService{
	
	@Override
	public String test() {
		return "";
	}
	
	@Override
	public String test(String image) {
		StringBuffer reqStr = new StringBuffer();
        
		String clientId = "yheadou32e";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "XbBNFTRczDq3nrUDPgyTQN4j4oaZjYEk71uGIAPj";//애플리케이션 클라이언트 시크릿값";
        StringBuffer response = new StringBuffer();
        try {
            String paramName = "image"; // 파라미터명은 image로 지정
            String imgFile = "C:/Users/정동현/Desktop/images/"+image;
            File uploadFile = new File(imgFile);
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision-obj/v1/detect"; // 객체 인식
            
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            // multipart request
            String boundary = "---" + System.currentTimeMillis() + "---";
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            OutputStream outputStream = con.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            String LINE_FEED = "\r\n";
            // file 추가
            String fileName = uploadFile.getName();
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append("Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
            writer.append("Content-Type: "  + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
            writer.append(LINE_FEED);
            writer.flush();
            FileInputStream inputStream = new FileInputStream(uploadFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();
            //===========
            
            //응답요청
            BufferedReader br = null;
            int responseCode = con.getResponseCode();
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            if(br != null) {
                //StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
		return response.toString();
	}

}

```

<br>

### objectdetectioninput.jsp

```java
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
<% 
String[] filelist = (String[])request.getAttribute("filelist"); 
for(String file : filelist) {
%>
	<a href="http://127.0.0.1:9091/objectdetection?image=<%=file%>"><%=file%></a>
	<%-- <img alt="<%file%>" src="resources/static/images/"<%=file%>><br> <!-- 해당파일 이미지 출력 -->--%> 
	<img src="/faceimages/<%=file%>" width=200px><br>
<%
}
%>

</body>
</html>
```

<br>

### objectdetection.jsp

이미지를 분석하여 정확도 및 분석영역을 표시해준다.

```java
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
</head>
<body>

<div id="result"></div>
<div id="count"></div>
<div id="names"></div>
<div id="confidence"></div>
<canvas id="imagecanvas" width=500 height=500 style="border: 2px solid red"></canvas>
</body>
</html>
```

<br>

