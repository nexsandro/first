<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
<div class="panel panel-default row">
	<div class="panel-heading">
		<h3>Diretório</h3>
	</div>
	<div class="panel-body">
	
<form id="directoryForm" method="post" class="form-horizontal" role="form" action="<%=request.getContextPath()%>/control/sec/dir/save">
		
		<input type="hidden" name="parent.id" value="${dir.parent.id}" />
		<input type="hidden" name="id" value="${dir.id}" />
		
		<div class="form-group col-md-12">
			<label for="name" class="control-label col-md-2">Nome:</label>
			<div class="input-group col-md-10">
				<span class="input-group-addon">a-z</span>
				<input type="text" id="dirName" name="name" class="form-control" placeholder="Nome do diretório" value="<c:out value="${dir.name}"/>" />
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
	$('#dirName').focus();
	
	$('#submitButton').on("click",  function(e) {
		e.preventDefault();
		post('directoryForm');
	});

</script>
