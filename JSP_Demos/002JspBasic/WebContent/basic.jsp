<!-- page directives are used to provide instruction and descrption about the
jsp page at the compilation time -->
<%@page errorPage="error_page.jsp" %>
	<!-- errorPage attribute is used to define exception handler page -->
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Basic JSP</title>
</head>
<%@include file="header.jsp" %>
<a href="logout.jsp">Logout</a>
setting the session time out programatically
<% session.setMaxInactiveInterval(1000); %>
<body bgcolor="tan" style=color:white>
	<h3>
		<%--Scriptlets- used to write java code within jsp page --%>
		<%
			out.println("Hello JSP Scriptlets,Session ID : " + session.getId());
		%>
		<%--Expression- used to print any expression in jsp page(no semi-colan) --%>
		<hr>
		<%="Hello JSP Expression"%>
		<hr>
		<%!int age = 90;
		int num1=10;
		%><!-- JSp Declaration -->
<%
double div=0;
/* try{ */div=10/0;

/* }catch(Exception e){
	out.println(e.getMessage());
	//response.sendRedirect("error_page.jsp");
} */

%><hr>
		<%
			if (age >= 18) {
		%>
		Your are eligible to Vote!
		<%
			} else {
		%>
		Your are Minor!
		<%
			}
		%>
		<hr>
		<!-- JSp Method Declaration -->
		<%!int add(int num1, int num2) {
				return num1 + num2;
		}%>
		Addition of Two Numbers :
		<%=add(10, 20)%>
	</h3>
	<hr>
	<a href="index.jsp">Home Page</a>
	<%-- <%@include file="footer.jsp" %> --%>
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- used to include static file -->
</body>
</html>








