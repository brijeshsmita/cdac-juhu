<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add New Customer</h1>
	<form action="AddCustomerServlet">
		<table border="1" cellpadding="5">
			<tr>
				<th>Customer Id:</th>
				<td><input type="hidden" name="customerId" /></td>
				<!-- input type name must match 
				to Customer instance variable -->
			</tr>
			<tr>
				<th>First Name:</th>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<th>Mobile Number:</th>
				<td><input type="text" name="mobileNo" /></td>
			</tr>
			<tr>
				<th>Email Id:</th>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Add Customer" /></td>
			</tr>
		</table>
	</form>
</body>
</html>