package naver.cloud;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CSRDemo {
	public static void main(String[] args) {
        String clientId = "yheadou32e";             // Application Client ID";
        String clientSecret = "XbBNFTRczDq3nrUDPgyTQN4j4oaZjYEk71uGIAPj";     // Application Client Secret";

        try {
            String imgFile = "C:/Users/정동현/Desktop/images/stt.mp3";
            String language = "Kor";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
                                  
//            String imgFile = "C:/Users/정동현/Desktop/images/news1.mp3";
//            String language = "Kor";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
        	
//        	String imgFile = "C:/Users/정동현/Desktop/images/chn.mp3";
//            String language = "Chn";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
            
//        	String imgFile = "C:/Users/정동현/Desktop/images/eng.mp3";
//            String language = "Eng";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
            
            String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
            File voiceFile = new File(imgFile);
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
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            BufferedReader br = null;
            int responseCode = conn.getResponseCode();
            if(responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            String inputLine;

            if(br != null) {
                StringBuffer response = new StringBuffer();
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
        }
    }
}
