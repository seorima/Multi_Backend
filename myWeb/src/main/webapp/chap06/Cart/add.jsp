<%@ page contentType="text/html; charset=UTF-8" 
		import = "java.util.*"

%>
		

<%
	if(request.getMethod().equals("POST")){
		request.setCharacterEncoding("UTF-8");
	

	String product = request.getParameter("product");
	
	if(session.getAttribute("productList") == null){
		session.setAttribute("productList",new ArrayList<String>());		//Arraylist가 장바구니인데 그걸 productlist로 저장
	}
	
	ArrayList<String> list = (ArrayList<String>)session.getAttribute("productList");
	list.add(product); //선택한 상품을 장바구니에 넣어줌
	
	
	
%>

	<script>
		alert("<%= product %> 상품을 구매했습니다.");
		history.back();
	</script>


<%
	}
%>
