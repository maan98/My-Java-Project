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
</div>
<div align="right">
||<a href="inbox">inbox</a>
<a href="sent">sent</a>||
<a href="draft">draft</a>||
<a href="compose">compose</a>||
<a href="change">change password</a>||
<a href="deleteMail">Deleted mail</a>||
<a href="logout">log out</a>||
</div>
<hr>
<div align="center">
<fieldset>
<style>
fieldset{
width: 350px;
}
</style>
<form action="compMail">
<pre>
to:   <input name="to" value="${dto.getToId() }"><br>
sub:  <input name="sub" value="${dto.getSubject() }"><br>
body: <input name="body" value="${dto.getMessage() }"><br>
     <input type="submit" value="sent">
</pre>
</form>
</fieldset>
</div>
</body>
</html>