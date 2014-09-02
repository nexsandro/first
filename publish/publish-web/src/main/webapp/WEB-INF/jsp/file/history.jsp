<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="container">
<div class="panel panel-default row">
	<div class="panel-heading">
		<h3>Arquivo</h3>
	</div>
	<div class="panel-body">

<form:form id="fileForm" cssClass="form-horizontal" action="${pageContext.request.contextPath}/control/sec/file/save" method="post" role="form" commandName="form">
	
<!-- form id="fileForm" method="post" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/control/sec/file/save" -->
		
		<form:hidden path="file.id" />
		<form:hidden path="file.version" />
		
		<div class="form-group">
			<label class="control-label col-md-2">Nome:</label>
			<div class="col-md-10">
				<p class="form-control-static"><c:out value="${form.file.name}"/></p>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-2">Tamanho:</label>
			<div class="col-md-10">
				<p class="form-control-static"><c:out value="${form.file.size}"/></p>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-2">Descrição:</label>
			<div class="col-md-10">
				<p class="form-control-static"><c:out value="${form.file.description}"/></p>
			</div>
		</div>
		<div class="form-group">
			<button name="btnDownload" class="btn btn-primary" fileVersion="${form.file.version}" fileId="${form.file.id}">Download</button>
		</div>

	<c:forEach var="history" items="${form.listFileHistory}">
		<div class="panel panel-default">
		
			<div class="panel-heading">
				<fmt:formatDate value="${history.timestamp}" pattern="dd/MM/yyyy HH:mm:ss" />
			</div>
			<div class="panel-body">
				<div class="form-group col-md-6 col-lg-6">
					<label class="control-label col-md-4">Nome:</label>
					<div class="col-md-8">
						<p class="form-control-static"><c:out value="${history.name}"/></p>
					</div>
				</div>
				<div class="form-group col-md-6 col-lg-6">
					<label class="control-label col-md-4">Nome original:</label>
					<div class="col-md-8">
						<p class="form-control-static"><c:out value="${history.originalName}"/></p>
					</div>
				</div>
				<div class="form-group col-md-6 col-lg-6">
					<label class="control-label col-md-4">Tamanho:</label>
					<div class="col-md-8">
						<p class="form-control-static"><c:out value="${history.size}"/></p>
					</div>
				</div>
				<div class="form-group col-md-6 col-lg-6">
					<label class="control-label col-md-4">Usuário:</label>
					<div class="col-md-8">
						<p class="form-control-static"><c:out value="${history.user}"/></p>
					</div>
				</div>
				<div class="form-group col-md-6 col-lg-6">
					<label class="control-label col-md-4">Internet Address:</label>
					<div class="col-md-8">
						<p class="form-control-static"><c:out value="${history.ip}"/></p>
					</div>
				</div>
				<div class="form-group col-md-6 col-lg-6">
					<button name="btnDownload" class="btn btn-primary" fileVersion="${history.fileVersion}" fileId="${form.file.id}">Download</button>
				</div>

			</div>
		</div>
	</c:forEach>
			
	</div>
	<div class="panel-footer">
		<button id="btnSubmit" class="btn btn-primary">Salvar</button>

		<button id="btnBack" class="btn btn-primary">Voltar</button>

	</div>
</div>
</div>

<script type="text/javascript">
	// this is a excerpt of  adocument, not onready
	$('#btnSubmit').on("click",  function(e) {
		e.preventDefault();
		post('disciplineForm');
	});

	$('#btnBack').on("click",  function(e) {
		e.preventDefault();
		get('<%=request.getContextPath()%>/control/sec/dir/navigate?dirId=${dir.id}');
	});
	
	$('button[name=btnDownload]').on("click",  function(e) {
		e.preventDefault();
		get('<%=request.getContextPath()%>/control/sec/file/id/' + $(this).attr('fileId') + '/version/' + $(this).attr('fileVersion'), window.document);
	});

</script>
<!-- /form -->
</form:form>
