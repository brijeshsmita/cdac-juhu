<%@page import="java.util.Date,java.time.LocalDate" %>
<h1>Hello <%=request.getParameter("username") %></h1>
<!-- Expression html comments-->
<%--jsp comments--%>
<hr>
Today Date Time :  <%=new Date()%>
<hr>
<%--Directive and declaration dont have access to implicit objects
as both takes place at compilation time --%>
<%! LocalDate date = LocalDate.now(); 
int age=19;// String name=request.getParameter("username");
%><!-- Declaration is used to declare variable and methods -->
Localdate : <% out.println(date); %> Scriptes are used to write java code within html

<%
if(age>18){
%>
<h2 style='color:green'>You are Eligible to vote</h2>
<%
}else{
%>
<h2 style='color:red'>You are NOT Eligible to vote</h2>
<%
}
%>