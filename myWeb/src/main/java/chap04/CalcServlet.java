package chap04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet(description = "계산결과 서블릿", urlPatterns = { "/CalcServlet" })
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		String operator = request.getParameter("operator");
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int result = calc(num1,num2,operator);
		
		
		response.setContentType("text/html; charset = UTF-8");
		// response.getWriter().append("서버응답: ").append(request.getRequestURL());
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset=\"UTF-8\"/> <title>CalcServlet</title></head>");
		out.println("<body><h1>JSP 프로그램 구현 유형-1 </h1><hr /> <h4>" + result + "</h4></body>\r\n");
	}
	
	
public int calc(int num1,int num2, String operator) {
	
	int result = 0;
	
	if(operator.equals("+")){
		result = num1 + num2;
		
	}
	else if(operator.equals("-")){
		result = num1 - num2;
	}
	else if(operator.equals("*")){
		result = num1 * num2;
	}
	else if(operator.equals("/")){
		result = num1 / num2;
	}
	return result;
	
}
	

}
