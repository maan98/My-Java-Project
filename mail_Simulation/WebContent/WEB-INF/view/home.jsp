<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" style="background-color:black">
<h1 style="color: white">Welcome to the Home Page</h1>
</div>
<div align="left">
<h1 style="color: red">Gmail Simulation</h1>
</div>
<div align="right" >
<button style="background-color:red"><h1>${ sdto.getUserName() }</h1> </button>
</div>
<div align="left">
<div style="color: green;">
<h4>${success }</h4>
</div>
<div style="color: red;">
<h4>${error }</h4>
</div>
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
</body>
</html>