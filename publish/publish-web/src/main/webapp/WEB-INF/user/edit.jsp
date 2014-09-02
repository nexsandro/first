<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="br.com.jlabs.publish.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="user" scope="request" class="br.com.jlabs.publish.entity.User">
	<jsp:setProperty name="user" property="*" />
</jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Edit</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/user/save">
<input type="hidden" name="user.id" value="${user.id}" />
<table>
	<tr><td>Login:</td><td><input type="text" name="user.login" value="${user.login}"/></td></tr>
	<tr><td>Password:</td><td><input type="password" name="user.password" value="<c:out value="${user.password}" />" /></td></tr>
	<tr><td colspan="2"><input type="submit" value="Salvar" /></td></tr>
</table>
</form>
</body>
</html>