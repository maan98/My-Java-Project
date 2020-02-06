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
<h1 style="color: blue">Welcome to the login page</h1>
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
<a href="link1">sign up</a>
<a href="link2">login</a>
</div>
<hr>
<div align="center">
<fieldset>
<style>
fieldset{
width: 350px;
}
</style>
<form action="login" method="post">
<pre>
Email:     <input type="email" name="email"><br>
Password:  <input type="password" name="password"><br>
           <input type="submit" value="login"><br>
               <a href="fpass">forgot password</a>
</pre>
</form>
</fieldset>
</div>
</body>
</html>