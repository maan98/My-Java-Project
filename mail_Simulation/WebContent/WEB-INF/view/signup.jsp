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
<h1 style="color: blue">Welcome to the sign up page</h1>
</div>
<div style="color: red;">
<h4>${error }</h4>
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
<form action="signup" method="post">
<pre>
  User Name       :<input type="text" name="userName"><br>
    Email         :<input type="email" name="email"><br>
Security Question :<input value="What is Your Pet Name" disabled="disabled"><br>
 Security Answer  :<input type="text" name="seqanswer"><br>
  Password        :<input type="password" name="password"><br>
                 <input type="submit" value="sign up"><br>
                 <a href="fpass">forgot password</a>
</pre>
</form>
</fieldset>
</div>
</body>
</html>