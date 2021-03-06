package forward;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;

@WebServlet("/board2")
public class BoardServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*int pagenum = Integer.parseInt(request.getParameter("page"));
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.getBoardList(pagenum, 5);
		// 출력1 - table태그 - forward.BoardServlet2.java(board2 url)
		// board2 서블릿 호출 . list 전달
		// 전달받은 list를 table 출력
		list = (ArrayList<BoardDTO>)request.getAttribute("board"); 
		
		for(BoardDTO dto : list) {
			System.out.println(dto.getTitle());
		}*/
		String result ="";
		if(request.getAttribute("boardlist")==null) {
			result += "<h1>게시물이 없습니다</h1>";
		}
		else {
			ArrayList<BoardDTO> list = (ArrayList<BoardDTO>) request.getAttribute("boardlist");
			result +="<table border = 3>";
			for(BoardDTO dto : list) {
				result += "<tr><td>" + dto.getSeq() 
				+ "</td><td><a href='detailboard?seq=" + dto.getSeq() + "'>" + dto.getTitle()
				+ "</a></td><td>" + dto.getWriter() + "</td><td>" + dto.getViewcount() + "</td></tr>";
			}
			result +="</table>";
		}
		
		//응답파일 html --> "text/html" : mime type
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println(result);
		
		//출력2 - ul ol li 태그 - forward.BoardServlet3.java(board3 url)
		
	}

}
