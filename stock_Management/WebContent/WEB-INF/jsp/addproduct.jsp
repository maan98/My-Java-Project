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
<h1>Add Product Page</h1>
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
<div align="right">${failed}</div><br>
<hr>
<div align="center">
<h1>Enter Product Details</h1>
<fieldset>
<style>
fieldset{
width: 350px;
height: 270px;
}
</style>

<form action="addproduct" method="post">
<pre>
Product Name: <input type="text" name="pName"><br>
Category:     <input type="text" name="category"><br>
Company:      <input type="text" name="cName"><br>
Quantity:     <input type="number" name="quantity"><br>
Price:        <input type="number" name="price"><br>
<input type="submit" value="submit">
</pre>
</form>
</fieldset>
</div>
</body>
</html>