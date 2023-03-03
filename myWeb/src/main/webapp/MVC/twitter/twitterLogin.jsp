<%@ page contentType="text/html; charset=UTF-8"
		 import = "mvc.twitter.*"

 %>
 
<jsp:useBean id = "twitterDAO" class = "mvc.twitter.TwitterDAO" />  
<jsp:useBean id = "loginDO" class = "mvc.twitter.TwitterLoginDO" />
<jsp:setProperty name = "LoginDO" property = "*" />

<%
	if(request.getMethod().equals("POST")){
		TwitterLoginDO result = twitterDAO.getLoginDO(loginDO); //twitterlogindo
		
		if(result != null){
			session.setAttribute("id",result.getId());
			session.setAttribute("name",result.getname());
			pageContext.forward("twitterlist.jsp");
		}
	}

%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>


<h1>트위터 로그인</h1>
	<hr />
	
	<form method="POST" action="twitterlist.jsp">
	
	<fieldset>
		<legend>로그인</legend>
		<label for = "id">ID</label>
		<Input type="text" name="id" id="id" />
		<label for = "passwd">Passwd</label>
		<Input type="password" name="passwd" id="passwd" />
		<Input type="submit" value="login" />
	
	</fieldset>
	</form>
	

</body>
</html>