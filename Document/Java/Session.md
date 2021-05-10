# Session

## 세션에 간단한 문자열 저장

```java
package session;

@WebServlet("/session1")
public class SessionServlet1 extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트 요청속에 세션 포함 여부 판단하자
		//브라우저 열고 요청1 - 요청2 - 브라우저 종료 - 세션정보 삭제
		//세션정보 서버측 저장, 세션정보사용가능 식별자 -> 클라이언트에 저장
		String id ="", pw="";
		HttpSession session = request.getSession(); //세션 생성
		/*클라이언트 요청속에 세션 포함되어 있으면 서버 요청한 적 있다
		 * 세션객체 생성 필요없으니 기존 생성 세션 사용
		 * 아니면 서버 요청한 적 없다
		 * 세션객체 생성
		 * */
		if(session.isNew()) { //클라이언트가 서버에 최초요청한 경우
			//세션값 설정
            session.setAttribute("id", "jdbc");
			session.setAttribute("pw", "jdbc");
		}
		else { // 2번째요청부터는 세션정보를 가져온다
			id = (String)session.getAttribute("id");
			pw = (String)session.getAttribute("pw");
		}
		response.setContentType("text/html;charset=utf-8"); //한글로 인코딩
		PrintWriter o = response.getWriter(); // html에 출력하기위한 객체
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

```

<br>

```java
package session;

@WebServlet("/session2")
public class SessionServlet2 extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id ="", pw="";
		HttpSession session = request.getSession();
		
        //session1에서 설정한 세션정보를 가져오자
		id = (String)session.getAttribute("id");
		pw = (String)session.getAttribute("pw");
		
        //가져온 세션정보 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("세션정보확인="+id+":"+pw+"<br>");
	}
}

```

<br>

## 세션에 객체전달

```java
package session;

import member.MemberDTO;

@WebServlet("/session3")
public class SessionServlet3 extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO dto = new MemberDTO();
		HttpSession session = request.getSession();
		/*클라이언트 요청속에 세션 포함되어 있으면 서버 요청한 적 있다
		 * 세션객체 생성 필요없으니 기존 생성 세션 사용
		 * 아니면 서버 요청한 적 없다
		 * 세션객체 생성
		 * */
		if(session.isNew()) { //클라이언트가 서버에 최초요청한 경우
			dto.setId("jdbc");
			dto.setPassword(1111);
			dto.setName("무야호");
			session.setAttribute("member",dto);
		}
		else {
			dto = (MemberDTO)session.getAttribute("member");
		}		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("세션정보확인="+dto+"<br>");
	}
}


```

<br>

```java
package session;

import member.MemberDTO;

@WebServlet("/session4")
public class SessionServlet4 extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		HttpSession session = request.getSession();		
		
        //session3에서 설정한 객체정보 가져오기
		dto = (MemberDTO)session.getAttribute("member");
				
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("세션정보확인="+dto+"<br>");
	}
}

```

<br>

## 세션제거

```java
package session;

import member.MemberDTO;

@WebServlet("/session5")
public class SessionServlet5 extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		HttpSession session = request.getSession();		
		
		//member세션이 있을경우 제거해라
		if(session.getAttribute("member")!=null) {
			//session.removeAttribute("member");
			session.invalidate(); //세션의 모든속성제거
		}			
				
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("세션정보확인="+dto+"<br>");
	}
}

```



