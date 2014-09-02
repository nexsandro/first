<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Project Drive:</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css" />

    <script src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script>
    <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/navigation.js"></script>
        

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
				          <li><a href="javascript:get('<%=request.getContextPath()%>/control/sec/company/list')">Empresas</a></li>
				        </ul>
					</li>
					<li><a href="javascript:get('<%=request.getContextPath()%>/control/common/logout')">Logout</a></li>
				</ul>
			</div>
		</div>	
	</div>

<!------------------
	Container div
 ------------------->
	<div id="content" class="container" style="margin-top: 50px;">

	</div>

</body>
</html>