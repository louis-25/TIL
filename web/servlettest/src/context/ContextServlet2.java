package context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context2")
public class ContextServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 10;
		//현재 서블릿과 동일 컨텍스트 존재 모든 서블릿 공유
		ServletContext context = request.getServletContext();
		Integer cnt = (Integer)context.getAttribute("cnt");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("<h3> cnt 속성을 공유받았습니다 = "+(cnt+10)+" </h3>");
		context.setAttribute("cnt", cnt+10);
	}

}
