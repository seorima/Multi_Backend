<%@ page contentType="text/html; charset=UTF-8" %>

<%
	request.setAttribute("myName","김연아"); // 로컬변수를 선언해서 사용하는것으 불가능
%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>elResult.jsp</title>
</head>

<body>

	<h2>EL Test</h2>
	<hr/>
	
	${pageScope.pageElTest} <br />
	${requestScope.reqElTest} <br />
	${sessionScope.sesElTest} <br />
	${applicationScope.appElTest} <br />
	${param.userName}<br />
	${paramValues.favorite[0]} / ${paramValues.favorite[1]}<br />
	${cookie.elCookie.name} = ${cookie.elCookie.value}<br />
	<!--  adminID : ${initParam.adminID} / adminPasswd: ${initParam.adminID} ,web-inf view폴더에 web.xml이 없어서 실행이불가임 -->
	사용자 이름: ${myName} <br />
</body>
</html>
