<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>post</title>
</head>
<body>
	<form action="rest/countries/edit" method="put">

		Enter Country Id:<input type="text" 
		name="txtId" 
		pattern="[1-9]{1,3}" required="required" placeholder="Enter Country Id in 1-3 digits"/><br />
		<br /> Enter Country Name:<input type="text" 
		name="txtName" pattern="[A_Za-Z]+" 
		required="required" placeholder="Enter Country Name in Only characters"/><br /> <br />
		Enter Country Population:<input type="text" 
		name="txtPopulation" pattern="[1-9]{1}[0-9]{4,}" 
		required="required" placeholder="Enter Country Population in 4-10 digits cannot start with 0"/><br /> <br />
		<input type="submit" value="Update Country" />
	</form>
</body>
</html>