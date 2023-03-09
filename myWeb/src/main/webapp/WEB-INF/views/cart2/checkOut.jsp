<%@ page contentType="text/html; charset=UTF-8" 
		 import = "java.util.*"
%>
<%

/*
	로그인 한 사용자만 접근할 수있다.
	로그인 하지 않은 사용자는 로그인화면으로 보낸다.
	장바구니 비우기 기능 추가
	상품 구매 페이지 이동
	
*/
	@SuppressWarnings("unchecked")
	ArrayList<String> productList = (ArrayList<String>)session.getAttribute("productList");
	String result = "<ol>";
	
	if(productList.isEmpty()){
		result = "<h5>선택하신 상품이 없습니다.</h5>";
	}else{
		
		for(String product : productList){
			result +="<li>" + product + "</li>";
		}
		result += "</ol>";
	}
	
	

%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>checkOut.jsp</title>
</head>

<body>

	<h1>장바구니 확인</h1>
	<hr/>
	
		<%= result %>
	
	
	<form method="POST">
		<input type="hidden" name="command" value="clearCart"/>
		<input type="submit" value="장바구니 비우기"/>
	</form>
	
	<hr />
	<h5><a href="controller.jsp"> 상품 구매</a></h5>

</body>
</html>