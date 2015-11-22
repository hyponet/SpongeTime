<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-22
  Time: 上午2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../static/head.jsp"%>
<body>
<%@include file="../static/nav.jsp"%>
<%@include file="../static/sideber.jsp"%>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
  <div class="row">
    <ol class="breadcrumb">
      <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
      <li>Dashboard</li>
      <li class="active">添加任务</li>
    </ol>
  </div><!--/.row-->

  <div class="row">
    <div class="col-lg-12">
      <h3 class="page-header">添加任务</h3>
      <p>在这里，您可以添加适合单项任务的 <span class="label label-success">事件</span> 或者适合多项任务集合的 <span class="label label-info">事件祖</span></p>
    </div>
  </div><!--/.row-->
  <div class="row">
    <div class="col-lg-6 col-lg-offset-2">
      <div class="col-lg-5" style="padding-top: 70px;">
        <a href="addEvent" style="text-decoration: none">
          <div style="padding: 20%; background-color:#5cb85c; border-radius:15px 5px;">
            <center><p style="font-size: 22px;color: #ffffff;"><b>添加事件</b> </p></center>
          </div>
        </a>
        <small> * 添加独立性事件，事件拥有时间提醒等功能</small>
      </div>
      <div class="col-lg-5 col-lg-offset-2" style="padding-top: 70px;">
        <a href="addEventGroup" style="text-decoration: none">
          <div style="padding: 20%; background-color:#5bc0de; border-radius:15px 5px;">
            <center><p style="font-size: 22px; color: #ffffff"><b>添加事件组</b> </p></center>
          </div>
        </a>
        <small> * 添加多项任务集合，事件组拥有进度提醒，完成时间预测等功能</small>
      </div>
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
