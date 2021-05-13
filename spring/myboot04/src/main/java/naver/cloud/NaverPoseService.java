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