<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String admin = null;
	HttpSession s = request.getSession();
	
	
	admin=session.getAttribute("username").toString();	
	
	
%>
<h3>Welcome <%=admin %></h3>
<a href="AddProduct.jsp">Add Product</a>
<a href="ListProduct.jsp">List Product</a>
<a href="logout">Logout</a>

</body>
</html>