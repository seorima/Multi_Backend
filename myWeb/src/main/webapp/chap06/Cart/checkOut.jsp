<%@ page contentType="text/html; charset=UTF-8"
		import = "java.util.*"
 %>

<%

/*
1.로그인 한 사용자만 이용 할 수 있다.
2. 로그인 하지 않는 사용자의 접근은 로그인 페이지로 리다이렉팅한다.
3. 상품 구매 페이지로의 ㅇ ㅣ동

*/

	ArrayList<String> list = (ArrayList<String>)session.getAttribute("productList");
	String products = "";
	
	if(list == null){
		products = "<h4>구매하신 상품이 없습니다.</h4>";
	}else{
		for(String product : list){
			products += "<h5>" + product + "</h5>";
		}
		session.removeAttribute("productList");
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