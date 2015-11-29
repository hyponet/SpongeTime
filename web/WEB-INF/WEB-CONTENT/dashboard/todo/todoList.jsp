<%@ page import="java.util.List" %>
<%@ page import="cn.updev.Events.Static.EventInfo" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-25
  Time: 上午12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<EventInfo> weightEventList = (List<EventInfo>) request.getAttribute("weightEventList");
  List<EventInfo> expectEventList = (List<EventInfo>) request.getAttribute("expectEventList");
  List<EventInfo> reckonEventList = (List<EventInfo>) request.getAttribute("reckonEventList");
%>
<!DOCTYPE html>
<html>
<head>
  <%@include file="../static/head.jsp"%>
  <title>TODO列表 - SpongeTime</title>
</head>
<body>
<%@include file="../static/nav.jsp"%>
<%@include file="../static/sideber.jsp"%>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
  <div class="row">
    <ol class="breadcrumb">
      <li><a href="/admin"><span class="glyphicon glyphicon-home"></span></a></li>
      <li>Dashboard</li>
      <li class="active">TODO列表</li>
    </ol>
  </div><!--/.row-->

  <div class="row">
    <div class="col-lg-12">
      <h3 class="page-header">
        TODO列表
      </h3>
      <p>TODO列表是根据不同侧重点排序的事件展示板，在这里您可以查看您所有的未完成任务（包括个人和团队）。</p>
    </div>
  </div><!--/.row-->
  <div class="row">
    <!--/.侧重理想时间 -->
    <div class="col-lg-4">
      <div class="row">
        <div class="col-lg-12">
          <h4 id="expectEventList">
            <span class="glyphicon glyphicon-screenshot" aria-hidden="true"></span>
            理想完成时间优先
          </h4>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <div class="list-group">
            <div class="list-group">
              <%
                if(expectEventList != null){
                  for(EventInfo event : expectEventList){
              %>
              <a href="#" class="list-group-item" data-toggle="modal" data-target="#finishEvent" data-eventid="<%=event.getEventId()%>" data-eventtitle="<%=event.getEventTitle()%>" title="完成事件">
                <%
                  if(event.getGroupTitle()!=null){
                    out.print("<span class=\"label label-info\">"+event.getGroupTitle()+"</span>");
                  }else {
                    out.print("<span class=\"label label-success\">独立事件</span>");
                  }
                %>
                <%=event.getEventTitle()%>
                <%
                  SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
                  out.print(" <small>[" + dateFormat.format(event.getExpectTime()) + "]</small>");
                %>
              </a>
              <%}}%>
            </div>
          </div>
        </div>
      </div>
    </div><!--/.col-lg-4 -->
    <!--/.侧重权重 -->
    <div class="col-lg-4">
      <div class="row">
        <div class="col-lg-12">
          <h4 id="weightEventList">
            <span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>
            权重推荐优先
          </h4>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <div class="list-group">
            <%
              if(weightEventList != null){
                for(EventInfo event : weightEventList){
            %>
            <a href="#" class="list-group-item" data-toggle="modal" data-target="#finishEvent" data-eventid="<%=event.getEventId()%>" data-eventtitle="<%=event.getEventTitle()%>" title="完成事件">
              <%
                if(event.getGroupTitle()!=null){
                  out.print("<span class=\"label label-info\">"+event.getGroupTitle()+"</span>");
                }else {
                  out.print("<span class=\"label label-success\">独立事件</span>");
                }
              %>
              <%=event.getEventTitle()%>
            </a>
            <%}}%>
          </div>
        </div>
      </div>
    </div><!--/.col-lg-4 -->
    <!--/.侧重预计完成时间 -->
    <div class="col-lg-4">
      <div class="row">
        <div class="col-lg-12">
          <h4 id="reckonEventList">
            <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
            预计完成时间优先
          </h4>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <div class="list-group">
            <div class="list-group">
              <%
                if(reckonEventList != null){
                  for(EventInfo event : reckonEventList){
              %>
              <a href="#" class="list-group-item" data-toggle="modal" data-target="#finishEvent" data-eventid="<%=event.getEventId()%>" data-eventtitle="<%=event.getEventTitle()%>" title="完成事件">
                <%
                  if(event.getGroupTitle()!=null){
                    out.print("<span class=\"label label-info\">"+event.getGroupTitle()+"</span>");
                  }else {
                    out.print("<span class=\"label label-success\">独立事件</span>");
                  }
                %>
                <%=event.getEventTitle()%>
                <%
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
                  out.print(" <small>[" + dateFormat.format(event.getReckonTime()) + "]</small>");
                %>
              </a>
              <%}}%>
            </div>
          </div>
        </div>
      </div>
    </div><!--/.col-lg-4 -->
  </div><!--/.row-->
</div>	<!--/.main-->
<!-- 完成事件 -->
<div class="modal fade" id="finishEvent" tabindex="-1" role="dialog" aria-labelledby="finishEventLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="finishEventLabel">删除事件组</h4>
      </div>
      <form action="/admin/todolist" method="POST">
        <div class="modal-body">
          <input type="hidden" id="finishEventId" name="eventId"/>
          <p>您确认事件 <span class="label label-success" id="finishEventTitle"></span> 已经完成了吗？</p>
          <p>确认后，事件将划出TODO列表，您依然可以在任务管理中找到已完成的事件。</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-info">确认完成</button>
        </div>
      </form>
    </div>
  </div>
</div>
<script src="/static/js/jquery-1.11.1.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/chart.min.js"></script>
<script src="/static/js/chart-data.js"></script>
<script src="/static/js/easypiechart.js"></script>
<script src="/static/js/easypiechart-data.js"></script>
<script src="/static/js/bootstrap-datepicker.js"></script>
<script>
  $('#finishEvent').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var eventId = button.data('eventid')
    var eventTitle = button.data('eventtitle')

    var modal = $(this)
    modal.find('.modal-title').text('事件 ' + eventTitle + '完成确认')
    modal.find('#finishEventId').val(eventId)
    document.getElementById('finishEventTitle').innerHTML = eventTitle
  })</script>
</body>
</html>
