<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background: #fafafa url(https://jackrugile.com/images/misc/noise-diagonal.png);
	color: #444;
	font: 100%/30px 'Helvetica Neue', helvetica, arial, sans-serif;
	text-shadow: 0 1px 0 #fff;
}

strong {
	font-weight: bold; 
}

em {
	font-style: italic; 
}

table {
	background: #f5f5f5;
	border-collapse: separate;
	box-shadow: inset 0 1px 0 #fff;
	font-size: 12px;
	line-height: 24px;
	margin: 30px auto;
	text-align: left;
	width: 800px;
	text-align: center;
}	

th {
	background: url(https://jackrugile.com/images/misc/noise-diagonal.png), linear-gradient(#777, #444);
	border-left: 1px solid #555;
	border-right: 1px solid #777;
	border-top: 1px solid #555;
	border-bottom: 1px solid #333;
	box-shadow: inset 0 1px 0 #999;
	color: #fff;
  font-weight: bold;
	padding: 10px 15px;
	position: relative;
	text-shadow: 0 1px 0 #000;	
}
td {
	border-right: 1px solid #fff;
	border-left: 1px solid #e8e8e8;
	border-top: 1px solid #fff;
	border-bottom: 1px solid #e8e8e8;
	padding: 10px 15px;
	position: relative;
	transition: all 300ms;
}

td:first-child {
	box-shadow: inset 1px 0 0 #fff;
}	

td:last-child {
	border-right: 1px solid #e8e8e8;
	box-shadow: inset -1px 0 0 #fff;
}	

tr {
	background: url(https://jackrugile.com/images/misc/noise-diagonal.png);	
}

tr:nth-child(odd) td {
	background: #f1f1f1 url(https://jackrugile.com/images/misc/noise-diagonal.png);	
}

</style>
</head>
<body>
<center>
<h2>List Product Page<br>Products Avaialble in database</h2>
<%
Connection conn = null;
ResultSet rs =null;
PreparedStatement ps =null;

try 
{
	Class.forName("oracle.jdbc.OracleDriver");
}
catch (ClassNotFoundException e)
{
	e.printStackTrace();
}
try
{
	int pid;
	conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","cognizant");
	ps=conn.prepareStatement("select * from product_table");
	
	rs = ps.executeQuery();
%>
	<table>
		<tr>
			<th>Product Id</th><th>Product Name</th><th>Company</th><th>Category</th>
		</tr>

<% 
	while(rs.next())
	{
		
		%>
			<!--  url rewriting -->
				<tr>
					<td><a href="displayProduct.jsp?pid=<%=rs.getInt(1)%>" ><%= rs.getInt(1) %></a></td><td><%=rs.getString(2) %></td><td><%=rs.getString(5)%></td><td><%=rs.getString(6) %></td>
				</tr>
			
		
		<%	
	}
	%> 
	</table>
	<% 
		
}
	
catch(SQLException e)
{
	System.out.println(e);
}
finally 
{
	try 
	{
		conn.close();
	} 
	catch (SQLException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


%>
</center>
</body>
</html>