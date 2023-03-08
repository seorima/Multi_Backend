<%@ page contentType="text/html; charset=UTF-8" %>

<jsp:useBean id = "bean" class="mvc.twitter.cart.CartBean" scope="session"/>

<%
	if(request.getMethod().equals("POST")){
		request.setCharacterEncoding("UTF-8");
	}

	String command = request.getParameter("command");
	String viewPath = "/WEB-INF/views/cart2/";
	
	if(session.getAttribute("id") == null){
		if(request.getMethod().equals("GET")){
			pageContext.forward(viewPath + "login.jsp");
		}
		else if (request.getMethod().equals("POST")){
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			
			if(bean.checkLogin(id,passwd)){
				session.setAttribute("id",id);
				pageContext.forward(viewPath + "setProduct.jsp");
			}
			else {
				response.sendRedirect("controller.jsp");
			}
		
		}
	}
	else if(command != null && command.equals("logout")){
		session.invalidate();
		response.sendRedirect("controller.jsp");
		
		
	}
	
	else if(command != null && command.equals("addcart")){
		String product = request.getParameter("product");
		bean.addProduct(product); //bean addcart에 추가
		request.setAttribute("script","alert('"+ product + " 상품을 구매했습니다');");  //상품구매는 현재 요청에서만 상품 구매를 한거니까.
		pageContext.forward(viewPath + "setProduct.jsp"); //
	}
	
	else {
		pageContext.forward(viewPath + "setProduct.jsp");
	}

%>
