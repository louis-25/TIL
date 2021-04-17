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
		String result ="";
		if(request.getAttribute("boardlist")==null) { //boardlist의 객체가 없는경우
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
		
	}

}
