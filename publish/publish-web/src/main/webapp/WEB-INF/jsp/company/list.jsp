<!--  


	Company list screen

-->

<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form method="post" action="<%=request.getContextPath()%>/control/sec/company/list">
<div class="container">

	<div class="row">
		<div class="panel panel-default col-lg-10 col-md-10 col-xs-12 col-lg-offset-1 col-md-offset-1">

			<!-- Title -->
			<div class="panel-heading">
				<div class="row">
					<div class="col-lg-6">
					Empresas
					</div>
					<div class="col-lg-6 text-right">
					<a href="javascript:get('<%=request.getContextPath()%>/control/sec/company/edit')">
					<span class="glyphicon glyphicon-plus"></span>
					</a>
					</div>
				</div>
				
			</div>		

			<!-- Table List -->
			<div class="panel-body">
				<table class="table table-striped table-condensed">
					<tr><th>Nome</th><th>CNPJ</th></tr>

<c:forEach var="company" items="${companies}">
					<tr><td><a href="javascript:get('<%=request.getContextPath()%>/control/sec/company/edit?id=${company.id}')"><c:out value="${company.name}" /></a></td><td><c:out value="${company.cnpj}" /></td></tr>
</c:forEach>
				</table>
			</div>
		</div>
	
	</div>

</div>
</form>