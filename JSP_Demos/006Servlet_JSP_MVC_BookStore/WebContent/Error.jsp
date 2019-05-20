<%@ page
    isErrorPage="true"    
    %> <!-- inoder to make the error handler jsp page 
    we use isErrorPage attribute of page directive as true -->
<!DOCTYPE html ><html><head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>error_page.jsp</title>
</head>
<body style="background-color:cyan;color:red">
	<h2>Server Error! Inconvenience Regretted</h2>
<h4><%=exception.getMessage() %></h4>
<!-- exception implicit object is avilable only when isErrorPage attribute
of page directive is marked true -->
<hr>
<a href="index.jsp">Home Page</a>
<hr>
<img src="error.jpg" alt="errorPage">
</body>
</html>