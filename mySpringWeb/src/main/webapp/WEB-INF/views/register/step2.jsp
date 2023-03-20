<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입: Step2</title>
	<style>
	labe {
		display : inline-block;
		width : 120px;
	
	}
	
	</style>
</head>

<body>

	<h1>회원가입</h1>
	<hr />
	
	<h3>회원 정보 입력</h3>
	
	<form action="step3" method="POST">
	<fieldset>
		<legend>회원 정보</legend>
		
		<lable for="email">이메일 :</lable>
		<input type="email" name = "email" id ="email"/> ><br />
		
		<lable for="name">이름 :</lable>
		<input type="text" name = "name" id ="name"/> ><br />
		
		<lable for="password">비밀번호 :</lable>
		<input type="password" name = "password" id ="password"/> ><br />
		
		<lable for="repasswd">비밀번호 확인:</lable>
		<input type="password" name = "repasswd" id =repasswd/> ><br />
		
		<input type="submit" value="회원가입"/> ><br />
		
	</fieldset>
	
	
	</form>

	

</body>
</html>