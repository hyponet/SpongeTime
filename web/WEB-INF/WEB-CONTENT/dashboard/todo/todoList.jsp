<%@ page import="java.util.List" %>
<%@ page import="cn.updev.Events.Static.IEvent" %>
<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-25
  Time: 上午12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<IEvent> weightEventList = (List<IEvent>) request.getAttribute("weightEventList");
  List<IEvent> expectEventList = (List<IEvent>) request.getAttribute("expectEventList");
  List<IEvent> reckonEventList = (List<IEvent>) request.getAttribute("reckonEventList");
%>
<%@include file="../static/head.jsp"%>
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
      <h3 class="page-header">TODO列表</h3>
      <p>TODO列表是根据不同侧重点排序的事件展示板，在这里您可以查看您所有的未完成任务（包括个人和团队）。</p>
    </div>
  </div><!--/.row-->
  <div class="row">
    <!--/.侧重权重 -->
    <div class="col-lg-4">
      <div class="row">
        <div class="col-lg-12">
          <h4>权重推荐优先</h4>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <div class="list-group">
            <%
              if(weightEventList != null){
                for(IEvent event : weightEventList){
            %>
            <a href="#" class="list-group-item"><%=event.getEventTitle()%></a>
            <%}}%>
          </div>
        </div>
      </div>
    </div><!--/.col-lg-4 -->
    <!--/.侧重理想时间 -->
    <div class="col-lg-4">
      <div class="row">
        <div class="col-lg-12">
          <h4>理想完成时间优先</h4>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <div class="list-group">
            <div class="list-group">
              <%
                if(expectEventList != null){
                  for(IEvent event : expectEventList){
              %>
              <a href="#" class="list-group-item"><%=event.getEventTitle()%></a>
              <%}}%>
            </div>
          </div>
        </div>
      </div>
    </div><!--/.col-lg-4 -->
    <!--/.侧重预计完成时间 -->
    <div class="col-lg-4">
      <div class="row">
        <div class="col-lg-12">
          <h4>预计完成时间优先</h4>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <div class="list-group">
            <div class="list-group">
              <%
                if(reckonEventList != null){
                  for(IEvent event : reckonEventList){
              %>
              <a href="#" class="list-group-item"><%=event.getEventTitle()%></a>
              <%}}%>
            </div>
          </div>
        </div>
      </div>
    </div><!--/.col-lg-4 -->
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
