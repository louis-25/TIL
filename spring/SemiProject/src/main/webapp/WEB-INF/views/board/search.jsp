<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<h1>boardlist 를 출력합니다. </h1>
<form action="boardsearch.html">
	<select >
	<option > 제목 </option>
	<option> 내용 </option>
	<option> 작성자 </option>
	</select>
	검색어입력:<input type=text >
	<input type=submit value="검색">
</form>

<table id="list">
<!-- <tr><td>1행 1열 제목이  자바  인 형태를 검색하셨습니다. </td></tr>
     2행 1열  내용이 오라클 인 형태를 검색하셨습니다.
     ........
-->
</table>

<script type="text/javascript">
 document.querySelector("form").onsubmit = function(e){
	 var option_list = 
		 document.querySelectorAll("select option")//select  태그 포함  option들
	 for(var i = 0; i < option_list.length; i++){
		 if(option_list[i].selected == true){
			 var item = option_list[i].innerHTML;
		 }
	 }
	 var word = document.querySelector("input[type=text]").value;
	 var table = document.querySelector("table");
	 table.style.border = "solid 3px red"
	 var td = document.querySelector("td");
	 
	 table.innerHTML += "<tr><td>" + item + " 이  " + word +" 인 형태를 검색하셨습니다. </td></tr>";
	 e.preventDefault();//action="boardsearch.html 이동안한다
	 
 }
</script>

</body>
</html>