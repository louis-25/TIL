package com.multi.ttstest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import org.springframework.util.ResourceUtils;

public class TtsTest {

	public static void main(String[] args) {		
		String textfile = "sample.txt";
		String speaker = "nara";
		
		String returnfile ="";
	     String clientId = "yheadou32e";//애플리케이션 클라이언트 아이디값";
	     String clientSecret = "XbBNFTRczDq3nrUDPgyTQN4j4oaZjYEk71uGIAPj";//애플리케이션 클라이언트 시크릿값";
	     try {
	         String text = URLEncoder.encode("안녕하세요? 저는 AI Platform 기반의 지능형 서비스 개발 프로젝트 D반 정동현입니다. 이것은 과정 실습평가 샘플 음성입니다.", "UTF-8"); // 13자
	         text = "";
	         FileReader fr = new FileReader(ResourceUtils.getFile("classpath:images/"+textfile));
	         
	         BufferedReader inputbr = new BufferedReader(fr); //한줄씩 읽어오게 버퍼에저장
	         while(true) {
	        	 String line = inputbr.readLine(); //한줄씩 읽어오기
	        	 if(line==null) break;        	 
	    		 text += line +"\n";
	         }
	         System.out.println(text);
	         text = URLEncoder.encode(text, "UTF-8");	         
	         
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
	         System.out.println("응답코드: "+responseCode);
	         if(responseCode==200) { // 정상 호출
	             InputStream is = con.getInputStream();
	             int read = 0;
	             byte[] bytes = new byte[1024];
	             //mp3 파일 생성
	             int idx = textfile.indexOf(".");
	             String tempname = textfile.substring(0, idx);
	             tempname += "2";
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
	}
}
