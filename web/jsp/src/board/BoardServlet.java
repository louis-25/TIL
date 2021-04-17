package board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/boardstart")
public class BoardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		int pageNum = 0;
		if(page == null) {
			pageNum = 1;
		}else {
			pageNum = Integer.parseInt(page);
		}
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.getBoardList(pageNum, 5);
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("board/boardstart.jsp");
		rd.forward(request, response);
	}


}
