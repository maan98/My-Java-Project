<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="right">
<form action="search" method="post">
<input type="search" name="search">
<input type="submit" value="search">
</form>
</div>
<div align="right">${success }</div>
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
height: 300px;
}
</style>

<form action="updateproduct" method="post">
<pre>
           <input type="hidden" name="pid" value="${dto.getPid() }"><br>
Product Name: <input type="text" name="pName" value="${dto.getpName() }"><br>
Category:     <input type="text" name="category" value="${dto.getCategory() }"><br>
Company:      <input type="text" name="cName" value="${dto.getcName() }"><br>
Quantity:     <input type="number" name="quantity" value="${dto.getQuantity() }"><br>
Price:        <input type="number" name="price" value="${dto.getPrice() }"><br>
<input type="submit" value="update">
</pre>
</form>
</fieldset>
</div>
</body>
</html>