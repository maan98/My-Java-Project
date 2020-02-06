<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Add to Cart Page</h1>
</div>
<div align="right">
<form action="search" method="post">
<input type="search" name="search">
<input type="submit" value="search">
</form>
</div>
<a href="addpro">add product</a>
<a href="modyproduct">Modify Product</a>
<a href="logout">logout</a>
<hr>
<div align="center">
<table border="1">
<tr><th>Id</th> <th>Product Name</th>  <th>Company Name</th> <th>Category</th>  <th>Quantity to add</th> <th>Price per Unit</th> <th>add</th></tr>
<form action="addcart" method="post">
<tr><td><input type="text" name="pid" value="${dto.getPid() }" ></td> <td><input type="text" name="pName" value="${dto.getpName() }"></td> <td><input type="text" name="cName" value="${dto.getcName() }"></td> <td><input type="text" name="category" value="${dto.getCategory() }"></td> <td><input type="number" name="quantity" ></td> <td><input type="text" name="price" value="${dto.getPrice() }"></td><td><input type="submit" value="add"></td></tr>
</form>
</table>
</div>
</body>
</html>