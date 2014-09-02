<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
<div class="panel panel-default row">
	<div class="panel-heading">
		<h3>Disciplina</h3>
	</div>
	<div class="panel-body">
	
<form id="disciplineForm" method="post" class="form-horizontal" role="form" action="<%=request.getContextPath()%>/control/sec/discipline/save">
		
		<input type="hidden" name="id" value="${discipline.id}" />
		<input type="hidden" name="version" value="${discipline.version}" />
		
		<div class="form-group col-md-12">
			<label for="name" class="control-label col-md-2">Nome:</label>
			<div class="input-group col-md-10">
				<span class="input-group-addon">a-z</span>
				<input type="text" id="name" name="name" class="form-control" placeholder="Nome da disciplina" value="<c:out value="${discipline.name}"/>" />
			</div>
		</div>
		
</form>
	</div>
	<div class="panel-footer">
		<button id="submitButton" class="btn btn-primary">Salvar</button>

		<button id="backButton" class="btn btn-primary">Voltar</button>

	</div>
</div>
</div>

<script type="text/javascript">
	// this is a excerpt of  adocument, not onready
	$('#submitButton').on("click",  function(e) {
		e.preventDefault();
		post('disciplineForm');
	});

	$('#backButton').on("click",  function(e) {
		e.preventDefault();
		get('<%=request.getContextPath()%>/control/sec/discipline/list');
	});

	$('#projectsButton').on("click",  function(e) {
		e.preventDefault();
		get('<%=request.getContextPath()%>/control/sec/discipline/list?id=${discipline.id}');
	});
</script>
