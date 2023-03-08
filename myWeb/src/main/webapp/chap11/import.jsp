<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL: import</title>
</head>

<body>

<h2>JSTL c:import</h2>
	<hr />
	
	<c:import url="set.jsp" var= "resultSet" />
	<c:out value = "${resultSet}" escapeXml = "false"/>
	<hr />
	
	<h3>다음은 chap10/el/productList.jsp 를 import 한 결과입니다.</h3>
	<hr />
	
	<c:import url="/chap10/el/productList.jsp" var= "resultProductList" />
	<c:out value = "${resultProductList}" escapeXml = "false"/>
	<hr />
	
</body>
</html>