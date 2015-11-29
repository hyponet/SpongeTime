<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-29
  Time: 下午10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <%@include file="../static/head.jsp"%>
  <title>创建团队 - SpongeTime仪表盘</title>
</head>
<body>
<%@include file="../static/nav.jsp"%>
<%@include file="../static/sideber.jsp"%>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
  <div class="row">
    <ol class="breadcrumb">
      <li><a href="/admin"><span class="glyphicon glyphicon-home"></span></a></li>
      <li>Dashboard</li>
      <li>团队</li>
      <li class="active">创建团队</li>
    </ol>
  </div><!--/.row-->

  <div class="row">
    <div class="col-lg-12">
      <h3 class="page-header">创建团队</h3>
      <p>您正在创建一个团队，团队可以发起 <span class="label label-warning">团队任务</span> 供多人完成。 TODO是一个人的寂寞，而团队是一群人的狂欢，让我们狂欢吧！</p>
    </div>
  </div><!--/.row-->
  <div class="row">
    <form method="POST">
      <div class="col-lg-6">
        <div class="col-lg-10 col-lg-offset-2">
          <div class="form-group">
            <label for="title">事件标题</label>
            <input type="text" class="form-control" id="title" name="eventTitle" placeholder="标题">
          </div>
          <div class="form-group">
            <label for="title">事件标题</label>
            <input type="text" class="form-control" id="title" name="eventTitle" placeholder="标题">
          </div>
          <div class="form-group">
            <label for="title">事件标题</label>
            <input type="text" class="form-control" id="title" name="eventTitle" placeholder="标题">
          </div>
          <div class="form-group">
            <label for="title">事件标题</label>
            <input type="text" class="form-control" id="title" name="eventTitle" placeholder="标题">
          </div>
        </div>
      </div>
      <div class="col-lg-6">
        <div class="col-lg-10">
          <div class="form-group">
            <label for="title">事件标题</label>
            <input type="text" class="form-control" id="title" name="eventTitle" placeholder="标题">
          </div>
          <div class="form-group">
            <label for="title">事件标题</label>
            <input type="text" class="form-control" id="title" name="eventTitle" placeholder="标题">
          </div>
          <div class="form-group">
            <label for="title">事件标题</label>
            <input type="text" class="form-control" id="title" name="eventTitle" placeholder="标题">
          </div>
          <div class="form-group">
            <label for="title">事件标题</label>
            <input type="text" class="form-control" id="title" name="eventTitle" placeholder="标题">
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-warning">创建团队</button>
            <a href="/admin" class="btn btn-default">取消</a>
          </div>
        </div>
      </div>
    </form>
  </div><!--/.row-->
</div>	<!--/.main-->
<script src="/static/js/jquery-1.11.1.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/chart.min.js"></script>
<script src="/static/js/chart-data.js"></script>
<script src="/static/js/easypiechart.js"></script>
<script src="/static/js/easypiechart-data.js"></script>
<script src="/static/js/bootstrap-datepicker.js"></script>
</body>

</html>
