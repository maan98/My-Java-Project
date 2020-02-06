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
<h1>Response Page</h1>
</div>
<div align="right">
<form action="search" method="post">
<input type="search" name="search">
<input type="submit" value="search">
</form>
</div>
<div align="right" style="color: green">${success }</div>
<div align="right" style="color: red">${failed }</div>
<a href="addpro">add product</a>
<a href="modyproduct">Modify Product</a>
<a href="home">home page</a>
<a href="logout">logout</a>
<hr>
</body>
</html>