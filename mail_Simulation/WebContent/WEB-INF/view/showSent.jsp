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
<h1 style="color: blue">Show Sent</h1>
</div>
<div align="right">
<a href="inbox">inbox</a>
<a href="sent">sent</a>
<a href="draft">draft</a>
<a href="compose">compose</a>
<a href="change">change password</a>
<a href="deleteMail">Deleted mail</a>
<a href="logout">log out</a>
</div>
<hr>
<div align="center">
<table border="1">
<tr><th>To</th><td>${dto.getToId() }</td></tr>
<tr><th>Subject</th><td>${dto.getSubject() }</td></tr>
<tr><th>Message</th><td>${dto.getMessage() }</td></tr>
</table>
</div> 
</body>
</html>