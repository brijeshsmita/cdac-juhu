<%if(session!=null)session.invalidate();%>
<h1 style='color:green'> Logged out successfully!</h1>
<jsp:include page="login.jsp"></jsp:include>