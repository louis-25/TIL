# Context

```java
package context;

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

```

```java
package context;

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

```

```java
package context;

@WebServlet("/context3")
public class ContextServlet3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//web.xml <context-param 메뉴 입력값 가져오기
		ServletContext context = request.getServletContext();
        String menu = context.getInitParameter("menu"); 
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("<h3>"+menu+" </h3>");
	}

}

```

