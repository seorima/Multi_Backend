<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인화면</title>
</head>

<body>

	<h2>메인 화면</h2>
	<h5>${auto.name }님의 방문을 환영합니다</h5>
	<hr />
	
	<ol>
		<li><a href="<c:url value='/register/step1'/>">회원가입</a></li>
		<li><a href="<c:url value='/member/login'/>">로그인</a></li>
		<li><a href="<c:url value='/member/changePasswd'/>">비밀번호 변경</a></li>
		<li><a href="<c:url value='/member/findMember'/>">회원 검색</a></li>
		<li><a href="#">전체 회원조회</a></li>
		<li><a href="<c:url value='/member/findMember'/>">로그아웃</a></li>
	
	</ol>


</body>
</html>