<%@ page contentType="text/html; charset=UTF-8" 
		 import = "java.util.*, mvc.twitter.*"
%>

<%
	if(request.getMethod().equals("POST")){
		request.setCharacterEncoding("UTF-8");
	
}
%>

<jsp:useBean id = "twitterDAO" class = "mvc.twitter.TwitterDAO" scope = "session"/>
<jsp:useBean id = "twitterDO" class = "mvc.twitter.TwitterDO" />
<jsp:setProperty name ="twitterDO" property="message"/>

<%

	if(request.getMethod().equals("POST")){
		
		twitterDO.setId((String)session.getAttribute("id"));
		twitterDAO.insertTwitter(twitterDO);
		
		
	}

	ArrayList<TwitterDO> list = twitterDAO.getAllTwitter();
	String result = " ";
	
	for(TwitterDO tDO : list){
		result +="<li>" + tDO.getId() +  " ::: " + tDO.getMessage() + " ::: " + tDO.getDate() + "</li>";
	}
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>twitterList.jsp</title>
</head>

<body>

	<h2>My Simple Twitter!!</h2>
	<hr/>
	
	<form method = "POST">
		<fieldset>
			<label><%= session.getAttribute("id") %>@ <%= session.getAttribute("name") %></label> <!-- 세션 -->
			<input type="text" name="message" size="50"/>
			<input type="submit" value="등록"/>
		
		</fieldset>
	</form>
	<hr/>
	
	<h3>트위터 리스트</h3>
	<ul>
		<%= result %>
	
	</ul>
</body>
</html>