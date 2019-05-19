<jsp:useBean id="obj" class="com.cdac.web.model.UserDetails" 
	scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="obj"/>
<table border="5">
	<th colspan="2">User Details:</th>
	<tr>
		<td>UserName :</td>
		<td><jsp:getProperty name="obj" property="username"/></td>
	</tr>
	<tr>
		<td>Password :</td>
		<td><jsp:getProperty name="obj" property="password"/></td>
	</tr>
	<tr>
		<td>Name :</td>
		<td><jsp:getProperty name="obj" property="name"/></td>
	</tr>
	<tr>
		<td>Address :</td>
		<td><jsp:getProperty name="obj" property="address"/></td>
	</tr>
	<tr>
		<td>Country :</td>
		<td><jsp:getProperty name="obj" property="country"/></td>
	</tr>
	<tr>
		<td>Zip :</td>
		<td><jsp:getProperty name="obj" property="zip"/></td>
	</tr>
	<tr>
		<td>Email :</td>
		<td><jsp:getProperty name="obj" property="email"/></td>
	</tr>
	<tr>
		<td>Gender :</td>
		<td><jsp:getProperty name="obj" property="gender"/></td>
	</tr>
	<tr>
		<td>Language</td>
		<td>
			<jsp:getProperty name="obj" property="english"/>
			<jsp:getProperty name="obj" property="nonenglish"/>,
		</td>
	</tr>
	<tr>
		<td>Description :</td>
		<td><jsp:getProperty name="obj" property="description"/></td>
	</tr>
</table>
<br><br><br>
<hr>
	<span style="padding:5px;background-color:black;color:white">
		<%@include file="copyright.jsp"%>
	</span>
<hr>












