package board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDTO;


@WebServlet("/boardwrite")
public class BoardWriteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dopost -- boardDAO - insertBoard(BoardDTO)호출 -> db저장
		//리스트로 이동 링크
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String writer = request.getParameter("writer");
		int password = Integer.parseInt(request.getParameter("password"));
		
		//weiter가 member id이면 writer를 세션에 저장 글쓰기 진행
		boolean member_result = dao.getMember(writer);
		//writer를 세션에 저장		
		HttpSession session = request.getSession();
		//1번째 요청 - 세션 생성 | 2번부터 재사용
		if(session.getAttribute("session_writer")==null) {		
			session.setAttribute("session_writer",writer);
			System.out.println("세션저장완료");
		}
		
		
		String result = "";
		if(member_result) {
			dto.setTitle(title);
			dto.setContents(contents);
			dto.setWriter(writer);
			dto.setPassword(password);
			
			session.setAttribute("board", dto);
			
			dao.insertBoard(dto);
			result = "<h1>글쓰기완료<h1>";
			result += "<h1><a href='boardlist?page=1'>리스트로 돌아가기</a></h1>";
		}else {
			result = "<h1>회원가입부터 하세요</h1>";
		}
						
		PrintWriter out = response.getWriter();
				
		out.println(result);
	}

}
