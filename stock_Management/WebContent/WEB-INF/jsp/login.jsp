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
<h1>Welcome to the login page</h1>
</div>
<div style="color: green">${success }</div>
<div style="color: red">${failed }</div>
<a href="link1">sign up</a>
<hr><br><br>
<div align="center">
<fieldset>
<style>
fieldset{
width: 350px;
height: 125px;
}
</style>

<form action="login" method="post" >
<pre>
User Name: <input type="text" name="userName"><br>
Password:  <input type="password" name="password"><br>
           <input type="submit" value="login">
</pre>
</form>
</fieldset>
</div>
</body>
</html>