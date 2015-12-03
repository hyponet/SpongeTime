<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-30
  Time: 下午1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <%@include file="../static/head.jsp"%>
  <title>消息通知 - SpongeTime仪表盘</title>
</head>
<body>
<%@include file="../static/nav.jsp"%>
<%@include file="../static/sideber.jsp"%>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
  <div class="row">
    <ol class="breadcrumb">
      <li><a href="/admin"><span class="glyphicon glyphicon-home"></span></a></li>
      <li>Dashboard</li>
      <li class="active">消息通知</li>
    </ol>
  </div><!--/.row-->

  <div class="row">
    <div class="col-lg-12">
      <h3 class="page-header">消息通知</h3>
      <p>在收件箱你可以查看系统通知，团队站内信等信息！</p>
    </div>
  </div><!--/.row-->
  <div class="row">
    <div class="col-lg-12">
      <table class="table table-bordered table-hover table-condensed">
        <thead>
        <tr>
          <th>标题</th>
          <th>类型</th>
          <th>发件人</th>
          <th>时间</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>消息通知还不能用</td>
          <td>系统通知</td>
          <td>测试君</td>
          <td>2015-11-12</td>
          <td>
            <div class="btn-group btn-group-xs" role="group">
              <button type="button" class="btn btn-danger" title="删除"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
            </div>
          </td>
        </tr>
        </tbody>
      </table>
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
