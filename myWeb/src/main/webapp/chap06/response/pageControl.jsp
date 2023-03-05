<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>pageControl.jpg</title>
</head>

<body>

	<h1>forward vs redirect</h1>
	<hr>
	
	<form action="forward.jsp" method = "POST">
	
		<fieldset>
			<legend>forward test</legend>
			<label for=username>이름</label>
			<input type="text" name = "username" id = "username"/>
			<input type="submit" value = "전송"/>
			
		</fieldset>
	</form>
	
		<hr>
	
	<form action="redirect.jsp" method = "POST">
	
		<fieldset>
			<legend>redirect test</legend>
			<label for=username>이름</label>
			<input type="text" name = "username" id = "username"/>
			<input type="submit" value = "전송"/>
			
		</fieldset>
	</form>

</body>
</html>