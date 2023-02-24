<%@ page contentType="text/html; charset=UTF-8" %>

<%
   String name = request.getParameter("name");
	String email = request.getParameter("email");
	String tel = request.getParameter("tel");
%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   <link rel = "stylesheet" href="style.css">
</head>
<body>

   <div id="header">
      <h3>[메일] [카페] [블로그] [뉴스] [공지사항] [쇼핑]</h3>
   </div>
   
   <div id="left">
         <h3> [뉴스] </h3>
         <h5>백엔드 7기 프로젝트 임박</h5>
         <h5>백엔드 7기 프로젝트 임박</h5>
         <h5>백엔드 7기 프로젝트 임박</h5>
         <h5>백엔드 7기 프로젝트 임박</h5>
      </div>

<div id="right">

<h3> [쇼핑] </h3>
	<h5>삼성 TV 폭탄 세일</h5>
	<h5>삼성 TV 폭탄 세일</h5>
	<h5>삼성 TV 폭탄 세일</h5>
	<h5>삼성 TV 폭탄 세일</h5>
 
</div>

<div id="footer">

<h3> [회사소개] [찾아오시는 길] [페이지 맵]] </h3>
<h4>대표 : <%= name %> /email: <%=email %> /email: <%=email %> tel: <%=tel %> </h4>

</div>


</body>
</html>