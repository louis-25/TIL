package com.project.semi;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardService service;	
	
	/* 로그인 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String loginform() { //폼 출력요청
		return "login";//뷰이름
	}
	
	@RequestMapping(value="/ajax/login",method=RequestMethod.POST,
	produces= {"application/json;charset=utf-8"})
	@ResponseBody //JSON라이브러리 추가해야 사용가능
	//date:{'id':$("#id").val(), 'pw':$('#pw').val()}
	public String loginform(String id, String pw) {//폼 입력 데이터 전송 ajax요청
		System.out.println(id+":"+pw);
		String result = null; //json형태의 결과를 담을 변수
		List<MemberDTO> members = service.getAllMember();
		
		//회원식별
		for(MemberDTO member : members) {
			System.out.println(member); //회원정보출력
			if(member.getId().equals(id) && Integer.toString(member.getPassword()).equals(pw)) {
				result = "{\"process\":\"정상로그인\"}";										
			}
		}	
		if(result == null) result = "{\"process\":\"비정상로그인\"}";
		
		return result;
	} //loginresult END
	
	
	/*로그인*/
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String logintest(HttpServletRequest request) { //폼 출력요청
		System.out.println("로그인버튼클릭"); //정상출력됨
		String id ="", pw="";
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		System.out.println("로그인 입력정보 - "+id+":"+pw);
		List<MemberDTO> members = service.getAllMember(); //회원정보
		HttpSession session = request.getSession(); //세션 생성
		
		//회원식별
		for(MemberDTO member : members) {
			System.out.println(member);
			if(member.getId().equals(id) && Integer.toString(member.getPassword()).equals(pw)) {
				//회원인경우
				if(session.isNew()) { //클라이언트가 서버에 최초요청한 경우
					//세션값 설정
		            session.setAttribute("id", id);
					session.setAttribute("pw", pw);
					return "/board/list";
				}
				else { // 2번째요청부터는 세션정보를 가져온다
					id = (String)session.getAttribute("id");
					pw = (String)session.getAttribute("pw");
					return "/board/list";
				}				
			}
		}									
		return "/";
	}
	
	/* 회원가입 */
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String register() { //폼 출력요청
		return "register";//뷰이름
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST,
			produces= {"application/json;charset=utf-8"})
	@ResponseBody //JSON라이브러리 추가해야 사용가능
	public String register_success(String id, String pw, String name) { //폼 출력요청
		int password = Integer.parseInt(pw);
		System.out.println("register: "+id+":"+name+":"+pw);		
		List<MemberDTO> members = service.getAllMember();
		String result = null;
		for(MemberDTO member: members) {
			if(member.getId().equals(id) || member.getName().equals(name)) {
				result = "{\"process\":\"중복\"}";
			}
		}
		if(result==null) {
			result = "{\"process\":\"정상\"}";
			service.member_register(id, password , name);
		}		
		return result;		
	}
	
	/* 게시판 */
	@RequestMapping("/board/list")
	public ModelAndView getAllBoard(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		BoardPageDTO dto = new BoardPageDTO();
		
		//페이징처리
		int pageNum = Integer.parseInt(req.getParameter("page"));
		System.out.println(pageNum);
		int cntPerPage = 5;
		dto.setPageNum((pageNum-1) * cntPerPage  + 1);
		dto.setCntPerPage(pageNum * cntPerPage);
		
		List<BoardDTO> boardlist = service.getAllBoard(dto);
		mv.addObject("boardlist", boardlist); //(이름 , 전달객체)
		mv.setViewName("/board/list");
		return mv;
	}
	
	/* 게시글보기 */
	@RequestMapping(value="/board/detail",method=RequestMethod.GET)
	public ModelAndView getDetailBoard(HttpServletRequest req) {					
		ModelAndView mv = new ModelAndView();
		int seq = Integer.parseInt(req.getParameter("seq"));
		System.out.println("seq="+seq);
		BoardDTO dto = service.getDetailBoard(seq);
		System.out.println("detail");
		mv.addObject("dto", dto); //(이름 , 전달객체)
		mv.setViewName("/board/boarddetail");
		return mv;
	}
	
	/* 글쓰기 */
	@RequestMapping(value="/board/write",method=RequestMethod.GET)
	public String writeform() { //폼 출력요청			
		return "/board/boardwrite";//뷰이름
	}
	
	@RequestMapping(value="/board/write",method=RequestMethod.POST)
	public String insert(HttpServletRequest req, HttpServletResponse res) { //폼 출력요청			
		System.out.println(req.getAttribute("id")+":"+req.getAttribute("pw"));
		res.setContentType("text/html;charset=utf-8"); //한글로 인코딩
		res.setCharacterEncoding("euc-kr");
		service.insert_content(req.getParameter("title"),req.getParameter("contents"));
		return "/board/list";//뷰이름
	}
	
	/* 게시글 삭제 */
	@RequestMapping(value="delete",method=RequestMethod.POST,
			produces= {"application/json;charset=utf-8"})
	@ResponseBody //JSON라이브러리 추가해야 사용가능
	public String content_delete(String seq) { //폼 출력요청
		int Seq = Integer.parseInt(seq);
		String result = null;
		System.out.println("delete seq: "+Seq);
		service.deleteBoard(Seq);
		result = "{\"process\":\"삭제완료\"}";
		return result;
	}
	
	
}
