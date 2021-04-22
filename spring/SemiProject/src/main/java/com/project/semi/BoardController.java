package com.project.semi;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String loginform() { //폼 출력요청
		return "login";//뷰이름
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String logintest(HttpServletRequest request) { //폼 출력요청
		System.out.println("로그인버튼클릭");
		String id ="", pw="";
		List<BoardDTO> boardlist = service.getAllBoard(dto);
		
		HttpSession session = request.getSession(); //세션 생성
		if(session.isNew()) { //클라이언트가 서버에 최초요청한 경우
			//세션값 설정
            session.setAttribute("id", "jdbc");
			session.setAttribute("pw", "jdbc");
		}
		else { // 2번째요청부터는 세션정보를 가져온다
			id = (String)session.getAttribute("id");
			pw = (String)session.getAttribute("pw");
		}
		return "/board/list";//뷰이름
	}
	
	@RequestMapping("/board/list")
	public ModelAndView getAllBoard(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		BoardPageDTO dto = new BoardPageDTO();
		int pageNum = Integer.parseInt(req.getParameter("page"));
		int cntPerPage = 5;
		dto.setPageNum((pageNum-1) * cntPerPage  + 1);
		dto.setCntPerPage(pageNum * cntPerPage);
		List<BoardDTO> boardlist = service.getAllBoard(dto);
		mv.addObject("boardlist", boardlist); //(이름 , 전달객체)
		mv.setViewName("/board/list2");
		return mv;
	}
	
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
	
	@RequestMapping(value="/board/write",method=RequestMethod.GET)
	public String writeform() { //폼 출력요청
		return "/board/boardwrite";//뷰이름
	}
	
	
	
	
	// /boarddetail
	// 매개변수 seq 게시물번호
	// 리턴타입 modelandview
	// 구현 - 현재 선택 글번호 게시글 조회수 1 증가 sql 실행
	//       해당 게시글 조회
	// 뷰이름/board/detail.jsp - 테이블 태그 1개 게시물 모든 컬럼 출력
}
