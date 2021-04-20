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
	@RequestMapping("/boardlist")
	public ModelAndView getAllBoard() {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> boardlist = service.getAllBoard();
		mv.addObject("boardlist", boardlist); //(이름 , 전달객체)
		mv.setViewName("/board/list");
		return mv;
	}
	// /boarddetail
	// 매개변수 seq 게시물번호
	// 리턴타입 modelandview
	// 구현 - 현재 선택 글번호 게시글 조회수 1 증가 sql 실행
	//       해당 게시글 조회
	// 뷰이름/board/detail.jsp - 테이블 태그 1개 게시물 모든 컬럼 출력
}
