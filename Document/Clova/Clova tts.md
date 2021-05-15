# CLOVA Pose Estimation

이미지 속의 사람을 감지하고 몇명이 어떤 포즈를 취하고 있는지에 대한 좌표 정보를 얻을 수 있습니다.

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
	NaverPoseService poseservice; // 포즈 분석
	
	@RequestMapping("/poseinput")
	public ModelAndView poseinput() {
		File f = new File("C:/Users/정동현/Desktop/images");		
		String[] filelist = f.list();		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/poseinput");
		//faceinput.jsp 구현
		//filelist 모델값을 <a href="http://127.0.0.1:9091/ocr 호출하면서 파일이름 전달"> 파일이름 </a>
		return mv;
	}
	
	@RequestMapping(value="/pose", method=RequestMethod.GET)
	public ModelAndView pose(String image) {//경로없이 파일명만 전달
		String result = poseservice.test(image); //포즈분석 서비스
		ModelAndView mv = new ModelAndView();
		mv.addObject("poseResult", result); //네이버 포즈 인식 결과 json
		mv.setViewName("/naver/pose");
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

### NaverPoseService.java

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
public class NaverPoseService implements NaverService {

	@Override
	public String test(String image) {
		StringBuffer response = new StringBuffer();
		StringBuffer reqStr = new StringBuffer();
		
        String clientId = "yheadou32e";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "XbBNFTRczDq3nrUDPgyTQN4j4oaZjYEk71uGIAPj";//애플리케이션 클라이언트 시크릿값";
		
		try {
			String paramName = "image"; // 파라미터명은 image로 지정
			String imgFile = "C:/Users/정동현/Desktop/images/"+image; 
			File uploadFile = new File(imgFile);
			String apiURL = "https://naveropenapi.apigw.ntruss.com/vision-pose/v1/estimate"; // 사람 인식
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setUseCaches(false);
			con.setDoOutput(true);
			con.setDoInput(true); // 서버 전송 데이터가 추가적으로 더 있다.
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
			writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
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

			//=======================요청 보내기 (id, key, 이미지 파일 읽어서) ==================

			// 응답 받기
			BufferedReader br = null;
			int responseCode = con.getResponseCode();
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			else { // 오류 발생 (API 사이트에서 확인)
				System.out.println("error!!!!!!! responseCode= " + responseCode);
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			String inputLine;
			if (br != null) {
				//StringBuffer response = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				}
				br.close();
				System.out.println(response.toString());
			}
			else {
				System.out.println("error !!!");
			}
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println(((java.io.IOException)e).getMessage());
		}
		return response.toString();
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return null;
	}
}
```

<br>

### poseinput.jsp

```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
});//ready end
</script>
</head>
<body>
<%
	String[] filelist = (String[])request.getAttribute("filelist");
	for(String file : filelist) {
		String [] file_split = file.split("[.]");
		String ext = file_split[file_split.length - 1];
		if(!(ext.equals("mp3") || ext.equals("text"))) {
		
%>
			<a href="/pose?image=<%=file%>"><%=file%>(얼굴인식)</a> <img src="/faceimages/<%=file%>" width=100 height=100><br>
<%
		}
	}
%>
</body>
</html>
```

<br>

### pose.jsp

사람의 관절을 18개로 나누어 점과 선으로 표현해보자

```java
<%@page import="java.math.BigDecimal"%>
<%@page import="org.json.JSONArray"%>
<%@ page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	String image = request.getParameter("image"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
window.onload = function() {
	var bodynames = ["코", "목", "오른쪽 어깨", "오른쪽 팔굼치", "오른쪽 손목", "왼쪽 어깨", "왼쪽 팔굼치", "왼쪽 손목", "오른쪽 엉덩이", "오른쪽 무릎","오른쪽 발목", "왼쪽 엉덩이", "왼쪽 무릎", "왼쪽 발목", "오른쪽 눈", "왼쪽 눈", "오른쪽 귀", "왼쪽 귀", "오른쪽 귀"];
	var samplecanvas = document.getElementById("samplecanvas");
	var resultdiv = document.getElementById("resultdiv");
	var samplecontext = samplecanvas.getContext("2d");
	
	samplecontext.fillStyle = "red";
	samplecontext.lineWidth = 5;
	samplecontext.strokeStyle = "green";
	
	var image = new Image();
	image.src = "/faceimages/<%=image%>";
	image.onload = function() {
		samplecontext.drawImage(image, 0, 0, image.width, image.height);
<%
		String poseResult = (String)request.getAttribute("poseResult");
%>
		var json = JSON.parse('<%=poseResult%>');
		for(var i in json.predictions) {
			for(var ii in json.predictions[i]) {
				var body = json.predictions[i][ii];
				resultdiv.innerHTML += ii + " 신체 부위 : x = " + body.x + " y = " + body.y + "<br>";
				samplecontext.fillRect(body.x * image.width, body.y * image.height, 5, 5);
				
				// 전체 신체 부위 이름 출력
				// samplecontext.fillText(bodynames[ii], body.x * image.width + 5, body.y * image.height + 5);
				
				// 왼쪽 손목, 오른쪽 손목만 이름 출력
				if(bodynames[ii].indexOf("오른쪽 손목") >= 0 || bodynames[ii].indexOf("왼쪽 손목") >= 0 ) {
					samplecontext.fillText(bodynames[ii], body.x * image.width + 5, body.y * image.height + 5);
				}
				if(bodynames[ii].indexOf("오른쪽 손목") >= 0 ) {
					var rightx = body.x * image.width;
					var righty = body.y * image.height;
				}
				if(bodynames[ii].indexOf("왼쪽 손목") >= 0 ) {
					var leftx = body.x * image.width;
					var lefty = body.y * image.height;
				}
				// 양쪽 손목 서로 선 연결
				samplecontext.beginPath();
				samplecontext.moveTo(leftx, lefty);
				samplecontext.lineTo(rightx, righty);
				samplecontext.closePath();
				samplecontext.stroke();
				
			}
		}
	} // image onload end
} // window onload end
</script>
</head>
<body>
<%=request.getAttribute("poseResult") %>
<div id="resultdiv"></div>
<h1> 이미지 전체 캔버스 </h1>
<canvas id="samplecanvas" width=900 height=900 style="border : solid 2px pink"></canvas>
</body>
</html>
```

<br>

