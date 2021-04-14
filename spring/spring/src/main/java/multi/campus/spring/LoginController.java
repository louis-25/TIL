package multi.campus.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	//1. 로그인폼 출력
	@RequestMapping("/loginform")	
	public ModelAndView loginform() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginform"); // 일단 뷰만세팅
		return mv;
	}
	
	//2. 입력내용 로그인처리결과 출력
	@RequestMapping("/loginresult")
	public ModelAndView loginresult(HttpServletRequest request) {
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
}
