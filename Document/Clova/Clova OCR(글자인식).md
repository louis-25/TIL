# CLOVA OCR

OCR은 인쇄물 상의 글자와 이미지를 디지털 데이터로 자동으로 추출하는 기술입니다.

<br>

### **controller**

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
	NaverOCRService ocrservice; //이미지에서 텍스트 추출
	
	@RequestMapping("/ocrinput")
	public ModelAndView ocrinput() {
		File f = new File("C:/Users/정동현/Desktop/images");		
		String[] filelist = f.list();		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/ocrinput");
		return mv;
	}
	
	@RequestMapping(value="/ocr", method=RequestMethod.GET)
	public ModelAndView ocr(String image) {//전달받아 test에 전달
		String result = ocrservice.test(image); //이미지에서 텍스트인식
		ModelAndView mv = new ModelAndView();
		mv.addObject("ocrResult", result);
		mv.setViewName("/naver/ocr");
		return mv;
	}
}

```

<br>

### **service**

```java
package naver.cloud;

public interface NaverService {
	String test();

	String test(String file);
}

```

<br>

### **service implements**

ocr을 이용하기 위한 ocr키와 invoke url을 발급받아야함

```java
package naver.cloud;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class NaverOCRService implements NaverService{	
	
	public String test(String inputimage) {
		StringBuffer response = new StringBuffer();
		//invoke url
		String apiURL = "https://e580247ae5a64e5bb7bccd286ecc2cb1.apigw.ntruss.com/custom/v1/8653/7e4958df839cb0323fb2f551bf2fa330fd2db9b139a8b66397f152c8701f5cf3/general";
		String secretKey = "UlRNQ0RaS01zR1JCaG90ZU1lRVRvRGhvV0habmtJdWw="; //OCR키
		String imageFile = "C:/Users/정동현/Desktop/images/"+inputimage;

		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setReadTimeout(30000);
			con.setRequestMethod("POST");
			String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			con.setRequestProperty("X-OCR-SECRET", secretKey);
			
			//ocr 서버 파라미터 전송 요구
			JSONObject json = new JSONObject();
			json.put("version", "V2");
			json.put("requestId", UUID.randomUUID().toString());
			json.put("timestamp", System.currentTimeMillis());
			JSONObject image = new JSONObject();
			image.put("format", "jpg");
			image.put("name", "demo");
			JSONArray images = new JSONArray();
			images.put(image);
			json.put("images", images);
			String postParams = json.toString();

			con.connect();
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			long start = System.currentTimeMillis();
			File file = new File(imageFile);
			writeMultiPart(wr, postParams, file, boundary);
			wr.close();

			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
//			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();

			System.out.println(response);
		} catch (Exception e) {
			System.out.println(e);
		}
		return response.toString();
	}

	private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
		IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("--").append(boundary).append("\r\n");
		sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
		sb.append(jsonMessage);
		sb.append("\r\n");

		out.write(sb.toString().getBytes("UTF-8"));
		out.flush();

		if (file != null && file.isFile()) {
			out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
			StringBuilder fileString = new StringBuilder();
			fileString
				.append("Content-Disposition:form-data; name=\"file\"; filename=");
			fileString.append("\"" + file.getName() + "\"\r\n");
			fileString.append("Content-Type: application/octet-stream\r\n\r\n");
			out.write(fileString.toString().getBytes("UTF-8"));
			out.flush();

			try (FileInputStream fis = new FileInputStream(file)) {
				byte[] buffer = new byte[8192];
				int count;
				while ((count = fis.read(buffer)) != -1) {
					out.write(buffer, 0, count);
				}
				out.write("\r\n".getBytes());
			}

			out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
		}
		out.flush();
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return null;
	}
}


```



<br>

### **views**

**ocr**

```java
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
inferText 출력하되 lineBreak true 이면 줄바꿈 출력<br>
</div>

</body>
</html>
```

**ocrinput**

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
	if(file.contains("font")){ //file이름에 
%>
	<a href="http://127.0.0.1:9091/ocr?image=<%=file%>"><%=file%></a>
	<%-- <img alt="<%file%>" src="resources/static/images/"<%=file%>><br> <!-- 해당파일 이미지 출력 -->--%> 
	<img src="/faceimages/<%=file%>" width=200px><br>
<%
	}
}
%>

<h1>${fileInput}</h1>
<a href="http://127.0.0.1:9091/face?file=${fileInput}">파일전송</a>
</body>
</html>
```

<br>

json파싱 라이브러리 pom.xml에 추가

```xml
<!-- for json --> 
<dependency>           
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20201115</version>
</dependency>
```

