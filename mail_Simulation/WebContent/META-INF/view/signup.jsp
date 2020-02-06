<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Sign Up Page</h1>
<h4>${m }</h4><br>
<form action="signup" method="post">
<pre>
User Name: <input type="text" name="userName"><br>
Email:     <input type="email" name="email"><br>
Password:  <input type="password" name="password"><br>
           <input type="submit" value="sign up">
</pre>
</form>
</body>
</html>