<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>delete</title>
</head>
<body>
<form action="rest/countries/delete" method="post">
		Enter Country Id:<input type="text" 
		name="txtId" 
		pattern="[1-9]{1,3}" required="required"/><br />
		<br />
		<input type="submit" value="Delete Country" />
	</form>
</body>
</html>