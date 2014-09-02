<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form method="post" action="<%=request.getContextPath()%>/dir/create.do">
	Parent id: <input type="text" name="parentDir" /><br />
	Dir Name: <input type="text" name="dir" /><br />
	<input type="submit" value="Criar" />
</form>

<form method="post" action="<%=request.getContextPath()%>/files/upload.do" enctype="multipart/form-data">
	Dir Id: <input type="text" name="dirId" /><br />
	<input type="file" name="file" /><br />
	<input type="submit" value="Upload" />
</form>

