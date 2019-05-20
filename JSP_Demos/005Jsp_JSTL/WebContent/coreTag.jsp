<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page errorPage="error_page.jsp"%>
<h1>JSTL core Tag</h1>
<hr>
<a href="<c:url value='/index.html'/>">Go Home</a>
<hr>

<c:set var="n1" value="19"></c:set>
n1 :
<c:out value="${n1}"></c:out>
<c:if test="${n1<18}">
	<c:out value="Error :Number cannot be less than 18"></c:out>
</c:if>
<c:if test="${n1>18}">
	<c:out value="All Ok :Number is greter than 18"></c:out>
</c:if>
<hr>
<c:set var="n2" value="0"></c:set>
<c:catch>
${n1/n2 }
</c:catch>
<hr>
<c:set var="salary" scope="session" value="${2000}"></c:set>
<!-- if if  if else  -->
<c:choose>
	<c:when test="${salary <=10000}">
      Salary is very low to survive.
    </c:when>
	<c:when test="${salary > 10000}">
       Salary is very good.
    </c:when>
	<c:otherwise>
    	No comment sir...
    </c:otherwise>
</c:choose>
<hr>
<c:forTokens
	items="omprakashpandey@synergetics-india.com;rebeccajohn@synergetics-india.com;ChandrashekharDeshpande@synergetics-india.com"
	delims=";" var="email">
	<c:out value="${email }"></c:out>
	<br>
</c:forTokens>
<hr>
forEach :
<c:forEach begin="1" end="10" step="1" var="i">
	<c:out value="${i }"></c:out>
</c:forEach>
<hr>
Table of ${n1}
<br>
<c:forEach var="i" begin="1" end="10">
	<c:out value="${n1} * ${i} =  ${n1*i}"></c:out>
	<br>
</c:forEach>
<hr>
List of ProductList
<table border="1">
	<c:forEach items="${productList}" var="product">
		<tr>
			<td>${product.productId }</td>
			<td>${product.productName }</td>
			<td>${product.productPrice }</td>
		</tr>
	</c:forEach>
</table>
<!-- for(Product product: productList){
		sysout(product.getProductId());
 -->
 <!--removing salary from session scope--> 
<c:remove var="salary" scope="session"/>
 <c:import url="/login.html"></c:import>
<%--  <c:redirect url="/index.html"></c:redirect> --%>




















<%--  how to  use JSTL
1> copy paste jar file in WEB-INF/lib
jstl-1.2.jar
standard-2.2.0.jar
mysql.jar

2> include the jstl tag in jsp page using 
taglib directives

3> use the jstl tag in jsp page
--%>