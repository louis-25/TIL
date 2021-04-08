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
		String id = request.getParameter("id");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("<h1>(forward1)로그인아이디="+id+"</h1>");
		
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle("제목");
		dto.setContents("내용");
		
		//forward2에 객체를 전달하는방법 "board"는 객체의 이름
		request.setAttribute("board", dto); 
		
		//forward2와 공유
		RequestDispatcher dis = request.getRequestDispatcher("forward2");
		dis.forward(request, response);
		//forward시에는 이전 응답 출력 저장 삭제 - 이동
	}

}
