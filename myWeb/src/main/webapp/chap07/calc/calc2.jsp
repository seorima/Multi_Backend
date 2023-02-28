<%@ page contentType="text/html; charset=UTF-8"
		 import="chap07.*"
%>



<jsp:useBean id="calcBean" class="chap07.CalcBean" scope="page" />
<jsp:setProperty name="calcBean" property="*" /> <%-- 파라미터를 읽으면 그건 문자열임 근데 setproperty사용해서 필드 초기화하면 기본 자료형에 한해서 자동 형변환된대요 int임에도. --%>




<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8" />
	<title>calc2.jsp</title>
</head>
<body>

	<h2>JSP 프로그램 구현 유형-2</h2>
	<hr />
	
	<form method="POST">
	<fieldset>
		<legend>간단 계산기</legend>
		
		<input type="number" name="num1" value="0" />
		<select name="operator">
			<option selected>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</select>
		<input type="number" name="num2" value="0" />
		
		<input type="submit" value="계산" />
		<input type="reset" value="초기화" />
	</fieldset>
	</form>
	
	<hr />
	<h4>계산결과: <%= calcBean.calculate() %></h4> <%-- 여기 이거 어떻게 바뀜요 못봤어요. --%>

</body>
</html>







