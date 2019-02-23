<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Add Product Page</h2>
<%
        
        Random r = new Random();
        int i=Math.abs(r.nextInt(1000));
        String uname = null;
        HttpSession s = request.getSession();
    	
    	if(s!=null)
    	{
    		uname=s.getAttribute("username").toString();	
    	}
      %>
        <center>
        <br>    
       <h3>Enter The Following Details To Add New Product</h3>
        <form action="addproduct" method="post" enctype="multipart/form-data" name="form1" id="form1">
            <table cellspacing="10">
            <tr>    
            <td>Product ID</td>
            <td><input type="text" size="2" name="pid" readonly value="<%=i %>"></td>
            </tr>
            <tr>    
            <td>Company</td>
            <td><input type="text" name="cname" ></td>
            </tr>
            <tr>    
            <td>Product Name</td>
            <td><input type="text" name="pname"></td>
            </tr>
            <tr>    
            <td>Product Category</td>
            <td> <!--  <input type="text" name="category" id="category"><span id="myspan"></span> -->
            	<select>
            		<option>select</option>
            		<option>Electronics</option>
            		<option>Kitchen</option>
            		<option>Mobile & Computer Accessories</option>
            		<option>Men's Fashion</option>
            		<option>Women's Fashion</option>
            		<option>Kids's Fashion</option>
            		<option>Sports & Fitness</option>
            		<option>Beauty & Health</option>
            		<option>Kindle & E-Books</option>
            	</select>
             </td>
            </tr>
            <tr>
            <tr>    
            <td>Product Description</td>
            <td><textarea rows="5" cols="50" name="pdetails"> </textarea>
            </tr>
            
                
            <td>Price</td>
            <td><input type="text" size="10" name="price"></td>
            </tr>        
            <td>Upload Image</td>
            <td><input type="file" name="file" id="file" ></td>
                
            </table>   <br>
            <input type="submit" value="ADD">
             <input type="reset" value="Reset">
            
            
         </form>   
        </center>
</body>
</html>