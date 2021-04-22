<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
li{background-color:pink;
margin : auto;
width : 300px;}
</style>
<script src="<%=request.getContextPath() %>/resources/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/writestyle.css">

</head>
<body>

<div class="container">  
  <form id="contact" action="" method="post">
    <h3>자취꿀팁</h3>
    <h4>자신만이 알고있는 자취꿀팁을 적어주세요!</h4>
    <fieldset>
      <input placeholder="별명" type="text" tabindex="1" required autofocus>
    </fieldset>
    <fieldset>
      <textarea placeholder="내용입력" tabindex="5" required></textarea>
    </fieldset>    
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">작성</button>
    </fieldset>
  </form>
 
  
</div>
</body>
</html>