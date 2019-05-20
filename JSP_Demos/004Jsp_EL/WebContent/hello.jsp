
<h2>Hello , ${param.username}</h2>
<hr>
Session Id :
<%--  <%=session.getId() %> --%>
${pageContext.session.id }
<%--If we want to access any JSP implicit object
			in EL expession then we need to use pageContext --%>
<hr>
Servlet Context Path : ${pageContext.request.contextPath }
