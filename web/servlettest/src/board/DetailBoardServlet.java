package board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/detailboard")
public class DetailBoardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 1. seq 파라미터 읽어서
		 * 2. BoardDAO메소드 추가
		 * 	  2-0. 메소드파라미터(int seq)
		 * 	  2-1. update board set viewcount = viewcount + 1 where seq=? 조회수 증가
		 *    2-2. select * from board where seq=? 실행
		 * 	  2-3. BoardDTO 타입 리턴\
		 * 3. 적당한 html 태그들 BoardDTO 내용 출력 응답
		 * */
		
		//1. seq 파라미터 읽어서
		//2. BoardDAO메소드 추가
		int seq = Integer.parseInt(request.getParameter("seq"));	
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.getDetailBoard(seq);
				
		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter();
		String result = "";
		
		result += "<table border = 3>";
		result += "<tr><td>번호</td><td>"+dto.getSeq()+"</td></tr>";
		result += "<tr><td>제목</td><td>"+dto.getTitle()+"</td></tr>";
		result += "<tr><td>내용</td><td>"+dto.getContents()+"</td></tr>";
		result += "<tr><td>작성자</td><td>"+dto.getWriter()+"</td></tr>";
		result += "<tr><td>암호</td><td>"+dto.getPassword()+"</td></tr>";
		result += "<tr><td>시간</td><td>"+dto.getTime()+"</td></tr>";
		result += "</table>";
						
		out.println(result);
	}


}
