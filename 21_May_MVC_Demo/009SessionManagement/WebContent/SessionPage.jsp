<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SessionPage</title>
</head>
<body>
<h1>Session Info</h1>

<!-- true means 
if session exists return current session object 
if session does not exists return new session object -->
Session Id : ${pageContext.session.id }<hr>
Session Creation time : 
${pageContext.session.creationTime }<hr>
Setting the session time out programmatically
<%session.setMaxInactiveInterval(10); %><hr> in Seconds
session Time out : 
${pageContext.session.maxInactiveInterval }
<a href="MySessionServlet">Session Servlet</a>
</body>
</html>

<!-- 
scriptlets
expression
declaration
directives
comments
actions tags

how to use implicit object of JSP in EL
by accessing through pageContext.object

JSP implicit Object
request
response
out
session
config
application
page
pageContext
exception

EL implicit Object
pageScope
requestScope
sessionScope
applicationScope

param
paramValue
initParam
header headerValue
cookie

pageContext -->