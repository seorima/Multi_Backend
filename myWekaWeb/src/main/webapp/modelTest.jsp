<%@ page contentType="text/html; charset=UTF-8" 
		 import = "chap03.*"

%>

<jsp:useBean id = "modelService" class="chap03.ModelService" scope="session"/>
<jsp:useBean id = "modelConfig" class="chap03.ModelConfig" />
<jsp:setProperty name = "modelConfig" property="*"/>

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
		else if(command !=null && command.equals("modelConfig")){
			modelService.configModel(modelConfig);
			
			if(modelConfig.getModelName().equals("LinearRegression")){
				session.setAttribute("LinearRegression","checked");
				session.setAttribute("leaseMedSq","");
			}
			else{
				session.setAttribute("LinearRegression","");
				session.setAttribute("leaseMedSq","checked");
			}
			if(!modelConfig.isApplyFilter()) {
				session.setAttribute("af_false", "checked");
				session.setAttribute("af_true", "");
			}
			else {
				session.setAttribute("af_false", "");
				session.setAttribute("af_true", "checked");
			}
			
			if(!modelConfig.isEraseOutlier()) {
				session.setAttribute("eo_false", "checked");
				session.setAttribute("eo_true", "");
			}
			else {
				session.setAttribute("eo_false", "");
				session.setAttribute("eo_true", "checked");
			}
			
			
		}
		
	}
	
	if(session.getAttribute("LinearRegression")==null){
		session.setAttribute("LinearRegression","checked");
		session.setAttribute("leaseMedSq","");
		session.setAttribute("af_false","checked");
		session.setAttribute("af_true","");
		session.setAttribute("eo_false","checked");
		session.setAttribute("eo_true","");
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
		height : 400px;
		border: 2px solid gray;
	}
	
	
	</style>
	
</head>

<body>

	<h1>Weka Java machine Learning Test</h1>
	
	<h3>모델 선택 및 설정</h3>
	
	<fieldset>
	<form method="POST">
		
		[모델 선택]<br/>
		<label for="LinearRegression">LinearRegression</label>
		<input type="radio" name="modelName" id="LinearRegression" ${LinearRegression} value = "LinearRegression" />&nbsp;&nbsp;&nbsp;&nbsp;
		<label for="leaseMedSq">leaseMedSq</label>
		<input type="radio" name="modelName" id="leaseMedSq"  ${leaseMedSq}value = "leaseMedSq" /><br/><br/>
		
		[필터 적용 선택]<br/>
		<label for="af_false">미적용</label>
		<input type="radio" name="applyFilter" id="af_false" ${af_false} value = "false" />&nbsp;&nbsp;&nbsp;&nbsp;
		<label for="af_true">적용</label>
		<input type="radio" name="applyFilter" id="af_true" ${af_true} value = "true" /><br/><br/>
		
		[이상값 제거 선택]<br/>
		<label for="eo_false">미적용</label>
		<input type="radio" name="eraseOutlier" id="eo_false" ${eo_false} value = "false" />&nbsp;&nbsp;&nbsp;&nbsp;
		<label for="eo_true">적용</label>
		<input type="radio" name="eraseOutlier" id="eo_true" ${eo_true} value = "true" /><br/><br/>
	
		<input type="hidden" name="command" value = "modelConfig" />
		<input type="submit" value="모델 설정"/>
	
	</form>
	
	</fieldset>
	
	
	<h3>데이터셋 분포도 조사 결과</h3>
	
	<form method="POST">
		<input type="hidden" name="command" value = "visualize" />
		<input type="submit" value="시각화 정보 보기"/>
	
	</form>
	
	<hr/>
	
	<h3>모델 정보 및 평가 정보 조회</h3>
	
	<form method="POST">
		<input type="hidden" name="command" value="modelInfo" />
		<input type="submit" value="정보 보기" />
	</form>
	
	<pre id="modelInfo">
		<%= modelInfo %>
	</pre>
	
	
	
	

</body>
</html>