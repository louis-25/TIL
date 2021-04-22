<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/resources/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/style.css">
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body width="100%" height="100%">
    <form action="index.html" method="post" class="loginForm">
      <h2>Login</h2>
      <div class="idForm">
        <input type="text" class="id" placeholder="ID">
      </div>
      <div class="passForm">
        <input type="password" class="pw" placeholder="PW">
      </div>
      <button type="button" class="btn" onclick="button()">
        LOG IN
      </button>
      <script>
      	let button = () => {
        	alert('login Button !')
        }
      </script>
      <div class="bottomText">
        Don't you have ID? <a href="#">sign up</a>
      </div>
    </form>
  </body>

</html>