<%@page isELIgnored="false" %>
<%@ taglib prefix="springForm" 
uri="http://www.springframework.org/tags/form" %>  
<head>
<link rel="stylesheet" type="text/stylesheet"
href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>
<a href="home.html" >Back</a>|<a href="home.html">Login</a>
	<H1>Registration Page</H1>
	<p><b>Use tab keys to move from one input field to the next.</b></p>
	<springForm:form name='registration' 
	action="registration"
	modelAttribute="userRegister">
		<ul type="none">
			<li><label for="username">User Name:</label></li>
			<li><springForm:input type="text" path="username" size="12" /></li>
			
			<li><label for="password">Password:</label></li>
			<li><springForm:input type="password" path="password" size="12" /></li>
			
			<li><label for="name">Name:</label></li>
			<li><springForm:input type="text" path="name" size="50" /></li>
			
			<li><label for="address">Address:</label></li>
			<li><springForm:input type="text" path="address" size="50" /></li>
			
	<li><label for="country">Country:</label></li>
			<li><springForm:select path="country">
					<springForm:option value="Australia" label="Australia"></springForm:option>
					<springForm:option value="Canada" label="Canada"></springForm:option>
					<springForm:option value="India" label="India"></springForm:option>
					<springForm:option value="Russia" label="Russia"></springForm:option>
					<springForm:option value="USA" label="USA"></springForm:option>
				</springForm:select>
			</li> 
					<li><label for="zip">ZIP Code:</label></li>
			<li><springForm:input type="number" path="zip" /></li>
			
			<li><label for="email">Email:</label></li>
			<li><springForm:input type="email" path="email" size="50" /></li>
			
			<li><label for="gender">Gender:</label></li>
			<li><springForm:radiobutton path="gender" value="Male" /><span>Male</span></li>
			<li><springForm:radiobutton path="gender" value="Female" /><span>Female</span></li>
		 	
			<li><label>Language:</label></li>
			<li><springForm:checkbox path="english" value="English"/><span>English</span></li>
			<li><springForm:checkbox path="nonenglish" value="Non English" /><span>Non English</span></li>
			
			<li><label for="description">About:</label></li>
			<li><springForm:textarea path="description" ></springForm:textarea></li>
			
			<li><input type="submit" /></li>
		</ul>
	</springForm:form>
</body>
</html>












