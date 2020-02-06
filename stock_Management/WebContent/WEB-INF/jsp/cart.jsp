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
<h1>Product details along with bill</h1>
</div>
<div align="right">
<form action="search" method="post">
<input type="search" name="search">
<input type="submit" value="search">
</form>
</div>
<div align="right">${success }</div>
<div align="right">${failed }</div>
<a href="addpro">add product</a>
<a href="modyproduct">Modify Product</a>
<a href="home">home page</a>
<a href="logout">logout</a>
<hr>
<div align="center">
<table border="1">
<tr><th>Id</th> <th>Product Name</th>  <th>Company Name</th> <th>Category</th>  <th>Quantity</th> <th>Price per Unit</th> <th>total price</th> <th>total price with gst</th></tr>
<c:forEach var="list" items="${dto.getOlist()}">
<tr><td>${dto.getPid() }</td> <td>${dto.getpName() }</td> <td>${dto.getcName() }</td> <td>${dto.getCategory() }</td> <td>${list.getTotalPrice() /dto.getPrice()}</td> <td>${dto.getPrice()}</td>
<td>${list.getTotalPrice()}</td> <td>${list.getTotalPriceWithGST() }</td>
</tr>
</c:forEach>
</table>
</body>
</html>