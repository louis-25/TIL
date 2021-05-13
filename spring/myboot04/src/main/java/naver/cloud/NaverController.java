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
	NaverFaceService service; //유명인 찾기
	@Autowired
	NaverFaceService2 service2; //얼굴인식
	@Autowired
	NaverOCRService ocrservice; //이미지에서 텍스트 추출
	@Autowired
	NaverObjectDetectionService objectdetectionservice;
	@Autowired
	NaverPoseService poseservice; // 포즈 분석
	
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
		mv.setViewName("/naver/face3");
		return mv;
	}
	
	@RequestMapping("/ocrinput")
	public ModelAndView ocrinput() {
		File f = new File("C:/Users/정동현/Desktop/images");		
		String[] filelist = f.list();		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/ocrinput");
		//faceinput.jsp 구현
		//filelist 모델값을 <a href="http://127.0.0.1:9091/ocr 호출하면서 파일이름 전달"> 파일이름 </a>
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
	
	@RequestMapping("/objectdetectioninput")
	public ModelAndView objectdetectioninput() {
		File f = new File("C:/Users/정동현/Desktop/images");		
		String[] filelist = f.list();		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/objectdetectioninput");
		//faceinput.jsp 구현
		//filelist 모델값을 <a href="http://127.0.0.1:9091/ocr 호출하면서 파일이름 전달"> 파일이름 </a>
		return mv;
	}
	
	@RequestMapping(value="/objectdetection", method=RequestMethod.GET)
	public ModelAndView objectdetection(String image) {//경로없이 파일명만 전달
		String result = objectdetectionservice.test(image); //객체 탐지 서비스
		ModelAndView mv = new ModelAndView();
		mv.addObject("objectdetectionResult", result);
		mv.setViewName("/naver/objectdetection");
		return mv;
	}
	
	@RequestMapping("/poseinput")
	public ModelAndView poseinput() {
		File f = new File("C:/Users/정동현/Desktop/images");		
		String[] filelist = f.list();		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("/naver/poseinput");
		//faceinput.jsp 구현
		//filelist 모델값을 <a href="http://127.0.0.1:9091/ocr 호출하면서 파일이름 전달"> 파일이름 </a>
		return mv;
	}
	
	@RequestMapping(value="/pose", method=RequestMethod.GET)
	public ModelAndView pose(String image) {//경로없이 파일명만 전달
		String result = poseservice.test(image); //포즈분석 서비스
		ModelAndView mv = new ModelAndView();
		mv.addObject("poseResult", result); //네이버 포즈 인식 결과 json
		mv.setViewName("/naver/pose");
		return mv;
	}
}
