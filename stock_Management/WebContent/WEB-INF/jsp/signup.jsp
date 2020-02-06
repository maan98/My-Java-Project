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
<h1>Welcome to the sign up page</h1>
</div>
<h4>${success }</h4>
<a href="link2">login</a>
<hr><br><br>
<div align="center">
<fieldset>
<style>
fieldset{
width: 350px;
height: 185px;
}
</style>
<form action="signup" method="post">
<pre>
Name:      <input type="text" name="name"><br>
Contact:   <input type="tel" name="contact"><br>
User Name: <input type="text" name="userName"><br>
Password:  <input type="password" name="password"><br>
           <input type="submit" value="sign up">
</pre>
</form>
</fieldset>
</div>
</body>
</html>