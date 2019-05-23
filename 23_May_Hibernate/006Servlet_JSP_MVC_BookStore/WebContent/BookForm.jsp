<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="${pageContext.request.contextPath }\WebContent\css\book.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<c:if test="${book != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${book == null}">
			<form action="insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${book != null}">
            			Edit Book
            		</c:if>
					<c:if test="${book == null}">
            			Add New Book
            		</c:if>
				</h2>
			</caption>
			<c:if test="${book != null}">
				<input type="hidden" name="id" value="<c:out value='${book.id}' />" />
			</c:if>
			<tr>
				<th>Title:</th>
				<td><input type="text" name="title" size="45"
					value="<c:out value='${book.title}' />" /></td>
			</tr>
			<tr>
				<th>Author:</th>
				<td><input type="text" name="author" size="45"
					value="<c:out value='${book.author}' />" /></td>
			</tr>
			<tr>
				<th>Price:</th>
				<td><input type="text" name="price" size="5"
					value="<c:out value='${book.price}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>

	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
