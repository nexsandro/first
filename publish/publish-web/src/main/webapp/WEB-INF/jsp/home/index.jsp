<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html ng-app="publish">
<head>
	<meta charset="UTF-8">
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Publish 1.00.00</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap/3.2.0/css/bootstrap.css" />

	<style>
      body {
        padding-top: 60px;
      }
    </style>

</head>
<body>
	<span class="padding-top: 260px"></span>

<!------------------
	Navigation bar
 ------------------->
    
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=request.getContextPath()%>/">Publish</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">  
					
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Cadastros <b class="caret"></b></a>
				        <ul class="dropdown-menu">
				          <li><a href="#/companies">Empresas</a></li>
				          <li><a href="#/products">Produtos</a></li>
				          <li><a href="#/brands">Marcas</a></li>
				        </ul>
					</li>
				</ul>
			</div>
		</div>	
	</div>

<!------------------
	Container div
 ------------------->
	<div id="content" class="container" style="margin-top: 50px;">
		<div ng-view class="slide-animation"></div>
	</div>

	
	<!-------------------------------------
	 Load Angular JS at the end of page 
	 -------------------------------------->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/1.10.2/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/3.2.0/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/angular/1.2.9/angular.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/angular/1.2.9/angular-route.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/angular-ui/ui-bootstrap-custom-tpls-0.10.0.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/publish/module.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/publish/company/module.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/publish/brand/module.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/publish/product/module.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/publish/contact/module.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/publish/marketsegment/module.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/publish/manufacturer/module.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/publish/negotiation/module.js"></script>

</body>
</html>