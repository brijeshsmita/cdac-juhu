<h1 style='color:red'>Footer File </h1>
<%= session.getId()%>
<!-- session is implicit var/obj of HttpSession interface -->
<br>
<% out.println("session id is : "+session.getId());%>
<hr>