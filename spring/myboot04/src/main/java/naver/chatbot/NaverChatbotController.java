package naver.chatbot;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.multi.myboot04.UploadVO;

@Controller
public class NaverChatbotController {
	@Autowired
	NaverChatbotService chatbotservice;
	@Autowired
	@Qualifier("chatbotspeechService") // naver.chatbot에 있는 NaverSpeechService를 사용하겠다	
	NaverSpeechService speechservice; // 2개의 패키지에 존재하므로 어떤것을 사용할지 결정해야함 (naver.cloud, naver.chatbot)
	@Autowired
	@Qualifier("chatbotvoiceService")
	NaverVoiceService voiceservice;
	/* @Service, @Repository, @Component -- 해당 클래스 객체 생성하면
	 * 객체 자동 연결
	 * */
	
	@RequestMapping("/chatbotstart")
	public String chatbotstart() {
		//입장버튼 퇴장버튼
		return "/naver/chatbot/chatbotstart";
	}
	
	@RequestMapping("/chatbot")
	@ResponseBody //뷰를 호출하는게 아니라 단순한 데이터전송
	public String chatbot(String message) {
		//message ""-웰컴메세지 받자
		String event = null;
		if(message == "") {
			event = "open";
		}
		else {
			event = "send";
		}
		String response = chatbotservice.test(message, event);
		return response;
	}
		//질문 받아서 네이버 서버 호출 - 답변 내용 리턴
	@RequestMapping(value="/mp3upload", method= RequestMethod.POST)
	@ResponseBody
	public String uploadresult(MultipartFile file) throws IOException {
		
		//업로드한 파일명 추출(=클라이언트원본파일명)
		String filename = file.getOriginalFilename();
		//서버 저장 경로 설정
		String savePath = "D:/Study/IT_Skilles/TIL/spring/images/";
		//저장할 경로와 파일 이름 완성
		File savefile = new File(savePath + filename);
		//서버 저장
		file.transferTo(savefile);
		
		return "잘받았습니다";//ajax 클라이언트{"a":"b"}
	}
	
	//STT로 변환하여 서버에 전송
	@RequestMapping("/chatbotspeech")
	@ResponseBody
	public String speech(String mp3file, String lang) {
		String result = speechservice.test(mp3file);
		return result; //변환텍스트 반환
	}
	
	//TTS- 음성답변
	@RequestMapping("/chatbotvoice")
	@ResponseBody
	public String voice(String text, String speaker) {
		String result = voiceservice.test(text, speaker);
		return result; //변환텍스트 반환
	}
}
