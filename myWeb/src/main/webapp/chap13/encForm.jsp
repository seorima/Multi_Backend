<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>encForm.jsp</title>
</head>

<body>

	<h2>encoding test form</h2>
	
	<form method="POST" action = "encResult.jsp">
	<fieldset>
		<legend>인코딩 테스트 폼</legend>
		<label for = "kor">한글입력</label>
		<Input type="text" name="kor" id="kor" />
		<Input type="submit" name="kor" id="kor" />
	</fieldset>
	</form>
	

</body>
</html>