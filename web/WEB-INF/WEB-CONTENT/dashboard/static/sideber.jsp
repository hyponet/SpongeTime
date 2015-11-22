<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-22
  Time: 上午2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String STR = "/WEB-INF/WEB-CONTENT/admin/";
  StringBuffer url = request.getRequestURL();
%>
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
  <form role="search">
    <div class="form-group">
      <input type="text" class="form-control" placeholder="Search">
    </div>
  </form>
  <ul class="nav menu">
    <li class="active"><a href="/admin"><span class="glyphicon glyphicon-dashboard"></span> 仪表盘</a></li>
    <li><a href="#"><span class="glyphicon glyphicon-list-alt"></span> TODO列表</a></li>
    <li><a href="/admin/addevents"><span class="glyphicon glyphicon-plus"></span> 添加任务</a></li>
    <li><a href="#"><span class="glyphicon glyphicon-pencil"></span> 管理任务</a></li>
    <li><a href="#"><span class="glyphicon glyphicon-briefcase"></span> 团队任务</a></li>
    <li><a href="#"><span class="glyphicon glyphicon-time"></span> 时间轴</a></li>
    <li class="parent ">
      <a href="#">
        <span class="glyphicon glyphicon-list"></span> 团队 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span>
      </a>
      <ul class="children collapse" id="sub-item-1">
        <li>
          <a class="" href="#">
            <span class="glyphicon glyphicon-certificate"></span> 创建团队
          </a>
        </li>
        <li>
          <a class="" href="#">
            <span class="glyphicon glyphicon-compressed"></span> 团队管理
          </a>
        </li>
        <li>
          <a class="" href="#">
            <span class="glyphicon glyphicon-send"></span> 发起任务
          </a>
        </li>
      </ul>
    </li>
    <li role="presentation" class="divider"></li>
    <li><a href="#"><span class="glyphicon glyphicon-envelope"></span> 意见反馈</a></li>
  </ul>
</div><!--/.sidebar-->