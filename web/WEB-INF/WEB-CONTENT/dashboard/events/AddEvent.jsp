<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-22
  Time: 上午4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <%@include file="../static/head.jsp"%>
  <title>添加独立事件 - SpongeTime仪表盘</title>
</head>
<body>
<%@include file="../static/nav.jsp"%>
<%@include file="../static/sideber.jsp"%>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
  <div class="row">
    <ol class="breadcrumb">
      <li><a href="/admin"><span class="glyphicon glyphicon-home"></span></a></li>
      <li>Dashboard</li>
      <li>添加任务</li>
      <li class="active">添加独立事件</li>
    </ol>
  </div><!--/.row-->

  <div class="row">
    <div class="col-lg-12">
      <h3 class="page-header">添加独立事件</h3>
      <p>您正在添加单项任务： <span class="label label-success">事件</span></p>
    </div>
  </div><!--/.row-->
  <div class="row">
    <div class="col-lg-8 col-lg-offset-2" style="padding-top: 25px;">
      <form action="/admin/addEvent" method="POST">
        <div class="form-group">
          <label for="title">事件标题</label>
          <input type="text" class="form-control" id="title" name="eventTitle" placeholder="标题">
        </div>
        <div class="form-group">
          <label for="expectTime">理想完成时间</label>
          <input type="date" class="form-control" id="expectTime" name="expectTime" placeholder="时间">
          <small>* 事件通知的时间参考。</small>
        </div>
        <div class="form-group">
          <label for="weight">事件权重</label>
          <select class="form-control" id="weight" name="weight">
            <option value="3" style="color:#5cb85c;">不紧急不重要</option>
            <option value="2" style="color:#5bc0de;">不紧急但重要</option>
            <option value="1" style="color:#f0ad4e;">紧急&nbsp;&nbsp;&nbsp;&nbsp;不重要</option>
            <option value="0" style="color:#d9534f;">紧急&nbsp;&nbsp;且&nbsp;&nbsp;重要</option>
          </select>
          <small>* TODO列表排序依据。</small>
        </div>
        <button type="submit" class="btn btn-success">添加</button>
        <a href="/admin/addevents" class="btn btn-default">取消</a>
      </form>
    </div>
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
