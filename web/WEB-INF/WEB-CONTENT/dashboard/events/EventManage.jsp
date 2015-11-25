<%@ page import="java.util.List" %>
<%@ page import="cn.updev.Events.Group.UserEventGroup" %>
<%@ page import="cn.updev.Events.Static.IEvent" %>
<%@ page import="cn.updev.Events.Group.EventGroupInfo" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="cn.updev.Events.Static.EventWeight" %>
<%@ page import="cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupQuery" %>
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
  String groupName = null;
  List<IEvent> events = (List<IEvent>)request.getAttribute("events");
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
              if(groupId == groupInfo.getGroupId()){
                groupName = groupInfo.getGroupTitle();
              }
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
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addNewEvent" data-groupid="<%=groupId%>" data-groupname="<%=groupName%>" title="添加新事件到该事件组"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
            <a href="/admin/eventGroupEdit?groupId=<%=groupId%>" type="button" class="btn btn-default" title="编辑该事件组信息"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#delEventGroup" data-groupid="<%=groupId%>" data-groupname="<%=groupName%>" title="删除该事件组"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
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
                  String ownerName = new UserOrGroupQuery().queryUserById(event.getOwnerId()).getNickName();
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
              <td><%=ownerName%></td>
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
                  <a href="/admin/eventFinish?eventId=<%=event.getEventId()%>" type="button" class="btn <%=event.isFinish()?"btn-default":"btn-success"%>" title="<%=event.isFinish()?"取消完成":"确认完成"%>">
                    <%
                      if(event.isFinish()){
                    %>
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                    <%
                    }else {
                    %>
                    <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                    <%}%>
                  </a>
                  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editEvent" data-eventid="<%=event.getEventId()%>" data-eventtitle="<%=event.getEventTitle()%>" data-expecttime="<%=dateFormat.format(event.getExpectTime())%>" data-weight="<%=event.getWeight().ordinal()%>" title="编辑该事件信息"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button>
                  <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delEvent" data-eventid="<%=event.getEventId()%>" data-eventtitle="<%=event.getEventTitle()%>" title="删除该事件"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
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
<!-- 添加事件到任务组 -->
<div class="modal fade" id="addNewEvent" tabindex="-1" role="dialog" aria-labelledby="addNewEventLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="addNewEventLabel">添加新事件</h4>
      </div>
      <form action="/admin/addEventToGroup" method="POST">
        <div class="modal-body">
          <input type="hidden" class="form-control" id="addGroupId" name="groupId"/>
          <div class="form-group">
            <label class="control-label">新增事件标题：</label>
            <input type="text" class="form-control" name="eventTitle"/>
          </div>
          <div class="form-group">
            <label>理想完成时间</label>
            <input type="date" class="form-control" name="expectTime" placeholder="时间">
            <small>* 事件通知的时间参考。</small>
          </div>
          <div class="form-group">
            <label>事件权重</label>
            <select class="form-control" name="weight">
              <option value="3" style="color:#5cb85c;">不紧急不重要</option>
              <option value="2" style="color:#5bc0de;">不紧急但重要</option>
              <option value="1" style="color:#f0ad4e;">紧急&nbsp;&nbsp;&nbsp;&nbsp;不重要</option>
              <option value="0" style="color:#d9534f;">紧急&nbsp;&nbsp;且&nbsp;&nbsp;重要</option>
            </select>
            <small>* TODO列表排序依据。</small>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-success">添加</button>
        </div>
      </form>
    </div>
  </div>
</div>
<!-- 删除任务组 -->
<div class="modal fade" id="delEventGroup" tabindex="-1" role="dialog" aria-labelledby="delEventGroupLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="delEventGroupLabel">删除事件组</h4>
      </div>
      <form action="/admin/delEventGroup" method="POST">
        <div class="modal-body">
          <input type="hidden" class="form-control" id="delGroupId" name="groupId"/>
          <input type="hidden" name="user" value="1"/>
          <p>您确认删除事件组 <span class="label label-info" id="delEventGroupTitle"></span> ？</p>
          <p>删除后，该事件组和事件组内的所有事件将会被<b>彻底删除</b>。</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-danger">删除</button>
        </div>
      </form>
    </div>
  </div>
