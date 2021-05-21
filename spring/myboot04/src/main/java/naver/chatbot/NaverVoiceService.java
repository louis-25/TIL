package naver.chatbot;

//네이버 음성합성 Open API 예제
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import org.springframework.stereotype.Service;

import naver.cloud.NaverService;

/*
 * 1. NaverService 상속 : String test(String) 오버라이딩 - 화자 mijin 기본값 설정
 * 2. NaverController : voice 메소드 수정 - speaker 미선택시 voiceservice.test(""), 선택시 voiceservice.test("","")
 * 
 * */

@Service("chatbotvoiceService")
public class NaverVoiceService implements NaverService{

	@Override
	public String test(String file) {
		
		return test(file, "nara");
	}
	public String test(String responsetext, String speaker) {
	 
	 String returnfile = null;
     String clientId = "yheadou32e";//애플리케이션 클라이언트 아이디값";
     String clientSecret = "XbBNFTRczDq3nrUDPgyTQN4j4oaZjYEk71uGIAPj";//애플리케이션 클라이언트 시크릿값";
     try {
         String text = URLEncoder.encode(responsetext, "UTF-8"); // 13자        
         
         //clova voice 선택
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
             File f = new File("D:/Study/IT_Skilles/TIL/spring/images/"+tempname + ".mp3");
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
