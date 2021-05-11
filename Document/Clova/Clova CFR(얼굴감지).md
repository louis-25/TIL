# CLOVA Face Recognition(CFR) - 얼굴감지

사람의 얼굴을 인식하는 기술로 사진속에 얼굴은 몇개가있는지 표정, 성별, 나이 등을 알려준다

**controller**

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
	NaverFaceService2 service2; //얼굴인식
	
	@RequestMapping("/faceinput2")
	public ModelAndView faceinput2() {
		File f = new File("C:/Users/정동현/Desktop/images");		
		String[] filelist = f.list();		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/faceinput2");
		//faceinput.jsp 구현
		//filelist 모델값을 <a href="http://127.0.0.1:9091/face2 호출하면서 파일이름 전달"> 파일이름 </a>
		return mv;
	}
	
	@RequestMapping(value="/face2", method=RequestMethod.GET)
	public ModelAndView face2(String image) {//전달받아 test에 전달
		String result = service2.test(image);
		ModelAndView mv = new ModelAndView();
		mv.addObject("faceResult2", result);
		mv.setViewName("/naver/face2");
		return mv;
	}
}

```

<br>

**service**

```java
package naver.cloud;

public interface NaverService {
	String test();

	String test(String file);
}

```

<br>

**service implements**

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
public class NaverFaceService2 implements NaverService{
	
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
//            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision/v1/celebrity"; // 유명인 얼굴 인식
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision/v1/face"; // 얼굴 감지
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

### **views**

**face2.jsp**

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
<h1>얼굴인식 서비스</h1>
<%--
<%="닮은 연예인이름="+faceResult %><br>
<%="확률"+faceResult%>
 --%>

<%
//String image = request.getParameter("image");
//자바 String을 json으로 변환
String image = request.getParameter("image");
String faceResult2 = (String)request.getAttribute("faceResult2");
//out.println(faceResult2);

JSONObject obj = new JSONObject(faceResult2);
JSONArray faces = (JSONArray)obj.get("faces");
for(Object one : faces) {	
	JSONObject roi = (JSONObject)((JSONObject)one).get("roi");
	JSONObject emotion = (JSONObject)((JSONObject)one).get("emotion");
	JSONObject gender = (JSONObject)((JSONObject)one).get("gender");
	JSONObject age = (JSONObject)((JSONObject)one).get("age");
	
	int x = (int)roi.get("x");
	int y = (int)roi.get("y");
	int width = (int)roi.get("width");
	int height = (int)roi.get("height");
	
	out.println("얼굴 x좌표= "+x+" 얼굴 y좌표= "+y+" 가로크기= "+width+" 세로크기= "+height+"<br>"
			+"성별= "+gender.get("value")+" 나이= "+age.get("value")+" 표정= "+emotion.get("value")+"<br>");
	
	//추가
	//표정, 성별, 나이
}

%>

<%-- <h1>${faceResult}</h1> --%>
<img src="/faceimages/<%=image %>" width=200px>
</body>
</html>
```

<br>

**faceinput2.jsp**

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
	<a href="http://127.0.0.1:9091/face2?image=<%=file%>"><%=file%>(얼굴인식)</a>
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



json파싱 라이브러리 pom.xml에 추가

```xml
<!-- for json --> 
<dependency>           
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20201115</version>
</dependency>
```

