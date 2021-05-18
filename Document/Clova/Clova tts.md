# CLOVA Voice

고품질 음성 합성 기술로 다양하고 자연스러운 목소리 제공

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
	NaverVoiceService voiceservice;
	
	@RequestMapping("/voiceinput")
	public ModelAndView voiceinput() {
		File f = new File("C:/Users/정동현/Desktop/images");		
		String[] filelist = f.list();		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/voiceinput"); //textfile, speaker		
		return mv;
	}
	
	@RequestMapping(value="/voice", method=RequestMethod.GET)
	public ModelAndView voice(String image, String speaker) {//경로없이 파일명만 전달
		//String result = voiceservice.test(image); //tts서비스
		String result = voiceservice.test(image, speaker); //tts서비스
		ModelAndView mv = new ModelAndView();
		mv.addObject("voiceResult", result); //네이버 tts 결과 mp3반환
		mv.setViewName("/naver/voice");
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

### NaverVoiceService.java

```java
package naver.cloud;

//네이버 음성합성 Open API 예제
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import org.springframework.stereotype.Service;

/*
 * 1. NaverService 상속 : String test(String) 오버라이딩 - 화자 mijin 기본값 설정
 * 2. NaverController : voice 메소드 수정 - speaker 미선택시 voiceservice.test(""), 선택시 voiceservice.test("","")
 * 
 * */

@Service
public class NaverVoiceService implements NaverService{

	@Override
	public String test(String file) {
		
		return test(file, "nara");
	}
	public String test(String textfile, String speaker) {
	 
	 String returnfile = null;
     String clientId = "yheadou32e";//애플리케이션 클라이언트 아이디값";
     String clientSecret = "XbBNFTRczDq3nrUDPgyTQN4j4oaZjYEk71uGIAPj";//애플리케이션 클라이언트 시크릿값";
     try {
         String text = URLEncoder.encode("오홍홍홍", "UTF-8"); // 13자
         text = "";
         FileReader fr = new FileReader("C:/Users/정동현/Desktop/images/"+textfile);
         BufferedReader inputbr = new BufferedReader(fr); //한줄씩 읽어오게 버퍼에저장
         while(true) {
        	 String line = inputbr.readLine(); //한줄씩 읽어오기
        	 if(line==null) break;        	 
    		 text += line +"\n";
         }
         System.out.println(text);
         text = URLEncoder.encode(text, "UTF-8");
         System.out.println(text);
         
         String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
         URL url = new URL(apiURL);
         HttpURLConnection con = (HttpURLConnection)url.openConnection();
         con.setRequestMethod("POST");
         con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
         con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
         // post request
         String postParams = 
        		 "speaker="+speaker+"&volume=0&speed=0&pitch=0&emotion=0&format=mp3&text=" + text;
         con.setDoOutput(true);
         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
         wr.writeBytes(postParams);
         wr.flush();
         wr.close();
         int responseCode = con.getResponseCode();
         BufferedReader br;
         System.out.println(responseCode);
         if(responseCode==200) { // 정상 호출
             InputStream is = con.getInputStream();
             int read = 0;
             byte[] bytes = new byte[1024];
             // 랜덤한 이름으로 mp3 파일 생성
             String tempname = Long.valueOf(new Date().getTime()).toString();
             File f = new File("C:/Users/정동현/Desktop/images/"+tempname + ".mp3");
             returnfile = tempname + ".mp3";
             f.createNewFile();
             OutputStream outputStream = new FileOutputStream(f);
             while ((read =is.read(bytes)) != -1) {
                 outputStream.write(bytes, 0, read);
             }
             is.close();
         } else {  // 오류 발생
             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
             String inputLine;
             StringBuffer response = new StringBuffer();
             while ((inputLine = br.readLine()) != null) {
                 response.append(inputLine);
             }
             br.close();
             System.out.println(response.toString());
         }
     } catch (Exception e) {
         System.out.println(e);
     }
     return returnfile;
 }

@Override
public String test() {
	// TODO Auto-generated method stub
	return null;
}


}

```

<br>

### voiceinput.jsp

```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
   
});
</script>
</head>
<body>
<h1>tts 서비스를 위한 파일 선택</h1>
<%
String [] speakers = {"mijin","jinho","clara","matt","shinji","meimei","liangliang","jose","carmen"};
String [] informs = {"미진 : 한국어,여성 음색","진호 : 한국어, 남성 음색","clara : 클라라 : 영어, 여성 음색",
      "matt : 매트 : 영어, 남성 음색"," 신지: 일본어, 남성 음색","메이메이 : 중국어, 여성 음색","리앙리앙 : 중국어, 남성 음색",
      "호세 : 스페인어, 남성 음색","카르멘 : 스페인어, 여성 음색"};
%>

<form action="/voice">
   음색선택 :
   <%for(int i=0;i<speakers.length;i++){ %>
      <input type=radio name="speaker" value="<%=speakers[i] %>"> <%=informs[i] %>
   <%
   }
   %>
   <br>
   <select name="image">
      <%
         String[] filelist = (String[])request.getAttribute("filelist");
         for(String file : filelist){
            String[] f_split = file.split("[.]");
            String ext = f_split[f_split.length-1];
            if(ext.equals("txt")){
      %>
         <option value="<%=file%>"> <%=file %></option>
      <%
      }
}
%>
   </select>
   <input type="submit" value="음성으로변환요청">
</form>

</body>
</html>
```

<br>

### voice.jsp

사람의 관절을 18개로 나누어 점과 선으로 표현해보자

```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<%=request.getAttribute("voiceResult") %>
<audio src="/faceimages/<%=request.getAttribute("voiceResult") %>"
controls="controls">
</audio>
</body>
</html>
```

<br>

