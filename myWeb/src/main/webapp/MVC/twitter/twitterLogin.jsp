<%@ page contentType="text/html; charset=UTF-8"
		 import="mvc.twitter.*"
%>


<jsp:useBean id="loginDO" class="mvc.twitter.TwitterLoginDO" scope="page" />  <!-- 요청이 들어올때마다 로그인 값을 받아오니까 -->
<jsp:setProperty name="loginDO" property="*" /> 
<jsp:useBean id="twitterDAO" class="mvc.twitter.TwitterDAO" scope="session" />

<%
	if(request.getMethod().equals("POST")) {
		TwitterLoginDO result = twitterDAO.checkLogin(loginDO);		
		
		if(result != null) {
			session.setAttribute("id", result.getId());
			session.setAttribute("name", result.getName()); //세션에 저장했기때문에 id name 다른페이지에서도 사용이가능
			response.sendRedirect("twitterlist.jsp");
		}
	}
%>


<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>twitterLogin.jsp</title>
</head>

<body>

	<h2>트위터 로그인</h2>
	<hr />
	
	<form method="POST">
	<fieldset>	
		<legend>로그인</legend>
		<label for="id">ID</label>
		<input type="text" name="id" id="id" /> /
		<label for="passwd">Passwd</label>
		<input type="password" name="passwd" id="passwd" />
		<input type="submit" value="login" />
	</fieldset>
	</form>
	

</body>
</html>