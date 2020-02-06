<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to the Home Page ${ sdto.getUserName() }</h1>
<h4>${m }<br></h4>
<h4>${msg }<br></h4>
<a href="inbox">inbox</a>
<a href="sent">sent</a>
<a href="draft">draft</a>
<a href="compose">compose</a>
<a href="logout">log out</a>
</body>
</html>