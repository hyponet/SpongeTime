<%@ page import="cn.updev.Users.Static.UserOrGroupInterface.IGroupInfo" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-12-4
  Time: 下午6:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<IGroupInfo> createGroup = (List<IGroupInfo>) request.getAttribute("createGroup");
  List<IGroupInfo> manageGroup = (List<IGroupInfo>) request.getAttribute("manageGroup");
  List<IGroupInfo> joinGroup = (List<IGroupInfo>) request.getAttribute("joinGroup");
%>
<!DOCTYPE html>
<html>
<head>
  <%@include file="../static/head.jsp"%>
  <title>发起团队任务 - SpongeTime仪表盘</title>
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
      <li>团队任务</li>
      <li class="active">选择团队</li>
    </ol>
  </div><!--/.row-->

  <div class="row">
    <div class="col-lg-12">
      <h3 class="page-header">选择团队</h3>
      <p>您正在发起团队任务，请选择将要发起团队任务的团队。</p>
    </div>
  </div><!--/.row-->
  <div class="row">
    <div class="col-lg-4">
      <h4>我创建的团队</h4>
      <div class="list-group">
        <%
          for(IGroupInfo groupInfo:createGroup){
        %>
        <a href="/admin/group/addtask?groupId=<%=groupInfo.getGroupId()%>" class="list-group-item">
          <h4 class="list-group-item-heading"><%=groupInfo.getGroupName()%></h4>
          <p class="list-group-item-text"><%=groupInfo.getGroupIntro()%></p>
        </a>
        <%
          }
        %>
      </div>
    </div>
    <div class="col-lg-4">
      <h4>我管理的团队</h4>
      <div class="list-group">
        <%
          for(IGroupInfo groupInfo:manageGroup){
        %>
        <a href="/admin/group/addtask?groupId=<%=groupInfo.getGroupId()%>" class="list-group-item">
          <h4 class="list-group-item-heading"><%=groupInfo.getGroupName()%></h4>
          <p class="list-group-item-text"><%=groupInfo.getGroupIntro()%></p>
        </a>
        <%
          }
        %>
      </div>
    </div>
    <div class="col-lg-4">
      <h4>我加入的团队</h4>
      <div class="list-group">
        <%
          for(IGroupInfo groupInfo:joinGroup){
        %>
        <a href="/admin/group/addtask?groupId=<%=groupInfo.getGroupId()%>" class="list-group-item">
          <h4 class="list-group-item-heading"><%=groupInfo.getGroupName()%></h4>
          <p class="list-group-item-text"><%=groupInfo.getGroupIntro()%></p>
        </a>
        <%
          }
        %>
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
