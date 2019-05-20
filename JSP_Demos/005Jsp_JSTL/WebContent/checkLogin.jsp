<!-- jsp:useBean actions -->
<jsp:useBean id="userObj" 
class="com.cdac.web.model.User" 
scope="session">
</jsp:useBean>
<jsp:setProperty name="userObj" property="*"/>
<%-- <%
out.println(userObj);
%> --%>
<!--setting values for all the properties of User class userObj
	by internally invoking setter method of all the property -->
<h1>Hello , ${userObj.username}
	<%-- <jsp:getProperty name="userObj" property="username"/> --%>
	<br>You password is: ${userObj.password }
	<%-- <jsp:getProperty name="userObj" property="password"/> --%>
	<br>
	and your are a : ${userObj.status }
	<%-- <jsp:getProperty name="userObj" property="status"/> --%>
	 User!
</h1>

	