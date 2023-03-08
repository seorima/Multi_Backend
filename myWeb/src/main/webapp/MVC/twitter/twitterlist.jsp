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

	if(request.getMethod().equals("POST")){ //로그아웃요청에대한 처리부터 실행.
		
		twitterDO.setId((String)session.getAttribute("id"));
		twitterDAO.insertTwitter(twitterDO);
		
		
	}


	String command = request.getParameter("command");
	
	if(command !=null && command.equals("logout")){
		session.invalidate(); //세션을 제거하고 록인 페이지로 ㄱㄱ
		response.sendRedirect("twitterLogin.jsp");
	}else{
		
		String result = " "; //로그인하고 사용자들이 쓴 트윗들 ㅇㅇ 보는거 getallTwitter함수
		ArrayList<TwitterDO> list = twitterDAO.getAllTwitter();
		
		for(TwitterDO tDO : list){
			result +="<li>" + tDO.getId() +  " ::: " + tDO.getMessage() + " ::: " + tDO.getCreateDate() + "</li>";
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
			<input type="hidden" name="command" value = "logout"/>
			<input type="submit" value="등록"/>
		
		</fieldset>
	</form>
	<hr/>
	
	<h3>트위터 리스트</h3>
	<ul>
		<%= result %>
	
	</ul>
	
	<hr/>
	<form method = "POST">
		<input type="hidden" name="command" value = "logout"/>  <!-- hidden 안보임 하지만 요청에서는 파라미터에 탑재  -->
		<input type="submit" value="로그아웃"/>
	
	</form>
	
	
</body>
</html>

<%
	}
%>