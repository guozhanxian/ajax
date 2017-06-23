<%@ page contentType="text/html;charset=utf-8"%>
<%
String name = request.getParameter("name");
%>
<h1>
	Hello
	<%=name%>
</h1>
<p>
	I used to know someone called
	<b><i><%=name%></i></b>. Are you related?
</p>
