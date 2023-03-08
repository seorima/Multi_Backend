<%@ page contentType="text/html; charset=UTF-8" 
       import="mvc.twitter.*, java.util.*"
%>

<%
   if(request.getMethod().equals("POST")) {
      request.setCharacterEncoding("UTF-8");
   }
%>

<jsp:useBean id="twitterDAO" class="mvc.twitter.TwitterDAO" scope="session" />
<jsp:useBean id="twitterDO" class="mvc.twitter.TwitterDO" scope="page" />
<jsp:useBean id="loginDO" class="mvc.twitter.TwitterLoginDO" scope="page" />
<jsp:setProperty name="twitterDO" property="message" />
<jsp:setProperty name="loginDO" property="*" />

<%
   String viewPath = "/WEB-INF/views/twitter2/";
   String command = request.getParameter("command");
   
   if(session.getAttribute("id") == null) {
      if(request.getMethod().equals("GET")) {
         pageContext.forward(viewPath + "twitterLogin.jsp");
      }
      else if(request.getMethod().equals("POST")) {
         TwitterLoginDO tDO = twitterDAO.checkLogin(loginDO);
         
         if(tDO != null) {
            session.setAttribute("id", tDO.getId());
            session.setAttribute("name", tDO.getName());
            
            response.sendRedirect("controller.jsp");
         }
         else {
            pageContext.forward(viewPath + "twitterLogin.jsp");
         }
      }
   }
   else {
      if(command != null && command.equals("logout")) {
         session.invalidate();
         response.sendRedirect("controller.jsp");
      }
      else {
         if(command != null && command.equals("twitterInsert")) {
            twitterDO.setId((String)session.getAttribute("id"));
            twitterDAO.insertTwitter(twitterDO);
         }
         
         session.setAttribute("list", twitterDAO.getAllTwitter());
         pageContext.forward(viewPath + "twitterlist.jsp");
      }
   }
%>