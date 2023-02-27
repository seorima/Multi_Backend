<%@ page contentType="text/html; charset=UTF-8"
		import = "java.util.*"
 %>

<%
	ArrayList<String> list = (ArrayList<String>)session.getAttribute("productList");
	String products = "";
	
	if(list == null){
		products = "<h4>구매하신 상품이 없습니다.</h4>";
	}else{
		for(String product : list){
			products += "<h5>" + product + "</h5>";
		}
		session.removeAttribute("proeuctList");
	}

%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>checkOut.jsp</title>
</head>

<body>

	<h1>상품 구매</h1>
	<hr/>
	<%= products %>

</body>
</html>