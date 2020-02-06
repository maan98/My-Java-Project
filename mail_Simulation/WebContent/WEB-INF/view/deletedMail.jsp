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
<h1 style="color: blue">Deleted Mail</h1>
<div align="right">
||<a href="inbox">inbox</a>||
<a href="sent">sent</a>||
<a href="draft">draft</a>||
<a href="compose">compose</a>||
<a href="change">change password</a>||
<a href="deleteMail">Deleted mail</a>||
<a href="logout">log out</a>||
</div>
</div>
<div style="color: green;">
<h4>${success }</h4>
</div>
<div style="color: red;">
<h4>${error }</h4>
</div>
<hr>
<div align="center">
<table border="1">
<tr><th>Message</th><th>delete</th></tr>
<c:forEach var="dto" items="${list}">
<tr><td>${dto.getMessage() }</td><td><a href="perdelete?id=+${dto.getId() }+">delete</a></td></tr>
</c:forEach>
</table>
</div>
</body>
</html>