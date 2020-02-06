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
<h1 style="color: blue">Forgot Password</h1>
</div>
<div align="right">
<a href="link1">sign up</a>
<a href="link2">login</a>
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
<form action="forgot" method="post">
<pre>
    Email         :<input type="email" name="email"><br>
Security Question :<input value="What is Your Pet Name" disabled="disabled"><br>
Security Answer   :<input type="text" name="seqanswer"><br>
   Password       :<input type="password" name="password"><br>
 Confirm Password :<input type="password" name="cpassword"><br>
                   <input type="submit" value="submit">
        </pre>
</form>
</fieldset>
</div>
</body>
</html>