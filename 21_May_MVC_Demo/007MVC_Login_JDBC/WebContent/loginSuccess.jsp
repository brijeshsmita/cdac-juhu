<%@page session="true" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>loginSuccess.jsp</title>
</head>
<body>
<h1> Login Successful</h1>
<span align="right">Welcome , ${appUser.username }
<br> <a href="logout.jsp">Logout</a>
</span>

<hr>
</body>
</html>