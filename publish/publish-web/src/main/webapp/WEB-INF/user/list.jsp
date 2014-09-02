<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="br.com.jlabs.publish.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/user/edit">Adicionar</a><br />
<table>
	<tr><th>Login</th></tr>
<c:forEach var="user" items="${users}">
	<tr><td><a href="<%=request.getContextPath()%>/user/edit?user.id=${user.id}">${user.login}</a></td></tr>
</c:forEach>	
</table>
</body>
</html>