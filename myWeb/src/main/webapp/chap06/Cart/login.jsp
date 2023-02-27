<%@ page contentType="text/html; charset=UTF-8" %>
<%

	final String ID = "longlee";
	final String PASSWD = "6789";
	boolean isLogin = false;

	if(request.getMethod().equals("POST")){
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		if(id != null && id.equals(ID) && passwd != null && passwd.equals(PASSWD)){
			session.setAttribute("userId",id);
			isLogin = true;
			response.sendRedirect("selProduct.jsp"); //if
		}		
	}
	
		
	
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login.jsp</title>
</head>

<body>

	<h1>로그인</h1>
	<hr />
	
	<form method="POST">
	
	<fieldset>
		<label for = "id">ID</label>
		<Input type="text" name="id" id="id" />
		<label for = "passwd">Passwd</label>
		<Input type="password" name="passwd" id="passwd" />
		<Input type="submit" value="login" />
	
	</fieldset>
	</form>

</body>
</html>
