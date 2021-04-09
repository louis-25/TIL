package config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/initparameter" }, 
		initParams = { 
				@WebInitParam(name = "user", value = "hr"), 
				@WebInitParam(name = "pw", value = "hr")
		})
public class InitParameterServlet extends HttpServlet {

	String user;
	String pw;
	//서블릿의 초기화메세지 받아오는 용도
	@Override
	public void init(ServletConfig config) throws ServletException {
		user = config.getInitParameter("user");
		pw = config.getInitParameter("pw");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("<h3>"+user+" | "+pw+"</h3>");
		ServletContext context = request.getServletContext();
		o.println(context.getInitParameter("menu"));
	}

}
