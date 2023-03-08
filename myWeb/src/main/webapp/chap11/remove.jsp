<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL : remove</title>
</head>

<body>

	<h2>JSTL c: remove</h2>
	<hr />
	
	
	<c:set var = "msg" value = "Hello,World!"/>
	msg(삭제전): ${msg }<br />
	
	
	<hr />
	
	<c:remove var = "msg"/>
	msg(삭제후): ${msg }<br />
	
	
</body>
</html>