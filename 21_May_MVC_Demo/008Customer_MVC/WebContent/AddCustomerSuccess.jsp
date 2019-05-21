<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddCustomerSuccess.jsp</title>
</head>
<body>
	<h1>Customer Added Successfully</h1>
	<hr>
	<a href="index.jsp">Go to Customer Home</a>
	<hr>
	<h3>
		Customer First Name    : ${customer.firstName }<br> 
		Customer Last  Name    : ${customer.lastName }<br> 
		Customer Mobile Number : ${customer.mobileNo }<br> 
		Customer Email Id      : ${customer.email }<br>
	</h3>
</body>
</html>