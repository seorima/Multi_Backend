<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>controller.jsp</title>
</head>

<body>

<h1>forward action example</h1>
<hr />
<h3>이 내용이 사용자에게 보일까요?</h3>

<jsp:forward page="main.jsp" />
	<jsp:param value="email" name="son@daum.net"/>
	<jsp:param value="tel" name="010-1234-5678"/>
</jsp:forward>
	

</body>
</html>