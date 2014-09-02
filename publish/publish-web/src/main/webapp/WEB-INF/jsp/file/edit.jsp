<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<div class="container">
<div class="panel panel-default row">
	<div class="panel-heading">
		<h3>Arquivo</h3>
	</div>
	<div class="panel-body">
	
<form id="fileForm" method="post" class="form-horizontal" role="form" action="<%=request.getContextPath()%>/control/sec/file/save">
		
		<input type="hidden" name="file.id" value="${file.id}" />
		<input type="hidden" name="file.version" value="${file.version}" />
		
		<div class="form-group">
			<label class="control-label col-md-2">Nome:</label>
			<div class="col-md-10">
				<p class="form-control-static"><c:out value="${file.name}"/></p>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-2">Tamanho:</label>
			<div class="col-md-10">
				<p class="form-control-static"><c:out value="${file.size}"/></p>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-2">Descrição:</label>
			<div class="col-md-10">
				<p class="form-control-static"><c:out value="${file.description}"/></p>
			</div>
		</div>

	<c:forEach items="${fileHistory}" var="history">
		
		<div class="form-group">
			<label class="control-label col-md-2">Data Ajuste:</label>
			<div class="col-md-10">
				<p class="form-control-static"><fmt:formatDate value="${fileHistory.timestamp}" pattern="dd/MM/yyyy HH:mm:ss" /></p>
			</div>
		</div>
		
	</c:forEach>
			
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
