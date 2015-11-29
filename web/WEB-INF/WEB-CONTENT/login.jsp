<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-22
  Time: 上午12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录 - SpongeTime</title>

<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/css/datepicker3.css" rel="stylesheet">
<link href="/static/css/styles.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="/static/js/html5shiv.js"></script>
<script src="/static/js/respond.min.js"></script>
<![endif]-->

</head>
<body>
<div class="container">
	<%
		String error = (String) request.getAttribute("error");
		if(error != null){
	%>
	<div style="padding-left: 20px; padding-right: 20px; padding-top: 15px;">
		<div class="alert alert-info" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<p><%=error%></p>
		</div>
	</div>
	<%
		}
	%>
	<div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">登录到SpongeTime</div>
				<div class="panel-body">
					<form action="/login" method="POST">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="邮箱" name="email" type="email" value="${email}" autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="密码" name="password" type="password" value="">
							</div>
							<div class="checkbox">
								<label>
									<input name="remember" type="checkbox" value="Remember Me">记住登录状态
								</label>
							</div>
							<button type="submit" class="btn btn-primary">登录</button>
							<a href="/register" class="btn btn-default">注册</a>
						</fieldset>
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->
</div>
	<script src="/static/js/jquery-1.11.1.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<script src="/static/js/chart.min.js"></script>
	<script src="/static/js/chart-data.js"></script>
	<script src="/static/js/easypiechart.js"></script>
	<script src="/static/js/easypiechart-data.js"></script>
	<script src="/static/js/bootstrap-datepicker.js"></script>
</body>
</html>
