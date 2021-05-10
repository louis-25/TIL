# JSP

JSP는 복잡한 서블릿코드를 개선하여 개발자와 디자이너에게 편의성을 제공하기위해 탄생한 언어이다

![image-20210412235957218](C:%5CUsers%5C%EC%A0%95%EB%8F%99%ED%98%84%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20210412235957218.png)

<br>

### 디렉티브 태그

디렉티브 태그는 주로 JSP페이지에 대한 전반적인 설정 정보를 지정할 때 사용하는 태그이다

**include 디렉티브**

`<%@ include file="image.jsp" %>` : image.jsp 를 포함한다

**page 디렉티브**

`<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>` : 페이지의 속성값을 나타낸다

<br>

### JSP 스크립트 요소

**스크립트릿**

스크립트릿은 JSP에서 제공하는 여러 가지 동적인 처리를 제공하는 기능으로

HTML태그에서 자바코드를 사용할 수 있게 해준다

<% %> 기호 안에 자바 코드로 구현하면된다

<br>

**선언문 사용하기**

```java
<%! String name = "멤버변수";
	public String getName() {return name}
%>
<body>
    out.println(getName()); // 멤버변수
</body>
```

**주석**

```java
<%-- 주석 --%>
```

<br>

### JSP에서 제공하는 내장 객체

![image-20210413001943447](C:%5CUsers%5C%EC%A0%95%EB%8F%99%ED%98%84%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20210413001943447.png)

<br>

### JSP 예외처리

에러가 발생할거같은 jsp에 errorPage로 예외처리 jsp에 넘겨주면 된다
예외처리 jsp에서는 isErrorPage="true"로 설정해 예외처리 페이지임을 알려주자

```java
/*a.jsp - 에러가 발생하면 b.jsp로 넘기겠다*/
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="b.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</script>
</head>
<body>
<%
String num = request.getParameter("num");
int num2 = Integer.parseInt(num);
//NullPointerException, NumberFormatException
out.println("<h1>"+10/ num2+"</h1>"); // AurithmeticException
%>
</body>
</html>
```

```java
/*b.jsp - 예외를 처리하는 페이지*/
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</script>
</head>
<body>
<%System.out.println(exception); %>
<%="서버 임시적으로 문제가 생겼습니다. | 잠시후 다시 접속하세요." %>
</body>
</html>
```

<br>

### JSP의 여러가지 액션태그

`<jsp:include> ` : 이미 있는 JSP를 현재 JSP에 포함하는 태그

`<jsp:forward>` : 서블릿에서 RequestDispatcher클래스의 포워딩 기능을 대신하는 태그

`<jsp:useBean>` : 객체를 생성하기 위한 new 연산자를 대신하는 태그

`<jsp:setProperty>` : setter를 대신하는 태그

`<jsp:getProperty>` : getter를 대신하는 태그

<br>

**액션태그 활용예제**

`<jsp:include> `

```java
/*board.jsp*/
<jsp:include page="share.jsp" >
	<jsp:param value="/html/images/google.png" name="img"/>
</jsp:include>
```

```java
/*share.jsp*/
<body>
<% String name=request.getParameter("img"); %>
<img src="<%=name%>" width="300" height="300">
</body>
```

<br>

`<jsp:forward>` `<jsp:useBean>` `<jsp:setProperty>` `<jsp:getProperty>`

```java
<jsp:useBean id="dto" class="board.BoardDTO"/>
<jsp:setProperty property="seq" name="dto" value="1"/>
<jsp:setProperty property="title" name="dto" value="<%=request.getParameter(\"title\") %>"/>
<jsp:setProperty property="contents" name="dto" value="<%=request.getParameter(\"contents\") %>"/>
<jsp:setProperty property="writer" name="dto" value="<%=request.getParameter(\"writer\") %>"/>
<jsp:setProperty property="password" name="dto" value="<%=Integer.parseInt(request.getParameter(\"password\")) %>"/>
번호값 확인1:<jsp:getProperty property="seq" name="dto"/>
제목 확인1:<jsp:getProperty property="title" name="dto"/>
내용 확인1:<jsp:getProperty property="contents" name="dto"/>
작성자 확인1:<jsp:getProperty property="writer" name="dto"/>
암호 확인1:<jsp:getProperty property="password" name="dto"/>

<jsp:forward page="beantest2.jsp"/>

```

<br>

### 요청

jsp는 servlet과는 다르게
작성하는 모든 내용이 기본 내장객체 _jspService(HttpServletRequest request, ..~ response) 로 관리된다
따라서 따로 doGet, doPost등 메소드를 따로 안만들어줘도 된다

```java
/*JSP*/
/*scope값을 session으로 변경하면 session과 같은기능*/
<jsp:useBean id="dto" class"board.BoardDTO" scope="request"/>
```

```java
/*Servlet - JSP는 한줄이면 될것을 Servlet은 여러줄을 써줘야함*/
if(request.getAttribute("dto")) == null) {
    dto = new BoardDTO();
    request.setAttribute("dto", dto);
}
else {
    dto = request.getAttribute("dto");
}
```

