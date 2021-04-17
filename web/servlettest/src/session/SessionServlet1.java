package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session1")
public class SessionServlet1 extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트 요청속에 세션 포함 여부 판단하자
		//브라우저 열고 요청1 - 요청2 - 브라우저 종료 - 세션정보 삭제
		//세션정보 서버측 저장, 세션정보사용가능 식별자 -> 클라이언트에 저장
		String id ="", pw="";
		HttpSession session = request.getSession();
		/*클라이언트 요청속에 세션 포함되어 있으면 서버 요청한 적 있다
		 * 세션객체 생성 필요없으니 기존 생성 세션 사용
		 * 아니면 서버 요청한 적 없다
		 * 세션객체 생성
		 * */
		if(session.isNew()) { //클라이언트가 서버에 최초요청한 경우
			session.setAttribute("id", "jdbc");
			session.setAttribute("pw", "jdbc");
		}
		else {
			id = (String)session.getAttribute("id");
			pw = (String)session.getAttribute("pw");
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("세션정보확인="+id+":"+pw+"<br>");
	}
}
/*1.브라우저열고 세션1을 실행한다
 * 2.세션 2개 정보 저장한다.
 * 3.세션2를 실행한다
 * 4.세션에 저장된 2개정보를 추출한다
 * 5.세션1을 실행한다
 * 6.세션에 저장된 2개정보를 추출한다
 * 7.브라우저 닫는다
 * 8.브라우저 열고 세션2를 실행한다
 * 9.세션정보가 사라졌다
 * */
