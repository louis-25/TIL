package board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/boardlist")
public class BoardListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지번호 입력
		/* <form action="boardlist" >
		 * <input type=text name='page' >
		 * <input type=submit value="조회">
		 * 
		 * <a href="boardlist?page=1"> 1 </a> <a href="boardlist?page=2"> 2 </a> <a href="boardlist"> 3 </a>
		 * */
		String page = request.getParameter("page");
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = null;
		if(page == null || page.equals("")) {
			//페이지번호 없으면 전체 board 리스트 출력
			list = dao.getBoardList();

		}
		else {
			int pagenum = Integer.parseInt(page);
			list = dao.getBoardList(pagenum, 5);
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String result = "";
		result +="<table border = 3>";
		for(BoardDTO dto : list) {
			result += "<tr><td>" + dto.getSeq() 
			+ "</td><td><a href='detailboard?seq=" + dto.getSeq() + "'>" + dto.getTitle()
			+ "</a></td><td>" + dto.getWriter() + "</td><td>" + dto.getViewcount() + "</td></tr>";
		}
		result +="</table>";

		result += "<h1>페이지번호</h1>";
		
		int totalcnt = dao.getBoardCount(); //11
		int pagecnt = totalcnt / 5;//3
		if(totalcnt % 5 != 0) { pagecnt = pagecnt+1; }
		for(int i = 1; i <= pagecnt ; i++) {
			result += "<a href='boardlist?page=" + i + "'> " + i + " </a>";
		}
		
		//글쓰기 버튼 클릭 시 boardwrite.html로 이동
		result += "<button id='write'>글쓰기</button>";
		result += "<script>document.getElementById('write').onclick = function(){"
				+ "location.href='boardwrite.html'"
				+ "}</script>";
					
		//작성자 xxx가(세션에서 가져옴) 글쓰기를 완료했습니다 출력		
		HttpSession session = request.getSession();
		String session_writer = (String)session.getAttribute("session_writer");
		BoardDTO board = (BoardDTO)session.getAttribute("board");
				
		result += "<br><h3>"+session_writer+"가 작성했습니다"+"</h3>";
		result += "<h3>글 작성내용</h3>";
		result += board.getTitle()+" : "+board.getContents()+" : "+board.getPassword();
		
		out.println(result);
	}

}







