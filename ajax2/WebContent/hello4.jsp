<%@ page contentType="text/plain;charset=utf-8"%>
<%
String name = request.getParameter("name");
boolean isLong = (name.length() > 8);
%>
updateName("<%=name%>",<%=isLong%>);