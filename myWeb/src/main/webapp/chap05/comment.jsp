<%@ page contentType="text/html; charset=UTF-8" %>
<%-- JSP 주석입니다. 브라우저에서 보이지 않아요! --%>

<!-- HTML 주석입니다. 브라우저에서 보여요! -->

<%

//자바 한 줄 짜리 주석입니다 브라우저에서 보일까요?
		/*
		자바여러줄 주석입니다. 브라우저에서 보일까요?
				
				
		*/
		
		int num1 = 10, num2 = 20;
		int result = num1 * num2;

%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		//한 줄 짜리 자바 스크립트 주석이빈다. 브라우저에서 보일까요?
			/*
				여러 줄 자바스크립트 주석입니다. 브라우저에서 보일까요?
			*/
			
			alert('알림 창을 열었습니다.');
	</script>
	<style>
	/*
		스타일 주석입니다. 브라우저에서 보일까요?
	*/
	
	#target{
		border: 2px solid gray;
		paddint: 20px;
	}
	
	</style>
	
	
	
</head>

<body>

	<div id ="targer">
		<h2>JSP 주석 예제</h2>
		<hr />
		<h3>계산 결과</h3>
	
	</div>
	

</body>
</html>