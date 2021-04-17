# forward

URL상에는 forward1인데 실행내용은 forward2에서 실행된다

```java
package forward;

import board.BoardDTO;

@WebServlet("/forward1")
public class Forward1Servlet extends HttpServlet {	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		BoardDTO dto = new BoardDTO();
		dto.setTitle("제목");
		dto.setContents("내용");
		
		//요청에 "board"라는 key로 dto객체를 세팅
		request.setAttribute("board", dto);
        //요청에 "id"라는 key로 "무야호" 전달
		request.setAttribute("id", "무야호");
		
		//forward2와 공유
		RequestDispatcher dis = request.getRequestDispatcher("forward2");
		dis.forward(request, response);//forward2로 요청 던지기
		
	}

}

```

```java
package forward;

import board.BoardDTO;

@WebServlet("/forward2")
public class Forward2Servlet extends HttpServlet {	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = (String)request.getAttribute("id");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("<h1>(forward2)로그인아이디="+id+"</h1>");
		
		BoardDTO dto = (BoardDTO)request.getAttribute("board");
		response.getWriter().println("<h1>"+dto.getTitle()+":"+dto.getContents()+"</h1>");
	}

}
```

<br>

## Board-forward 예제

```java
package forward;

import board.BoardDAO;
import board.BoardDTO;

@WebServlet("/board1")
public class BoardServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //url상에 http://localhost:9090/servlettest/board1?page=1 써보자
		int pagenum = Integer.parseInt(request.getParameter("page"));
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

```

<br>

```java
package forward;

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

```