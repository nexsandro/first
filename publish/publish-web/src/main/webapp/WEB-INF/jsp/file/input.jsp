<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

		
<script type="text/javascript">


	function fileSelected(uploadInput) {

		var file = document.getElementById(uploadInput).files[0];
		if (file) {
			var fileSize = 0;
			if (file.size > 1024 * 1024)
				fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100)
						.toString()
						+ 'MB';
			else
				fileSize = (Math.round(file.size * 100 / 1024) / 100)
						.toString()
						+ 'KB';

			$('#fileName').html('Nome: ' + file.name);
			$('#fileSize').html('Tamanho: ' + fileSize);
			$('#fileType').html('Tipo: ' + file.type);

			// Fill if not chosen
			if ($('#file\\.name').val() == '') {
				$('#file\\.name').val(file.name);
			}
		}
	}

	function uploadFile() {
		xhr = new XMLHttpRequest();
		var fd = new FormData(document.getElementById('fileForm'));

		/* event listners */
		xhr.upload.addEventListener("progress", uploadProgress, false);
		xhr.addEventListener("load", uploadComplete, false);
		xhr.addEventListener("error", uploadFailed, false);
		xhr.addEventListener("abort", uploadCanceled, false);

		/* Be sure to change the url below to the url of your upload server side script */
		xhr.open("POST", "<%=request.getContextPath()%>/control/sec/file/ajax/upload");
		xhr.send(fd);
	}


	function uploadProgress(evt) {
		if (evt.lengthComputable) {
			var percentComplete = Math.round(evt.loaded * 100 / evt.total);
			document.getElementById('progressNumber').innerHTML = percentComplete.toString()
					+ '%';
			//  aria-valuenow="10" aria-valuemin="0" aria-valuemax="100" style="width: 10%;"
			$('#progressBar').attr('aria-valuenow', percentComplete);
			$('#progressBar').attr('style', 'width: ' + percentComplete + '%;');
			
		} else {
			document.getElementById('progressNumber').innerHTML = 'unable to compute';
		}
	}

	function uploadComplete(evt) {
		/* This event is raised when the server send back a response */
//		get('<%=request.getContextPath()%>/control/sec/dir/navigate?dirId=${dir.id}');
//		$('#fileForm').html(evt.responseText);

		var result = $.parseJSON(xhr.responseText);
		if (result.success)
			get('<%=request.getContextPath()%>/control/sec/dir/navigate?dirId=${dir.id}');
		else {
			alert('Erro ao fazer upload: ' + result.userMessage);		
			$('#progressBar').attr('aria-valuenow', 0);
			$('#progressBar').attr('style', 'width: ' + 0 + '%;');
			$('#progressNumber').html('');
		}
	}

	function uploadFailed(evt) {
		alert("Houve um erro tentando realizar upload: " + evt);
	}

	function uploadCanceled(evt) {
		alert("O usu&aacute;rio cancelou o upload ou o browser fechou a conex&atilde;o durante o upload.");
	}
</script>


<div class="container">
<div class="panel panel-default row">
	<div class="panel-heading">
		<h3>Arquivo</h3>
		<form:errors path="*" />
	</div>
	<div class="panel-body">

	<form:form id="fileForm" role="form" enctype="multipart/form-data" method="post" commandName="form" action="${pageContext.request.contextPath}/control/sec/file/ajax/upload">
	
		<form:hidden path="dir.id" />
		<form:hidden path="file.id" />
		<form:hidden path="file.version" />
		<form:hidden path="file.dir.id" />

	    <div class="form-group">
	      <label for="file.name">Nome</label><br />
	      <input type="text" name="file.name" id="file.name" class="form-control" value="<c:out value="${form.file.name}" />"/>
	      <form:errors path="file.name" />
	    </div>

	    <div class="form-group">
	      <label for="file.description">Descrição</label><br />
	      <textarea name="file.description" id="file.description" class="form-control"><c:out value="${form.file.description}" /></textarea>
	    </div>
	    
	    <div class="form-group">
	      <label for="fileToUpload">Escolha um arquivo</label><br />
	      <input type="file" name="multipartFile" id="fileToUpload" onchange="fileSelected('fileToUpload');"/>
	      <form:errors path="file" />
	    </div>

	    <div class="form-group">
		    <div id="fileName"></div>
		    <div id="fileSize"></div>
		    <div id="fileType"></div>
		    <div id="progressNumber"></div>
	    </div>
	    <div class="form-group">
		    <div class="progress progress-striped active">
			  <div id="progressBar" class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
				
			  </div>
		    </div>
		</div>
	  </form:form>
	</div>
	<div class="panel-footer">
		<button id="btnUpload" class="btn btn-primary">Upload</button>

		<button id="btnVoltar" class="btn btn-primary">Voltar</button>

	</div>
</div>
</div>

<script type="text/javascript">
	// this is a excerpt of  adocument, not onready
	
	$('#btnUpload').on("click",  function(e) {
		e.preventDefault();
		uploadFile();
	});
	
	$('#btnVoltar').on("click",  function(e) {
		e.preventDefault();
		get('<%=request.getContextPath()%>/control/sec/dir/navigate?dirId=${dir.id}');
	});

</script>