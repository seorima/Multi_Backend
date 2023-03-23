<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>설문 응답 결과</title>
</head>

<body>

	<h2>설문 응답 결과</h2>
	<hr />
	<h5></h5>
	<h5>### 응답 내용 ###</h5>
	<ul>
	<c:forEach var ="response" items="${ansData.responses}" varStatus = "status">
	<li>${status.count}번 문항: ${response}</li>
	</c:forEach>
	
	</ul>
	
	
	<h5>### 응답자 정보 ###</h5>
	<h4>응답자 위치: ${ansData.res.location}</h4>
	<h4>응답자 나이: ${ansData.res.age}</h4>

</body>
</html>