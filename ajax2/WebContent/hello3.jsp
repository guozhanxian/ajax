<%@ page contentType="text/plain;charset=utf-8"%>
<%
String name = request.getParameter("name");
%>
document.getElementById('helloTitle').innerHTML="<h1>Hello,<b><i><%=name%></i></b></h1>";
