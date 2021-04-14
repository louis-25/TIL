package multi.campus.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		//request.setAttribute("model", "hello spring~");
		//return "hello.jsp";
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("board", "hello spring~");
		mv.setViewName("hello");
		return mv;
				
	}

}
