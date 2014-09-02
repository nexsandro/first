<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
<div class="panel panel-default row">
	<div class="panel-heading">
		<h3>Erro geral</h3>
	</div>
	<div class="panel-body">

		<div class="alert alert-danger">Ocorreu uma falha na execução do sistema: favor acionar a administração do sistema.</div>		
		<div class="alert alert-danger"><c:out value="${exception.message}" /></div>		
		<div class="alert alert-danger">
		<c:forEach var="stackTraceElement" items="${exception.stackTrace}">
		<c:out value="${stackTraceElement}" /><br />
		</c:forEach>
	</div>

</div>
</div>
