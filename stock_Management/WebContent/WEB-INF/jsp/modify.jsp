<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Modify Product Page</h1>
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
<tr><th>Id</th> <th>Product Name</th>  <th>Company Name</th> <th>Category</th>  <th>Quantity</th> <th>Price per Unit</th> <th>Update</th> <th>delete product</th></tr>
<c:forEach var="list" items="${list}">
<tr><td>${list.getPid() }</td> <td>${list.getpName() }</td> <td>${list.getcName() }</td> <td>${list.getCategory() }</td> <td>${list.getQuantity() }</td> <td>${list.getPrice() }</td><td><a href="update?id=+${list.getPid()}+" >update</a></td><td><a href="delete?id=+${list.getPid()}+" >delete</a></td></tr>

</c:forEach>
</table>
</div>
</body>
</html>