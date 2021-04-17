package servlettest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/lifecycle")
public class LifeCycleServlet extends HttpServlet {
	
	@Override
	public void destroy(){
		System.out.println("destroy 메소드 호출");
	}
	
	@Override
	public void init() throws ServletException{
		System.out.println("init 메소드 호출-수정2");
		//tomcat 서버 재컴파일 - 변경이전 서블릿 메모리 삭제(destroy)- 변경 이후 메모리 할당 - 처음(init) 다시실행
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet메소드 호출");
	}
	

}
