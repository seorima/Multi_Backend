<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>전체 회원 조회</title>
	<style>
	table, th, td {
		border: 2px solid gray;
		border-collapse: collapse;
	}
	
	th, td {
		padding: 5px 10px;
	}
	
	td.num {
		text-align: center;
	}
	</style>
</head>

<body>

	<h2>전체 회원 조회</h2>
	<hr />
	
	<table>
		<tr>
			<th>번호</th><th>이메일</th><th>이름</th><th>등록일자</th>
		</tr>
		<c:forEach items="${members}" var="member" varStatus="status">
		<tr>
			<td class="num">${status.count}</td>
			<td>${member.email}</td>
			<td>${member.name}</td>
			<td>${member.registerDateTime.toLocalDate()}</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>











