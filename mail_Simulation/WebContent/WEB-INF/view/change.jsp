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
<h1 style="color: blue">Change Password</h1>
</div>
<div align="right">
||<a href="inbox">inbox</a>||
<a href="sent">sent</a>||
<a href="draft">draft</a>||
<a href="compose">compose</a>||
<a href="change">change password</a>||
<a href="deleteMail">Deleted mail</a>||
<a href="logout">log out</a>||
</div>
<hr>
<div style="color: red;">
<h4>${error }</h4>
</div>
<div align="center">
<fieldset>
<style>
fieldset{
width: 350px;
}
</style>
<form action="chang" method="post">
<pre>
   Password       :<input type="password" name="password"><br>
 Confirm Password :<input type="password" name="cpassword"><br>
                   <input type="submit" value="submit">
        </pre>
</form>
</fieldset>
</div> 
</body>
</html>