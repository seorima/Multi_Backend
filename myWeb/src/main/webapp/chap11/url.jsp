<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL : url</title>
</head>

<body>

<h2>JSTL c:import</h2>
	<hr />
	
	<c:url value="/chap11/choose.jsp" var = "target"> <!-- /chap11/choose.jsp?sel=a -->
		<c:param name = "sel">a</c:param>
	</c:url>
	
	단순 출력 : ${target}<br />
	링크 연동: <a href = "${target}">choose.jsp 이동</a>
	<hr />
	
	<c:url value="choose.jsp" context="/Yangseolim_web" var = "target"> <!-- Yangseolim_web/choose.jsp?sel=b -->
		<c:param name="sel" value="b" />
	</c:url>
	단순 출력 : ${target}<br />
	링크 연동: <a href = "${target}">choose.jsp 이동</a>

</body>
</html>