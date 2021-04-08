package forward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDTO;

@WebServlet("/forward2")
public class Forward2Servlet extends HttpServlet {	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("<h1>(forward2)로그인아이디="+id+"</h1>");
		
		BoardDTO dto = (BoardDTO)request.getAttribute("board");
		response.getWriter().println("<h1>"+dto.getTitle()+":"+dto.getContents()+"</h1>");
	}

}
