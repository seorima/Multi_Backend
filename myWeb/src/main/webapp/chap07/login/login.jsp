<%@ page contentType="text/html; charset=UTF-8"
		 import = "chap04.LoginBean"
 %>
 
 <jsp:useBean id = "loginBean" class = "chap04.LoginBean" scope = "page" /> 
 
 <%--
	 <jsp:getProperty property="id" name="loginBean"/>
	<jsp:getProperty property="passwd" name="loginBean"/>
  --%>
 
 
<%

 //LoginBean loginBean = new LoginBean();
	
//	loginBean.setId(request.getParameter("id")); 
//	loginBean.setPasswd(request.getParameter("passwd")); 이 세개 지우고 밑에 get porperty 알아보는
	String msg = ""; 
	
	if(loginBean.checkLogin()){
		msg +="<h4>" + loginBean.getId()+ "님의 방문을 환영합니다.</h4>";
		msg +="<h5>id : " + loginBean.getId()+ ", 패스워드 : " + loginBean.getPasswd() + "</h5>";
	}
	else {
		msg += "<h4>로그인을 실패했습니다... 다시 로그인해주세요.</h4>";
		msg += "<a href='loginForm.html'>로그인</a>";
	}


%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>

	<h1>로그인 결과</h1>
	<hr />
	
	<%= msg %>
	<h5>id : <jsp:getProperty property="id" name="loginBean"/>,
		passwd : <jsp:getProperty property="passwd" name="loginBean"/></h5> <%--성공이던 실패던 --%>


</body>
</html>