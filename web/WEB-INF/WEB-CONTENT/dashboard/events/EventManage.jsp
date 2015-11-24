<%@ page import="java.util.List" %>
<%@ page import="cn.updev.Events.Group.UserEventGroup" %>
<%@ page import="cn.updev.Events.Static.IEvent" %>
<%@ page import="cn.updev.Events.Group.EventGroupInfo" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="cn.updev.Events.Static.EventWeight" %>
<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-22
  Time: 上午8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<UserEventGroup> groups = (List<UserEventGroup>) request.getAttribute("groups");
  Integer groupId = (Integer) request.getAttribute("groupId");
  List<IEvent> events = (List<IEvent>)request.getAttribute("events");
%>
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
      <p>您正在管理您所有的任务，不同的任务权重会有不同的颜色标记。这里不会出现团队任务，团队任务请选择<span class="label label-warning">团队看板</span></p>
    </div>
  </div><!--/.row-->
  <div class="row" style="padding-top: 20px; padding-bottom: 50px;">
    <div class="col-lg-4">
      <h4>任务组列表</h4>
      <div class="list-group">
        <a href="/admin/eventsmanage?groupId=0" class="list-group-item<%=(groupId == 0 ? " active" : "")%>">
          无任务组事件
        </a>
        <%
          if(groups != null){
            for (UserEventGroup group : groups){
              EventGroupInfo groupInfo = group.getGroupInfo();
        %>
        <a href="/admin/eventsmanage?groupId=<%=groupInfo.getGroupId()%>" class="list-group-item<%=(groupId == groupInfo.getGroupId() ? " active" : "")%>">
          <%=groupInfo.getGroupTitle()%>
        </a>
        <%
          }}
        %>
      </div>
    </div><!--/.col-lg-4-->
    <div class="col-lg-8">
      <div class="row">
        <div class="col-lg-11">
          <%
            if(groupId == 0){
          %>
          <h4>
            无任务组事件管理
            <a type="button" href="/admin/addEvent" class="btn btn-default" title="添加无任务组事件"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
          </h4>
          <%
          }else {
          %>
          <h4>
            任务组管理
            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus" aria-hidden="true" title="添加新事件到该事件组"></span></button>
            <a href="/admin/eventGroupEdit?groupId=<%=groupId%>" type="button" class="btn btn-default" title="编辑该事件组信息"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-trash" title="删除该事件组" aria-hidden="true"></span></button>
          </h4>
          <%
            }
          %>
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
            <%
              if(events != null){
                for(IEvent event : events){
                  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                  String weight = "";
                  if(event.getWeight() == EventWeight.RED){

                    weight = "danger";
                  }else if(event.getWeight() == EventWeight.YELLOW){

                    weight = "warning";
                  }else if(event.getWeight() == EventWeight.BLUE){

                    weight = "info";
                  }else if(event.getWeight() == EventWeight.GREEN){

                    weight = "success";
                  }
            %>
            <tr class="<%=weight%>">
              <td><%=event.isFinish() ? "<del>" + event.getEventTitle() + "</del>" : event.getEventTitle()%></td>
              <td><%=dateFormat.format(event.getCreateTime())%></td>
              <td>Admin</td>
              <td><%=dateFormat.format(event.getExpectTime())%></td>
              <td>
                <%
                  if(event.isFinish()){
                    out.print("已完成");
                  }else {
                    long time = event.getExpectTime().getTime() - new Date().getTime();
                    if(time > 0){
                      out.print("进行中");
                    }else {
                      if(time < -604800000){
                        out.print("严重超期");
                      }else {
                        out.print("超期");
                      }
                    }
                  }
                %>
              </td>
              <td>
                <div class="btn-group btn-group-xs" role="group">
                  <button type="button" class="btn btn-success" title="<%=event.isFinish()?"取消完成":"确认完成"%>">
                    <%
                      if(event.isFinish()){
                    %>
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                    <%
                    }else {
                    %>
                    <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                    <%}%>
                  </button>
                  <button type="button" class="btn btn-primary" title="编辑该事件信息"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button>
                  <button type="button" class="btn btn-danger" title="删除该事件"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
                </div>
              </td>
            </tr>
            <%
            }}
            %>
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
