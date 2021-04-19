package ajax;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginAjaxController {
@RequestMapping(value="/ajax/login",method=RequestMethod.GET)
public String loginform() { //폼 출력요청
	return "/ajax/loginajax";//뷰이름
}

@RequestMapping(value="/ajax/login",method=RequestMethod.POST,
produces= {"application/json;charset=utf-8"})
@ResponseBody //JSON라이브러리 추가해야 사용가능
//date:{'id':$("#id").val(), 'pw':$('#pw').val()}
public String loginform(String id, String pw) {//폼 입력 데이터 전송 ajax요청
	System.out.println(id+":"+pw);
	String result = null; //json형태의 결과를 담을 변수
	if(id.equals("spring") && pw.equals("spring")) {
		result = "{\"process\":\"정상로그인\",\"role\":\"admin\"}";
	}else {
		result = "{\"process\":\"비정상로그인\",\"role\":\"user\"}";
	}
	return result;
} //loginresult END


//@RequestMapping("/ajax/board")
//@ResponseBody
//public BoardDTO getBoardDTO(int seq){
//	BoardDTO dto = new BoardDTO();
//	dto.setSeq(seq);
//	dto.setTitle("게시물제목");
//	dto.setContents("게시물내용");
//	dto.setWriter("작성자");
//	dto.setViewcount(100);
//	
//	return dto; 
//}

@RequestMapping("/ajax/board/{seq}")
@ResponseBody
public BoardDTO getBoardDTO(@PathVariable("seq") int seq){
	BoardDTO dto = new BoardDTO();
	dto.setSeq(seq);
	dto.setTitle("게시물제목");
	dto.setContents("게시물내용");
	dto.setWriter("작성자");
	dto.setViewcount(100);
	
	return dto; 
}

@RequestMapping("/ajax/boardlist")
@ResponseBody
public ArrayList<BoardDTO> getBoardDTO(){
	BoardDTO dto = new BoardDTO();
	dto.setSeq(1);
	dto.setTitle("게시물제목");
	dto.setContents("게시물내용");
	dto.setWriter("작성자");
	dto.setViewcount(100);
	ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
	list.add(dto);
	list.add(dto);
	list.add(dto);
	list.add(dto);
	list.add(dto);
	
	return list; 
}

// /ajax/board/1 - url내부값 처리

}
