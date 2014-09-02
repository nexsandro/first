<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="panel panel-default">
	<div class="panel-heading">
	Arquivos
	</div> <!-- panel-heading -->

	<div class="panel-body">
<!-- 
	Breadcrumb
 -->
	<div class="col-sx-12 col-md-12 col-lg-12">
	<ol id="breadcrumbs" class="breadcrumb">
	<c:forEach var="item" items="${breadcrumb}" varStatus="status">
		<li>
			<c:if test="${!status.last}">
				<a href="javascript:get('<%=request.getContextPath()%>/control/sec/dir/navigate?dirId=${item.id}')">
			</c:if>
			<c:out value="${item.name}" />
			<c:if test="${!status.last}"></a></c:if>
		</li>
	</c:forEach>
	</ol>
	</div>

<!-- 
	Navigator
 -->
<div class="col-sx-12 col-lg-12">
<table id="dir" class="table table-striped table-condensed">
	<tr><td width="2%"><span class="glyphicon glyphicon-star-empty"></span></td><td width="88%">Nome</td><td width="10%" align="right">Bytes</td></tr>
<c:forEach var="dirItem" items="${dirContent['dirs']}">
	<tr>
		<td align="center">
			<span class="glyphicon glyphicon-star-empty"></span>
		</td>
		<td>
			<a href="javascript:get('<%=request.getContextPath()%>/control/sec/dir/navigate?dirId=${dirItem.id}')">
				<span class="glyphicon glyphicon-folder-close"></span>
				&nbsp;${dirItem.name}
			</a>
		</td>
		<td align="right">0</td>
	</tr>	
</c:forEach>
<c:forEach var="dirItem" items="${dirContent['files']}">
	<tr>
		<td align="center">
			<span class="glyphicon glyphicon-star-empty"></span>
		</td>
		<td>
		
<!-- 			<a href="javascript:window.location='<%=request.getContextPath()%>/control/sec/file/download/${dirItem.id}'">   -->


			<a href="javascript:get('<%=request.getContextPath()%>/control/sec/file/history?file.id=${dirItem.id}&dir.id=${dir.id}')">
				<span class="glyphicon glyphicon-file"></span>&nbsp;<c:out value="${dirItem.name}" />
			</a>
		</td>
		<td align="right"><fmt:formatNumber value="${dirItem.size/1024}" pattern="##,###,###,##0" /> Kb</td>
	</tr>	
</c:forEach>
</table>
</div>

</div> <!-- panel-body -->

<div class="panel-footer">
	<button type="button" id="btnNew" name="btnNew" class="btn btn-primary"><span class="glyphicon glyphicon-upload"></span> Adicionar Arquivo</button>
	<button type="button" id="btnDirectory" class="btn btn-primary"><span class="glyphicon glyphicon-folder-close"></span> Nova Pasta</button>
</div>
</div>


<!-- Upload Handler Scripts -->
<script type="text/javascript">
	
	$(function() {
		$('#btnNew').on('click', function(e) {
			e.preventDefault();
			get('<%=request.getContextPath()%>/control/sec/file/input?dir.id=${dir.id}');
		});
	});

	$(function() {
		$('#btnDirectory').on('click', function(e) {
			e.preventDefault();
			get('<%=request.getContextPath()%>/control/sec/dir/edit?parent.id=${dir.id}');
		});
	});

</script>

