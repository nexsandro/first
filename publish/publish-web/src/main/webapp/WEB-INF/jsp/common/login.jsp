<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Login</title>
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap/3.0.0/css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layout/jlabs.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/1.10.2/jquery.js"></script>
</head>
<body>

<div class="container">

<form method="POST" action="<%=request.getContextPath()%>/j_security_check" class="form">

<div class="row titled-div col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3" style="margin-top:100px;">
<div class="panel panel-primary row">
	
	<div class="panel-heading">
	Login
	</div>
	<div class="panel-body">
	<div class="form-group">
		<label for="j_username">Login:</label>
		<div class="input-group">
		<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
		<input type="text" id="j_username" name="j_username" value="sandro" class="form-control" placeholder="Digite o login" />
		</div>
	</div>
	<div class="form-group">
		<label for="j_password">Senha:</label>
		<div class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
			<input type="password" name="j_password" value="x" class="form-control" placeholder="Digite a senha" />
		</div>
	</div>
	<div class="form-group">
		<div class="input-group">
			<button class="btn btn-primary">Logar</button>
		</div>
	</div>
	</div>
</div>

</div>

</form>

</div>
</body>
</html>
<script type="text/javascript">
	$('#j_username').focus();
</script>