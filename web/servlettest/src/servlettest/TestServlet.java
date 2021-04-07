package servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:9090/servlettest/servlet/servlettest.TestServlet
public class TestServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		PrintWriter out = response.getWriter();
		String msg = "Hello Servlet";
		out.println("<html><head><title>제목</title></head><body><h1>"+msg+"</h1></body></html>");
	}
}
