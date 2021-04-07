package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
			request.setCharacterEncoding("utf-8");
			login(request, response);
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		login(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//브라우저에서 한글 입력시 인코딩		
				request.setCharacterEncoding("utf-8");
				
				Enumeration<String> names = request.getParameterNames();
				//request 정보를 출력하는법
				while(names.hasMoreElements()) {
					String name = names.nextElement();
					System.out.println(name); // id, pw, name
				}
				
				//요청정보 추출 id, pw 전송 - 입력
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				//체크박스 내용 받아올 배열
				String[] locations = request.getParameterValues("location");

				//로그인처리
				String result = "";
				if(id.equals("user") && pw.equals("1234")) {
					result = "<h3 style=colir:green>정상 로그인되었습니다</h3>";
				}
				else {
					result = "<h3 style=colir:green>비정상 로그인되었습니다</h3>";
					result += "<h3><a href='http://127.0.0.1:9090/servlettest/loginform.html'>로그인창으로 이동</a></h3>";
				}
				//응답 결과 브라우저 출력 - mine type
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();	
				out.println(result);
				System.out.println(result);
				
				for(String loc : locations) {
					out.println(loc + "<br>");
				}
	}
	
}
