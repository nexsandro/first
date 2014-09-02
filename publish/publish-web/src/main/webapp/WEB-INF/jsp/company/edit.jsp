<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
<div class="panel panel-default row">
	<div class="panel-heading">
		<h3>Empresa</h3>
	</div>
	<div class="panel-body">
	
<form id="companyForm" method="post" class="form-horizontal" role="form" action="<%=request.getContextPath()%>/control/sec/company/save">
		
		<input type="hidden" name="id" value="${company.id}" />
		<input type="hidden" name="version" value="${company.version}" />
		
		<div class="form-group col-md-12">
			<label for="name" class="control-label col-md-2">Nome:</label>
			<div class="input-group col-md-10">
				<span class="input-group-addon">a-z</span>
				<input type="text" id="name" name="name" class="form-control" placeholder="Nome da empresa" value="<c:out value="${company.name}"/>" />
			</div>
		</div>
		<div class="form-group col-md-12">
			<label for="cnpj" class="control-label col-md-2">CNPJ:</label>
			<div class="input-group col-md-10">
				<span class="input-group-addon">0-9</span>
				<input type="text" id="cnpj" name="cnpj" class="form-control" placeholder="CNPJ sem pontuação" value="<c:out value="${company.cnpj}" />" />
			</div>
		</div>
		
		<div class="form-group col-md-12">
			<label for="address.street" class="control-label col-md-2">Rua:</label>
			<div class="input-group col-md-6">
				<span class="input-group-addon">a-z</span>
				<input type="text" id="address.street" name="address.street" class="form-control" placeholder="Rua" value="<c:out value="${company.address.street}"/>" />
			</div>

			<label for="address.number" class="control-label col-md-2">N&uacute;mero:</label>
			<div class="input-group col-md-2">
				<span class="input-group-addon">a-z</span>
				<input type="text" id="address.number" name="address.number" class="form-control" placeholder="N&uacute;mero" value="<c:out value="${company.address.number}"/>" />
			</div>
		</div>

		<div class="form-group col-md-12">
			<label for="address.street" class="control-label col-md-2">Complemento:</label>
			<div class="input-group col-md-10">
				<span class="input-group-addon">a-z</span>
				<input type="text" id="address.extra" name="address.extra" class="form-control" placeholder="Complemento" value="<c:out value="${company.address.extra}"/>" />
			</div>
		</div>
		
		<div class="form-group col-md-12">
			<label for="address.street" class="control-label col-md-2">Cidade:</label>
			<div class="input-group col-md-10">
				<span class="input-group-addon">a-z</span>
				<input type="text" id="address.city" name="address.city" class="form-control" placeholder="Cidade" value="<c:out value="${company.address.city}"/>" />
			</div>
		</div>

		<div class="form-group col-md-12">
			<label for="address.number" class="control-label col-md-2">Estado:</label>
			<div class="input-group col-md-4">
				<span class="input-group-addon">a-z</span>
				<input type="text" id="address.state" name="address.state" class="form-control" placeholder="Estado" maxLength="2" value="<c:out value="${company.address.state}"/>" />
			</div>
		
			<label for="address.street" class="control-label col-md-2">CEP:</label>
			<div class="input-group col-md-4">
				<span class="input-group-addon">0-9</span>
				<input type="text" id="address.cep" name="address.cep" class="form-control" placeholder="CEP" value="<c:out value="${company.address.cep}"/>" />
			</div>
		</div>

		<div class="form-group col-md-12">
			<label for="address.number" class="control-label col-md-2">Pa&iacute;s:</label>
			<div class="input-group col-md-10">
				<span class="input-group-addon">a-z</span>
				<input type="text" id="address.country" name="address.country" class="form-control" placeholder="Pa&iacute;s" value="<c:out value="${company.address.country}"/>" />
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
		post('companyForm');
	});

	$('#backButton').on("click",  function(e) {
		e.preventDefault();
		get('<%=request.getContextPath()%>/control/sec/company/list');
	});

	$('#projectsButton').on("click",  function(e) {
		e.preventDefault();
		get('<%=request.getContextPath()%>/control/sec/project/list?id=${company.id}');
	});
</script>
