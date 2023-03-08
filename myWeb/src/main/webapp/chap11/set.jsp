<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL : set</title>
</head>

<body>

	<h2>JSTL c: set</h2>
	<hr />
	
	
	<c:set var = "msg" value = "Hello,World!"/>
	msg: ${msg }<br />
	msg: <%= pageContext.getAttribute("msg") %>
	
	<hr />
	
	<c:set target = "${member}" property="email" value = "changed@nate.com"/> <!-- member객체의 email값을 저렇게 변경 -->
	Member name: ${member.name};<br />
	Member email: ${member.email};<br />
	
<!-- web.xml이... 안되서 지금 오류남 이거 실행안됨. -->
</body>
</html>