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
<h1 style="color: blue">Compose mail</h1>
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
<hr>
<div align="center">
<fieldset>
<style>
fieldset{
width: 350px;
}
</style>
<form action="comp">
<pre>
from: <input value="${msg }"><br>
to:   <input type="text" name="to"><br>
sub:  <input type="text" name="sub"><br>
body: <input type="text" name="body"><br>
     <input type="submit" value="sent">
</pre>
</form>
</fieldset>
</div>
</body>
</html>