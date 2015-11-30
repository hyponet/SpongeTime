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
      <div class="col-lg-6">
        <div class="col-lg-10 col-lg-offset-2">
          <h4 style="padding-top: 15px;">团队信息</h4>
          <form method="POST">
          <div class="form-group">
            <label>团队名</label>
            <input type="text" class="form-control" name="groupName" placeholder="团队的显示名称">
          </div>
          <div class="form-group">
            <label>团队简介</label>
            <textarea class="form-control" rows="5" name="groupIntro" placeholder="团队的简单介绍,不要超过100个字"></textarea>
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-warning">创建团队</button>
            <a href="/admin" class="btn btn-default">取消</a>
          </div>
          </form>
        </div>
      </div>
      <div class="col-lg-6">
        <div class="col-lg-10">
          <h4 style="padding-top: 15px;">团队介绍</h4>
          <p>和个人TODO不同，个人TODO已经设定所有的事件将有用户个人完成，而有的事件需要一个团队负责不同事项共同完成，那么，
            团队模块上线了，团队更适合执行多人任务。</p>
          <p>
            创建团队后您可以体验：
            <ul>
              <li>灵活的任务分配</li>
              <li>灵活的任务完成机制</li>
              <li>团队任务统计</li>
              <li>团队任务进度把握</li>
              <li>团队成员管理</li>
              <li>团队站内信</li>
            </ul>
          </p>
          <p>团队成员管理采用邀请制，团队创建成功后，将可以邀请团队成员。</p>
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
