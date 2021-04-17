package context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context1")
public class ContextServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 10;
		//현재 서블릿과 동일 컨텍스트 존재 모든 서블릿 공유
		response.setContentType("text/html;charset=utf-8");
		ServletContext context = request.getServletContext();
		PrintWriter o = response.getWriter();		
		if(context.getAttribute("cnt")==null) {
		
			context.setAttribute("cnt", count);
		o.println("<h3> cnt 속성을 공유했습니다 </h3>");
		}
		else {			
			o.println("<h3>"+context.getAttribute("cnt")+"</h3>");
			context.setAttribute("cnt", (Integer)context.getAttribute("cnt")+10);
		}
	}

}
