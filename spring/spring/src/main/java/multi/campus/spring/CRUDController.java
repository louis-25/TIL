package multi.campus.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDController {
	//crud - create read update delete - 생성 조회 수정 삭제 기본
	//1개 여러개 요청 메소드들 다수개 정의
	//게시물생성 - 조회 - 삭제 - 수정
	@RequestMapping("/crud/start")
	public void start() {
		//모델 없다
		//뷰이름 자동 결정 - /crud/start.jsp
	}
	
	@RequestMapping("/crud/list")
	public ModelAndView list() {
		String[] titles = {"게시물1", "게시물2", "게시물3"};
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", titles);
		mv.setViewName("/crud/list");
		return mv;
	}
	
	@RequestMapping(value="/crud/add", method=RequestMethod.GET)
	public String addform() {
		// /crud/addform.jsp		
		return "/crud/addform";
	}
	
	@RequestMapping(value="/crud/add", method=RequestMethod.POST)
	public ModelAndView addresult(String title, String contents, String writer) {
		// /crud/addform.jsp			
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", title+":"+contents+":"+writer);
		mv.addObject("status", "게시물 1개 저장 완료");
		//mv.setView("/crud/add"); url이름과 같기때문에 굳이 안써도됨 why? -> 기본적으로 url이름으로 뷰이름을 세팅해주기때문!
		return mv;
	}
	
	@RequestMapping(value="/crud/update", method=RequestMethod.GET)
	public ModelAndView updateform() {
		// 제목 내용 작성자	미리 폼 보여주고 수정
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "선택한 게시물 제목");
		mv.addObject("contents", "내용");
		mv.addObject("writer", "작성자");
		mv.setViewName("/crud/updateform");		
		return mv;
	}
	@RequestMapping(value="/crud/update", method=RequestMethod.POST)
	public ModelAndView updateresult(String title, String contents, String writer) {
		// /crud/addform.jsp			
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", title+":"+contents+":"+writer);
		mv.addObject("status", "게시물 1개 저장 완료");
		//mv.setView("/crud/add"); url이름과 같기때문에 굳이 안써도됨 why? -> 기본적으로 url이름으로 뷰이름을 세팅해주기때문!
		return mv;
	}
	
	@RequestMapping("/crud/delete")
	public String delete(@RequestParam(value="seq", required=false, defaultValue="1") int seq){
		// 삭제 후의 리스트 화면
		System.out.println(seq+"번의 글 삭제");
		return "redirect:/crud/list";
	}
	
}
