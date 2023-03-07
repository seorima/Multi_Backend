<%@ page contentType="text/html; charset=UTF-8" %>

<%
	pageContext.setAttribute("pageElTest","pageContext storage value!");
	request.setAttribute("reqElTest", "request storage value!"); // eltest.jsp대한 응답이나오면 request는 소멸이요.
	session.setAttribute("sesElTest", "request storage value!");
	application.setAttribute("appElTest", "request storage value!");
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>elTest.jsp</title>
	<script>
		document.cookie = 'elCookie=EL_CookieTest';
	</script>
	
</head>

<body>

	<h2>EL Test</h2>
	<hr/>
		
	<form method="POST" action = "elResult.jsp">
		<label for = "useName">이름</label>
		<input type = "text" name = "useName" id = "userName"/><br />
	
	
	[관심분야]
      <label for="favorite1">정치</label>
      <input type="checkbox" name="favorite" id="favorite1" value="정치" />
      <label for="favorite2">경제</label>
      <input type="checkbox" name="favorite" id="favorite2" value="경제" />
      <label for="favorite3">사회</label>
      <input type="checkbox" name="favorite" id="favorite3" value="사회" />
      <label for="favorite4">문화</label>
      <input type="checkbox" name="favorite" id="favorite4" value="문화" />
      
      <input type = "submit" value = "전송">
	
	</form>
		
	

</body>
</html>