<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
	<%
	 if(session.getAttribute("isLoggedIn") != null){
		User user = (User)session.getAttribute("isLoggedIn");
		out.print("<h1>Welcome to your profile " + user.getUsername() + "</h1>"); 
		out.print("<form action=\"SessionRemove\" method=\"POST\">");
		out.print("<input type=\"submit\" value=\"Log out\" />");
		out.print("</form>");
	 }
	 else{
		 out.print("<h1>Error</h1>");
		 response.sendRedirect("index.jsp");
	 }
	%>
</body>
</html>