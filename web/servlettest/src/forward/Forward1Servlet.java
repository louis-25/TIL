package forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDTO;

@WebServlet("/forward1")
public class Forward1Servlet extends HttpServlet {	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		BoardDTO dto = new BoardDTO();
		dto.setTitle("제목");
		dto.setContents("내용");
		
		//요청에 "board"라는 key로 dto객체를 세팅
		request.setAttribute("board", dto);
		request.setAttribute("id", "무야호");
		
		//forward2와 공유
		RequestDispatcher dis = request.getRequestDispatcher("forward2");
		dis.forward(request, response);
		//forward시에는 이전 응답 출력 저장 삭제 - 이동
	}

}
