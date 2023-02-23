<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style >
		table, td {
			
		}
	
	</style>
</head>

<body>
	<table>
	<%
		for(int i=2;i<10;i++){
%>

<%
	for(int j=1;j<10;j++){
%>

<tr><td><%= (i) + "*" + (j) %></td></tr>



	<%
		}
	%>		
		<%
		}
	%>		
	
	
	
	</table>
	

</body>
</html>