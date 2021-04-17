package forward;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;

@WebServlet("/board1")
public class BoardServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pagenum = Integer.parseInt(request.getParameter("page")); //url상에 ?page=1 써보자
		BoardDAO dao = new BoardDAO();
		//dao에서 list객체 반환
		ArrayList<BoardDTO> list = dao.getBoardList(pagenum, 5);
		
		//요청에 "boardlist"key로 list객체 세팅
		request.setAttribute("boardlist", list); 
		
		//board2와 공유
		RequestDispatcher dis = request.getRequestDispatcher("board2");
		dis.forward(request, response); //board2로 요청 던지기
		
		
	}

}
