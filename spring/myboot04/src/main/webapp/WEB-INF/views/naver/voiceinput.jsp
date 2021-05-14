<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
   
});
</script>
</head>
<body>
<h1>tts 서비스를 위한 파일 선택</h1>
<%
String [] speakers = {"mijin","jinho","clara","matt","shinji","meimei","liangliang","jose","carmen"};
String [] informs = {"미진 : 한국어,여성 음색","진호 : 한국어, 남성 음색","clara : 클라라 : 영어, 여성 음색",
      "matt : 매트 : 영어, 남성 음색"," 신지: 일본어, 남성 음색","메이메이 : 중국어, 여성 음색","리앙리앙 : 중국어, 남성 음색",
      "호세 : 스페인어, 남성 음색","카르멘 : 스페인어, 여성 음색"};
%>

<form action="/voice">
   음색선택 :
   <%for(int i=0;i<speakers.length;i++){ %>
      <input type=radio name="speaker" value="<%=speakers[i] %>"> <%=informs[i] %>
   <%
   }
   %>
   <br>
   <select name="image">
      <%
         String[] filelist = (String[])request.getAttribute("filelist");
         for(String file : filelist){
            String[] f_split = file.split("[.]");
            String ext = f_split[f_split.length-1];
            if(ext.equals("txt")){
      %>
         <option value="<%=file%>"> <%=file %></option>
      <%
      }
}
%>
   </select>
   <input type="submit" value="음성으로변환요청">
</form>




   


</body>
</html>