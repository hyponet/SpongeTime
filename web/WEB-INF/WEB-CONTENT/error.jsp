<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-23
  Time: 上午1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>错误 - SpongeTime</title>

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
      <div class="panel-heading"><em class="glyphicon glyphicon-remove glyphicon-m"></em>抱歉！遇到一个错误</div>
      <div class="panel-body">
        <p>如果您看到这个页面，说明SpongeTime遇到了一个无法解决的问题。而产生这个问题的原因可能有如下几点：</p>
        <ul>
          <li>程序本身的BUG</li>
          <li>您的误操作</li>
        </ul>
        <br/>
        <p>如果您发现了什么问题，欢迎及时反馈给我们。</p>
        <div class="panel-footer text-right">
          <a class="btn btn-primary" href="#">反馈</a>
          <a class="btn btn-default" href="/admin">返回</a>
        </div>
      </div>
    </div>
  </div><!-- /.col-->
</div><!-- /.row -->
</body>

</html>
