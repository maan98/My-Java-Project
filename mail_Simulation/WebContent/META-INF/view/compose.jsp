<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Compose mail</h1>
<form action="comp">
<pre>
from: ${msg }
to:   <input type="text" name="to">
sub:  <input type="text" name="sub">
body: <input type="text" name="body">
     <input type="submit" value="sent">
</pre>
</form>
</body>
</html>