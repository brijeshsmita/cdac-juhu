<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="springForm" 
uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:'cyan';font-family:'Comic Sans MS'"><!-- inline styling/css -->
		<hr>
		<h2 style="color:red">${msg}</h2>
<hr>
		<!-- Spring form custom tag -->
		<springForm:form action="checkLogin" method="post"
		modelAttribute="user">
			<table style="border: 2"><!-- attribute="value" -->
				<tr><th colspan="2">User Login</th></tr>
				<tr>
					<td>Username:</td>
					<!-- path attribute will bind username property with input text -->
					<td><springForm:input type="text" path="username" required="required"/></td><!-- accept username for user -->
				</tr>
				<tr>
					<td>Password:</td>
					<td><springForm:input type="password" path="password" required="required"/></td><!-- accept password for user -->
				</tr>
				<tr>			
					<td><input type="submit" value="Login"/></td><!-- submit the accepted value to the web app -->
					<td><input type="reset" value="Cancel"/></td><!-- clear the entered value -->
				</tr>
				<tr>
					<td><a href="register.html"><img src="images/Koala.jpg" width="150" height="100" alt="Image of Koala"/></a></td>
					<!-- <td><a href="register.html">New User?</a></td> -->
				</tr>
			</table><!-- end of table -->
		</springForm:form><!-- end of form -->
	</body>
</html>