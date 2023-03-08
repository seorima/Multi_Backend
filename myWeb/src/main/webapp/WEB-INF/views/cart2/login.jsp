<%@ page contentType="text/html; charset=UTF-8" %>

<%

/*
	로그인 하지 않은 사용자만 접근할 수있다.
	로그인 한 사용자의 기본 화면은 selproduct
	
*/

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
