<jsp:useBean id="obj" class="com.project.domain.Employee" 
	scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="obj"/>
<jsp:getProperty name="obj" property="employee"/>

<table border="5">
	<th colspan="2">Employee Details:</th>
	<tr>

		<td>empId :</td>
		<td><jsp:getProperty name="obj" property="empId"/></td>
	</tr>
	<tr>
		<td>ename :</td>
		<td><jsp:getProperty name="obj" property="ename"/></td>
	</tr>
	<tr>
		<td>kinId :</td>
		<td><jsp:getProperty name="obj" property="kinId"/></td>
	</tr>
	<!-- 	int empId, String ename, String kinId,
 String email,
	String phoneNo, String address, String dob, 
	String doj, int deptId,
	int roleId, int projId -->
	<tr>
		<td>email :</td>
		<td><jsp:getProperty name="obj" property="email"/></td>
	</tr>
	<tr>
		<td>phoneNo :</td>
		<td><jsp:getProperty name="obj" property="phoneNo"/></td>
	</tr>
	<tr>
		<td>address</td>
		<td>
			<jsp:getProperty name="obj" property="address"/>
		</td>
	</tr>
	<tr>
		<td>dob :</td>
		<td><jsp:getProperty name="obj" property="dob"/></td>
	</tr>
	<tr>
		<td>doj :</td>
		<td><jsp:getProperty name="obj" property="doj"/></td>
	</tr>
	<tr>
		<td>deptId :</td>
		<td><jsp:getProperty name="obj" property="deptId"/></td>
	</tr>
	
	<tr>
		<td>projId :</td>
		<td><jsp:getProperty name="obj" property="projId"/></td>
	</tr>
	<tr>
		<td>roleId :</td>
		<td><jsp:getProperty name="obj" property="roleId"/></td>
	</tr>
</table>
<br><br><br>
<hr>
	<span style="padding:5px;background-color:black;color:white">
		<%@include file="copyright.jsp"%>
	</span>
<hr>












