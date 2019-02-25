<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="addProduct">
<table>

<tr>
<td>Product Id:</td>
<td><input type="text" name="productId"/></td>
</tr>
<tr>
<td>Product Name:</td>
<td><input type="text" name="productName"/></td>
</tr>
<tr>
<td>Product Category:</td>
<td><input type="text" name="productCategory"/></td>
</tr>
<tr>
<td>Product Description:</td>
<td><input type="text" name="productDescription"/></td>
</tr>
<tr>
<td>Product Price:</td>
<td><input type="text" name="productPrice"/></td>
</tr>
<tr>
<td>Product Image:</td>
<td><input type="file" name="image"/></td>
</tr>

</table>

</form>

${status}
</body>
</html>