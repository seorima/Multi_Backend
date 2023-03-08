<%@ page contentType="text/html; charset=UTF-8" %>
<%

/*
	로그인 한 사용자만 접근할 수있다.
	로그인 하지 않은 사용자는 로그인화면으로 보낸다.
	장바구니 비우기 기능 추가
	상품 구매 페이지 이동
	
*/

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
	
	<form method="POST">
		<input type="hidden" name="command" value="clearCart"/>
		<input type="submit" value="장바구니 비우기"/>
	</form>
	
	<hr />
	<h5><a href="?"> 상품 구매</a></h5>

</body>
</html>