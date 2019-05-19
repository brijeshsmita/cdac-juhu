<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.cdac.web.model.Person"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jsp Implicit/Predefined Object</title>
</head>
<body bgcolor="olive" style=color:white>
<h1>Jsp Implicit/Predefined Object</h1>
<hr>
Request ContextPath : <%=request.getContextPath() %>
<hr>
Response ContentType : <%=response.getContentType() %>
<hr>
Session Id : <%=session.getId() %>
<hr>
ServletConfig Servlet Name: <%=config.getServletName()%>
<hr>
ServletContext : <%=(Person)application.getAttribute("contextName")%>

<hr>
ServletConfig Init Params: Developer :
 <%=(String)session.getAttribute("dev")%><br>
Date of Development : <%=(String)session.getAttribute("date")%>
<hr>
ServletContext ContextPath: <%=application.getContextPath()%>
<hr>
ServletContext Project Lead: <%=application.getInitParameter("Lead")%>
<hr>
ServletContext Project Commencement Date: 
	<%=application.getInitParameter("ProjectDate")%>
<hr>
pageContext getServerPort: <%=pageContext.getRequest().getServerPort()%>
<a href="index.jsp">Home Page</a>
<hr>

</body>
</html>





