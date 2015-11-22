<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-22
  Time: 上午8:19
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
      <li class="active">管理任务</li>
    </ol>
  </div><!--/.row-->

  <div class="row">
    <div class="col-lg-12">
      <h3 class="page-header">管理任务</h3>
      <p>您正在管理您所有的任务，不同的任务权重会有不同的颜色标记，而且团队任务会有团队标签： <span class="label label-warning">团队名</span></p>
    </div>
  </div><!--/.row-->
  <div class="row" style="padding-top: 20px; padding-bottom: 50px;">
    <div class="col-lg-4">
      <h4>任务组列表</h4>
      <div class="list-group">
        <a href="#" class="list-group-item active">
          事件组1
        </a>
        <a href="#" class="list-group-item">事件组2</a>
        <a href="#" class="list-group-item">事件组3</a>
        <a href="#" class="list-group-item">事件组4</a>
        <a href="#" class="list-group-item">事件组5</a>
      </div>
    </div><!--/.col-lg-4-->
    <div class="col-lg-8">
      <div class="row">
        <div class="col-lg-11">
          <h4>
            任务组管理
            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button>
            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
          </h4>
          <table class="table table-bordered table-hover table-condensed">
            <thead>
            <tr>
              <th>任务标题</th>
              <th>创建时间</th>
              <th>创建者</th>
              <th>预期时间</th>
              <th>状态</th>
              <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>任务1名字很长23333</td>
              <td>2015-11-11</td>
              <td>Admin</td>
              <td>2016-01-01</td>
              <td>进行中</td>
              <td>
                <div class="btn-group btn-group-xs" role="group">
                  <button type="button" class="btn btn-success"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button>
                  <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button>
                  <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
                </div>
              </td>
            </tr>
            </tbody>
          </table>
        </div><!--/.col-lg-11-->
      </div><!--/.row-->
    </div><!--/.col-lg-8-->
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
