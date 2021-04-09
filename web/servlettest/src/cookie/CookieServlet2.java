package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie2")
public class CookieServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재서버가 만들어서 전송했던 쿠키들을 전달받자
		Cookie[] coos = request.getCookies();
		
		//쿠키전송		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		for(int i=0; i<coos.length; i++) {
			o.println(coos[i].getName()+"="+coos[i].getValue()+"<br>");		
		}
		o.println("위와 같은 쿠키를 클라이언트로 전송했습니다");
		
	}

}