</div>
<!-- 修改事件信息 -->
<div class="modal fade" id="editEvent" tabindex="-1" role="dialog" aria-labelledby="editEventLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="editEventLabel">修改事件信息</h4>
      </div>
      <form action="/admin/updateEvent" method="POST">
        <div class="modal-body">
          <input type="hidden" id="editEventId" name="eventId"/>
          <div class="form-group">
            <label class="control-label">事件标题：</label>
            <input type="text" class="form-control" id="editEventTitle" name="eventTitle"/>
          </div>
          <div class="form-group">
            <label>理想完成时间</label>
            <input type="date" class="form-control" id="editEventExpectTime" name="expectTime" placeholder="时间">
            <small>* 事件通知的时间参考。</small>
          </div>
          <div class="form-group">
            <label>事件权重</label>
            <select class="form-control" id="editEventWeight" name="weight">
              <option value="3" style="color:#5cb85c;">不紧急不重要</option>
              <option value="2" style="color:#5bc0de;">不紧急但重要</option>
              <option value="1" style="color:#f0ad4e;">紧急&nbsp;&nbsp;&nbsp;&nbsp;不重要</option>
              <option value="0" style="color:#d9534f;">紧急&nbsp;&nbsp;且&nbsp;&nbsp;重要</option>
            </select>
            <small>* TODO列表排序依据。</small>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-primary">更新</button>
        </div>
      </form>
    </div>
  </div>
</div>
<!-- 删除事件 -->
<div class="modal fade" id="delEvent" tabindex="-1" role="dialog" aria-labelledby="delEventLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="delEventLabel">删除事件组</h4>
      </div>
      <form action="/admin/delEvent" method="POST">
        <div class="modal-body">
          <input type="hidden" id="delEventId" name="eventId"/>
          <p>您确认删除事件 <span class="label label-success" id="delEventTitle"></span> ？</p>
          <p>删除后，该事件将在TODO列表中被<b>彻底删除</b>。</p>
          <small>* 如果该事件是任务组的子任务，删除该事件将影响任务组进度统计、完成时间推测、进度提醒判断等相关计算。</small>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-danger">删除</button>
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
  $('#addNewEvent').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var groupId = button.data('groupid')
    var groupName = button.data('groupname')

    var modal = $(this)
    modal.find('.modal-title').text('添加新事件 到 ' + groupName)
    modal.find('#addGroupId').val(groupId)
  })
  $('#delEventGroup').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var groupId = button.data('groupid')
    var groupName = button.data('groupname')

    var modal = $(this)
    modal.find('.modal-title').text('确认删除事件组 ' + groupName + '?')
    modal.find('#delGroupId').val(groupId)
    modal.find('#delEventGroupTitle').append(groupName)
  })
  $('#editEvent').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var eventId = button.data('eventid')
    var eventTitle = button.data('eventtitle')
    var expectTime = button.data('expecttime')
    var weight = button.data('weight')

    var modal = $(this)
    modal.find('.modal-title').text('修改事件信息 ' + eventTitle + '?')
    modal.find('#editEventId').val(eventId)
    modal.find('#editEventTitle').val(eventTitle)
    modal.find('#editEventExpectTime').val(expectTime)
    modal.find('#editEventWeight').val(weight)
  })
  $('#delEvent').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var eventId = button.data('eventid')
    var eventTitle = button.data('eventtitle')

    var modal = $(this)
    modal.find('.modal-title').text('确认删除事件 ' + eventTitle + '?')
    modal.find('#delEventId').val(eventId)
    document.getElementById('delEventTitle').innerHTML = eventTitle
  })
</script>
</body>
</html>
