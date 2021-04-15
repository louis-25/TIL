package multi.campus.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	//1. 로그인폼 출력
	@RequestMapping(value="/login", method=RequestMethod.GET)	
	public String loginform() {		
		//mv.setViewName("loginform"); // 일단 뷰만세팅
		return "loginform"; // 뷰이름 리턴
	}
	
	//2. 입력내용 로그인처리결과 출력
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginresult(@ModelAttribute LoginVO vo) { // 객체
		ModelAndView mv = new ModelAndView();
		System.out.println(vo.getId()+":"+vo.getPw());		
		if(vo.getId().equals("spring") && vo.getPw().equals("work")) {
			mv.addObject("result","정상 로그인 사용자");
		}
		else {
			mv.addObject("result", "아이디 암호를 다시 입력하세요.");
		}
		mv.setViewName("loginresult");
		return mv;
	}
}

/*
 * public ModelAndView loginresult(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id.equals("spring")&&pw.equals("work")) {
			mv.addObject("result","정상 로그인 사용자");
		}
		else {
			mv.addObject("result", "아이디 암호를 다시 입력하세요.");
		}
		mv.setViewName("loginresult");
		return mv;
	}
	
	public ModelAndView loginresult(
			@RequestParam(value="id", required=false, defaultValue="spring") String id2, String pw) {
		ModelAndView mv = new ModelAndView();
		System.out.println(id2+":"+pw);
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
		if(id2.equals("spring")&&pw.equals("work")) {
			mv.addObject("result","정상 로그인 사용자");
		}
		else {
			mv.addObject("result", "아이디 암호를 다시 입력하세요.");
		}
		mv.setViewName("loginresult");
		return mv;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginresult(String id, int pw) {
		//Integer.parseInt(request.getParameter("pw")) 안써줘도 자동으로 형변환됨
		ModelAndView mv = new ModelAndView();
		System.out.println(id+":"+pw);
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
		if(id.equals("spring") && pw == 111) {
			mv.addObject("result","정상 로그인 사용자");
		}
		else {
			mv.addObject("result", "아이디 암호를 다시 입력하세요.");
		}
		mv.setViewName("loginresult");
		return mv;
	}
 * */
