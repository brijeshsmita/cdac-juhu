<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Today Page</title>
</head>
<body bgcolor="cyan">
<h1>Today is : <%out.println(LocalDate.now()); %></h1>
<hr>
<h1>Random Number : <%=Math.random() %></h1>
<hr>
<a href="index.jsp">Home Page</a>
</body>
</html>