package servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getMethod().equals("POST")) {
			//POST방식일때 처리할 코드
		}
		else if(req.getMethod().equals("GET")) {
			//GET방식일때 처리할 코드
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();	
			String gugudan = req.getParameter("gugudan");
			String result ="";
			switch(gugudan) {
				case"2":
					result=gugudan("2");
					out.println(result);
					break;
				case"3":
					result=gugudan("3");
					out.println(result);
					break;
				case"4":
					result=gugudan("4");
					out.println(result);
					break;
				case"5":
					result=gugudan("5");
					out.println(result);
					break;
				case"6":
					result=gugudan("6");
					out.println(result);
					break;
				case"7":
					result=gugudan("7");
					out.println(result);
					break;
				case"8":
					result=gugudan("8");
					out.println(result);
					break;
				case"9":
					result=gugudan("9");
					out.println(result);
					break;
				default:
					result=gugudan("2");
					out.println(result);
					break;
			}								
		}		
	}
	public String gugudan(String num) {
		String result="<table border=3>";
		for(int i=1; i<10; i++) {
			result += "<tr><td>"+num+" x "+Integer.toString(i)+"="+
		Integer.toString(Integer.parseInt(num)*i)+"</td></tr>";
		}
		result+="</table>";
		return result;
	}
	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
