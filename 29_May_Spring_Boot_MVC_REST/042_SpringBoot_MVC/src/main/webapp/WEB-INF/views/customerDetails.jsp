<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
 prefix="springForm"%>
<html>
<head>
<style>
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: SteelBlue;
	color: white;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>
</head>
<body>
	<springForm:form method="post" modelAttribute="customer"
		action="${pageContext.request.contextPath}/addCustomer">
		<table>
			<tr>
				<th colspan="2">Add Customer</th>
			</tr>
			<tr>
				<springForm:hidden path="id" />
				<td><springForm:label path="customerName">Customer Name:</springForm:label></td>
				<td><springForm:input path="customerName" size="30" maxlength="30"></springForm:input></td>
			</tr>
			<tr>

				<td><springForm:label path="email">Email:</springForm:label></td>
				<td><springForm:input path="email" size="30" maxlength="30"></springForm:input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="blue-button" /></td>
			</tr>
		</table>
	</springForm:form>
	</br>
	<h3>Customer List</h3>
	<c:if test="${!empty listOfCustomers}">
		<table class="tg">
			<tr>
				<th width="80">Id</th>
				<th width="120">Customer Name</th>
				<th width="120">Email</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listOfCustomers}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.customerName}</td>
					<td>${customer.email}</td>
					<td><a href="<c:url value='/updateCustomer/${customer.id}' />">Edit</a></td>
					<td><a href="<c:url value='/deleteCustomer/${customer.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>