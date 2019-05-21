<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CustomerList</title>
</head>
<body>
	<h1>List of Customer</h1>
	<hr>
	<a href="AddCustomerPage.jsp">Add New Customer</a> |
	<a href="index.jsp">Home Page</a>
	<hr>
	<!-- print the customerList -->
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Mobile Number</th>
			<th>Email Id</th>
		</tr>
		<c:set var="customerList" 
		value="${sessionScope.customerList }"></c:set>
		<c:forEach items="${customerList}" var="cust">
		<tr>
			<td>${cust.firstName }</td>
			<td>${cust.lastName }</td>
			<td>${cust.mobileNo }</td>
			<td>${cust.email }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>