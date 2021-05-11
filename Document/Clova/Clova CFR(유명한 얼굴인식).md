

# CLOVA Face Recognition(CFR) - 유명한 얼굴

나의 얼굴을 인식시켜 닮은 유명인을 찾아보자

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
	NaverFaceService service; //닮은 유명인찾기
	
	@RequestMapping("/faceinput")
	public ModelAndView faceinput() {
		//바탕화면\images 폴더를 File 객체 생성
		//File객체 list 메소드 이용하면 파일이름만 배열 리턴
		//리턴받은 배열을 모델 생성 - 모델명 filelist
		File f = new File("C:/Users/정동현/Desktop/images");		
		String[] filelist = f.list();		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/faceinput");
		//faceinput.jsp 구현
		//filelist 모델값을 <a href="http://127.0.0.1:9091/face 호출하면서 파일이름 전달"> 파일이름 </a>
		return mv;
	}
	
	@RequestMapping(value="/face", method=RequestMethod.GET)
	public ModelAndView face(String image) {//전달받아 test에 전달
		String result = service.test(image);
		ModelAndView mv = new ModelAndView();
		mv.addObject("faceResult", result);
		mv.setViewName("/naver/face");
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

clientId , clientSecret 은 clova에서 발급받아 사용해야한다 (유료)

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
public class NaverFaceService implements NaverService{
	
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
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision/v1/celebrity"; // 유명인 얼굴 인식
//            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision/v1/face"; // 얼굴 감지
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
            return e.toString(); //클라이언트 파일...오류메세지
        }
		return response.toString(); //서버로부터의 결과
	}

}

```

<br>

### **views**

**face.jsp**

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
<h1>닮은 연예인 찾아주기</h1>
    
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
```

<br>

**faceinput.jsp**

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
	<a href="http://127.0.0.1:9091/face?image=<%=file%>"><%=file%></a>
	<%-- <img alt="<%file%>" src="resources/static/images/"<%=file%>><br> <!-- 해당파일 이미지 출력 -->--%> 
	<img src="/faceimages/<%=file%>" width=200px><br>
<%
}
%>

<h1>${fileInput}</h1>
<a href="http://127.0.0.1:9091/face?file=${fileInput}">파일전송</a>
</body>
</html>
```

<br>

### json파싱 라이브러리 pom.xml에 추가

```xml
<!-- for json --> 
<dependency>           
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20201115</version>
</dependency>
```

