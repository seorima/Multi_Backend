<%@ page contentType="text/html; charset=UTF-8" 
		 import = "chap03.*"

%>

<jsp:useBean id = "modelService" class="chap03.ModelService" scope="session"/>

<%
	String modelInfo = "";
	String modelEvalInfo = "";

	if(request.getMethod().equals("POST")){
		String command = request.getParameter("command");
		
		if(command !=null && command.equals("visualize")){
			modelService.visualize();
		}
		else if(command !=null && command.equals("modelInfo")){
			modelInfo = modelService.getModelInfo();
		}
		else if(command !=null && command.equals("modelEvalInfo")){
			modelEvalInfo = modelService.getModelEvalInfo(); 
		}
		
	}
	
%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<style>
	#modelInfo{
		width : 600px;
		height : 150px;
		border: 2px solid gray;
	}
	
	#modelEvalInfo{
		width : 600px;
		height : 300px;
		border: 2px solid gray;
	}
	</style>
	
</head>

<body>

	<h1>Weka Java machine Learning Test</h1>
	
	<form method="POST">
		<input type="hidden" name="command" value = "visualize" />
		<input type="submit" value="시각화 정보 보기"/>
	
	</form>
	
	<hr/>
	
	<form method="POST">
		<input type="hidden" name="command" value = "modelInfo" />
		<input type="submit" value="모델 정보 보기"/>
	
	</form>
	
	<pre id = "modelInfo">
		<%= modelInfo %>
	</pre>
	
	<hr/>
	
	<form method="POST">
		<input type="hidden" name="command" value = "modelInfo" />
		<input type="submit" value="모델 평가 보기"/>
	
	</form>
	
	<pre id = "modelEvalInfo">
		<%= modelEvalInfo %>
	</pre>
	
	
	
	

</body>
</html>