<%@ pagecontentType="text/html; charset=UTF-8"
 %>

<%
	int result = 0;

if(request.getMethod().equals("POST")){
	int num1 = Integer.parseInt(request.getParameter("num1"));
	String operator = request.getParameter("operator");
	int num2 = Integer.parseInt(request.getParameter("num2"));
	
	
	if(operator.equals("+")){
		result = num1 + num2;
		
	}
	else if(operator.equals("-")){
		result = num1 - num2;
	}
	else if(operator.equals("*")){
		result = num1 * num2;
	}
	else if(operator.equals("/")){
		result = num1 / num2;
	}
}

%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8"/> 
<title>calc1.jsp</title> 
</head>
<body>

	<h1>JSP 프로그램 구현 유형-1 </h1>
	<hr />
	
	<form method="GET">
	<fieldset>
		<legend>간단 계산기</legend>
		
		<input type ="number" name="num1" value = "0"/>
		<select name = "operator">
			<option>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</select>
		<input type ="number" name="num2" value = "0"/>
		
		<input type ="submit" value = "계산"/>
		<input type ="reset" value = "초기화"/>
	</fieldset>
	</form>
	
	<hr />
	<h4>계산 결과: <%= result %></h4>
</body>
</html>