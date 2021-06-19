package com.multi.teststt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

public class SttTest {
		
	public static void main(String[] args) {
		StringBuffer response = new StringBuffer();
        String clientId = "yheadou32e";             // Application Client ID";
        String clientSecret = "XbBNFTRczDq3nrUDPgyTQN4j4oaZjYEk71uGIAPj";     // Application Client Secret";  
        JSONObject jObject;                        
        
        try {        	        
        	String imgFile = "sample.wav";
            String language = "Kor";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
            
            String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
            File voiceFile = ResourceUtils.getFile("classpath:images/"+imgFile);
            URL url = new URL(apiURL);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            OutputStream outputStream = conn.getOutputStream();
            FileInputStream inputStream = new FileInputStream(voiceFile);
            byte[] buffer = new byte[4096]; //4K, 60초 재생
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            
            BufferedReader br = null;
            int responseCode = conn.getResponseCode();
            System.out.println("응답코드:"+responseCode);
            
            if(responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            String inputLine;
            
            if(br != null) {
                
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println("------------------실행결과------------------");
                jObject = new JSONObject(response.toString());
                System.out.println(jObject.getString("text"));
                
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }        
	}

}
