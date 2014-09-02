<!--  


	Discipline list screen

-->

<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form method="post" action="<%=request.getContextPath()%>/control/sec/discipline/list">
<div class="container">

	<div class="row">
		<div class="panel panel-default col-lg-10 col-lg-offset-1">

			<!-- Title -->
			<div class="panel-heading">
				<div class="row">
					<div class="col-lg-6">
					Disciplinas
					</div>
					<div class="col-lg-6 text-right">
					<a href="javascript:get('<%=request.getContextPath()%>/control/sec/discipline/edit')">
					<span class="glyphicon glyphicon-plus"></span>
					</a>
					</div>
				</div>
				
			</div>		

			<!-- Table List -->
			<div class="panel-body">
				<table class="table table-striped table-condensed">
					<tr><th>Nome</th></tr>

<c:forEach var="discipline" items="${disciplines}">
					<tr><td><a href="javascript:get('<%=request.getContextPath()%>/control/sec/discipline/edit?id=${discipline.id}')"><c:out value="${discipline.name}" /></a></td></tr>
</c:forEach>
				</table>
			</div>
		</div>
	
	</div>

</div>
</form>