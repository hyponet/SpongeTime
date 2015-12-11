<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-22
  Time: 上午2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String uri = String.valueOf(request.getRequestURI());
  Integer order = 0;

  if(uri.endsWith("todoList.jsp")){
    order = 1;
  }else if(uri.endsWith("AddEvent_index.jsp") || uri.endsWith("AddEvent.jsp") || uri.endsWith("AddEventGroup.jsp")){
    order = 2;
  }else if(uri.endsWith("EventManage.jsp") || uri.endsWith("EditEventGroup.jsp")){
    order = 3;
  }else if(uri.endsWith("TeamTask.jsp")){
    order = 4;
  }
%>
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
  <form role="search">
    <div class="form-group">
      <input type="text" class="form-control" placeholder="Search">
    </div>
  </form>
  <ul class="nav menu">
    <li<%=order==0?" class=\"active\"":""%>><a href="/admin"><span class="glyphicon glyphicon-dashboard"></span> 仪表盘</a></li>
    <li<%=order==1?" class=\"active\"":""%>><a href="/admin/todolist"><span class="glyphicon glyphicon-list-alt"></span> TODO列表</a></li>
    <li<%=order==2?" class=\"active\"":""%>><a href="/admin/addevents"><span class="glyphicon glyphicon-plus"></span> 添加任务</a></li>
    <li<%=order==3?" class=\"active\"":""%>><a href="/admin/eventsmanage"><span class="glyphicon glyphicon-pencil"></span> 管理任务</a></li>
    <li<%=order==4?" class=\"active\"":""%> class="disabled"><a href="/admin/teamtask"><span class="glyphicon glyphicon-briefcase"></span> 团队看板</a></li>
    <li<%=order==5?" class=\"active\"":""%> class="disabled"><a href="#"><span class="glyphicon glyphicon-calendar"></span> 时间轴</a></li>
    <li class="parent">
      <a href="#team" data-toggle="collapse">
        <span class="glyphicon glyphicon-list" href="#team"></span> 团队 <span data-toggle="collapse" href="#team" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-chevron-down"></em></span>
      </a>
      <ul class="children collapse" id="team">
        <li>
          <a class="" href="/admin/group/addgroup">
            <span class="glyphicon glyphicon-certificate"></span> 创建团队
          </a>
        </li>
        <li>
          <a class="" href="/admin/group/manage">
            <span class="glyphicon glyphicon-compressed"></span> 团队管理
          </a>
        </li>
        <li>
          <a class="" href="/admin/group/addtask">
            <span class="glyphicon glyphicon-send"></span> 发起任务
          </a>
        </li>
      </ul>
    </li>
    <li role="presentation" class="divider"></li>
    <li><a href="http://form.mikecrm.com/f.php?t=6mg20r" target="_blank"><span class="glyphicon glyphicon-envelope"></span> 意见反馈</a></li>
  </ul>
</div><!--/.sidebar-->