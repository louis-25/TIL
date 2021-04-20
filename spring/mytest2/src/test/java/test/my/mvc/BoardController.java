package test.my.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	@RequestMapping("/boardlist") // /emplist요청이 들어오면 아래의 코드실행
	public ModelAndView getBoardList(){ 
		//mybatis SqlSession -> EmpDAO -> EmpService -> EmpMain
		List<BoardDTO> list = service.getAllBoard();
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardlist", list); //jsp에서 boardlist로 접근하자
		mv.setViewName("/board/boardlist"); // WEB-INF/views/mytest/boardlist.jsp
		return mv;
		
	}
	// url - /board-detail
	// 매개변수 seq=게시물번호
	// 리턴타입 ModelAndView
	// 구현 - 현재 섵낵 글번호 게시글 조회수 1 증가 sql실행
		
	// 뷰이름 /board/detail.jsp - 테이블 태그 1개 게시물 모든 컬럼 출력
	//
}
