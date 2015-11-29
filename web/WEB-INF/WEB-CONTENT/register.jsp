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
<div class="container">
  <div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2">
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
                <label>用户名</label>
                <input class="form-control" placeholder="用户名" id="username" name="userName" type="text" value="${userName}">
                <small>
                  <p id="userNameError" style="padding-left: 10px;"></p>
                  * 必填 只能由 字母、数字、_ 、- 组成
                </small>
              </div>
              <div class="form-group">
                <label>昵称</label>
                <input class="form-control" placeholder="昵称" name="nickName" type="text" value="${nickName}">
                <small>* 必填</small>
              </div>
              <div class="form-group">
                <label>邮箱</label>
                <input class="form-control" placeholder="邮箱" id="email" name="email" type="email" value="${email}">
                <small>
                  <p id="EmailError" style="padding-left: 10px;"></p>
                  * 必填 作为登录账户，建议选择常用邮箱
                </small>
              </div>
              <div class="form-group">
                <label>密码</label>
                <input class="form-control" placeholder="密码" id="password" name="password" type="password" value="">
              </div>
              <div class="form-group">
                <label>重复密码</label>
                <input class="form-control" placeholder="重复密码" id="rePassword" name="rePassword" type="password" value="">
                <small>
                  <p id="rePasswordError" style="color:#d9534f; padding-left: 10px;"></p>
                </small>
              </div>
              <div class="form-group">
                <label>个人主页<small>（可选）</small></label>
                <input class="form-control" placeholder="个人主页（可选）" name="url" type="text" value="${url}">
              </div>
              <div class="form-group">
                <label>内测码</label>
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
</div>
<script src="/static/js/jquery-1.11.1.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/chart.min.js"></script>
<script src="/static/js/chart-data.js"></script>
<script src="/static/js/easypiechart.js"></script>
<script src="/static/js/easypiechart-data.js"></script>
<script src="/static/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
  document.getElementById("username").onblur=function(){  // 输入框失去焦点
    var thisNode=this;
    var span=document.getElementById("userNameError");
    var xmlhttp;
    try{
      // code for IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
    }catch(e){
      // code for IE6, IE5
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function(){
      if(xmlhttp.readyState<4){  // 正在交互
        span.style.color="#5bc0de";
        span.innerHTML="正在判断";
      }
      if (xmlhttp.readyState==4 && (xmlhttp.status==200 || xmlhttp.status==0)){  // 请求成功
        var result = xmlhttp.responseText;
        var json = eval("(" + result + ")");
        if(json.userName){
          span.style.color="#5cb85c";
          span.innerHTML="用户名可用！";
        }else{
          span.style.color="#d9534f";
          span.innerHTML=json.message;
        }
      }
    }
    xmlhttp.open("POST","/api/judgeusername",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("userName="+thisNode.value);
  }
  document.getElementById("email").onblur=function(){  // 输入框失去焦点
    var thisNode=this;
    var span=document.getElementById("EmailError");
    var xmlhttp;
    try{
      // code for IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
    }catch(e){
      // code for IE6, IE5
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function(){
      if(xmlhttp.readyState<4){  // 正在交互
        span.style.color="#5bc0de";
        span.innerHTML="正在判断邮箱是否可用";
      }
      if (xmlhttp.readyState==4 && (xmlhttp.status==200 || xmlhttp.status==0)){  // 请求成功
        var result = xmlhttp.responseText;
        var json = eval("(" + result + ")");
        if(json.email){
          span.style.color="#5cb85c";
          span.innerHTML="邮箱可用！";
        }else{
          span.style.color="#d9534f";
          span.innerHTML=json.message;
        }
      }
    }
    xmlhttp.open("POST","/api/judgeusername",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("email="+thisNode.value);
  }
  document.getElementById("rePassword").onblur=function(){
    var pass = document.getElementById('password').value;
    var rePass = this.value;
    if(pass != rePass){
      document.getElementById('rePasswordError').innerHTML = '两次输入的密码不一致！';
    }else{
      document.getElementById('rePasswordError').innerHTML = '';

    }
  }
  document.getElementById("password").onblur=function(){
    var pass = document.getElementById('rePassword').value;
    var rePass = this.value;
    if(pass != rePass){
      document.getElementById('rePasswordError').innerHTML = '两次输入的密码不一致！';
    }else{
      document.getElementById('rePasswordError').innerHTML = '';

    }
  }
</script>
</body>
</html>
