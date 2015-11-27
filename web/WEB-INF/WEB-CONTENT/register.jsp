<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-26
  Time: 下午11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>注册新用户 - SpongeTime</title>

  <link href="/static/css/bootstrap.min.css" rel="stylesheet">
  <link href="/static/css/datepicker3.css" rel="stylesheet">
  <link href="/static/css/styles.css" rel="stylesheet">

  <!--[if lt IE 9]>
  <script src="/static/js/html5shiv.js"></script>
  <script src="/static/js/respond.min.js"></script>
  <![endif]-->

</head>

<body>
<div class="row">
  <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
    <div class="login-panel panel panel-default">
      <div class="panel-heading">欢迎使用SpongeTime <small><span class="label label-warning">试运行</span></small></div>
      <%
        String error = (String) request.getAttribute("error");
        if(error != null){
      %>
      <div style="padding-left: 20px; padding-right: 20px; padding-top: 15px;">
        <div class="alert alert-danger" role="alert">
          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
          <p><%=error%></p>
        </div>
      </div>
      <%
        }
      %>
      <div class="panel-body">
        <form action="/register" method="POST">
          <fieldset>
            <div class="form-group">
              <input class="form-control" placeholder="用户名" name="userName" type="text" value="${userName}">
              <small>* 必填 只能由字母、数字、特殊符号组成</small>
            </div>
            <div class="form-group">
              <input class="form-control" placeholder="昵称" name="nickName" type="text" value="${nickName}">
              <small>* 必填</small>
            </div>
            <div class="form-group">
              <input class="form-control" placeholder="邮箱" name="email" type="email" value="${email}">
              <small>* 必填 作为登录账户，建议选择常用邮箱</small>
            </div>
            <div class="form-group">
              <input class="form-control" placeholder="密码" name="password" type="password" value="">
            </div>
            <div class="form-group">
              <input class="form-control" placeholder="重复密码" name="rePassword" type="password" value="">
            </div>
            <div class="form-group">
              <input class="form-control" placeholder="个人主页（可选）" name="url" type="text" value="${url}">
            </div>
            <div class="form-group">
              <input class="form-control" placeholder="内测码" name="code" type="text" value="${code}">
              <small>* 必填 测试期间使用内测码注册</small>
            </div>
            <button type="submit" class="btn btn-primary">注册</button>
            <a href="/login" class="btn btn-link">已有账户？</a>
          </fieldset>
        </form>
      </div>
    </div>
  </div><!-- /.col-->
</div><!-- /.row -->
<script src="/static/js/jquery-1.11.1.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/chart.min.js"></script>
<script src="/static/js/chart-data.js"></script>
<script src="/static/js/easypiechart.js"></script>
<script src="/static/js/easypiechart-data.js"></script>
<script src="/static/js/bootstrap-datepicker.js"></script>
</body>
</html>
