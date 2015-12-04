<%@ page import="cn.updev.Users.Static.UserOrGroupInterface.IGroupInfo" %>
<%@ page import="cn.updev.Users.User.GroupUserInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.updev.EventWeight.Rate.EventGroupRate" %>
<%@ page import="cn.updev.Users.Static.UserOrGroupInterface.IGroupUser" %>
<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-30
  Time: 下午12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  IGroupUser user = (IGroupUser) request.getAttribute("userInfo");
  IGroupInfo groupInfo = (IGroupInfo) request.getAttribute("groupInfo");
  List<GroupUserInfo> groupUser = (List<GroupUserInfo>) request.getAttribute("groupUser");
  List<EventGroupRate> groupTask = (List<EventGroupRate>) request.getAttribute("groupTask");

%>
<!DOCTYPE html>
<html>
<head>
  <%@include file="../static/head.jsp"%>
  <title>团队管理 - SpongeTime仪表盘</title>
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
      <li>团队管理</li>
      <li class="active">团队信息</li>
    </ol>
  </div><!--/.row-->


  <div class="row">
    <div class="col-lg-12">
      <h3 class="page-header">团队信息</h3>
      <p>在这里你可以进行团队信息管理，包括邀请成员，管理团队任务</p>
      <%
        String error = (String) request.getAttribute("error");
        if(error != null){
      %>
      <div style="padding-left: 20px; padding-right: 20px;">
        <div class="alert alert-warning" role="alert">
          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
          <p><%=error%></p>
        </div>
      </div>
      <%
        }
      %>
    </div>
  </div><!--/.row-->
  <div class="row">
    <div class="col-lg-6" style="padding-left: 3%;">
      <div class="panel panel-default">
        <div class="panel-body easypiechart-panel">
          <h4>团队详细信息</h4>
          <div style="padding-left: 10%; padding-top: 10px;">
            <p class="text-left"><b>团队名：</b><%=groupInfo.getGroupName()%></p>
          </div>
          <div style="padding-left: 10%;">
            <p class="text-left"><b>团队信息</b></p>
            <p class="text-left"><%=groupInfo.getGroupIntro()%></p>
          </div>
        </div>
        <div class="panel-footer">
          <div>
            <p class="text-right">
              <%
                if(user.isCreater() || user.isAdmin()){
              %>
              <button class="btn btn-link btn-sm" data-toggle="modal" data-target="#editGroupInfo" title="修改团队信息"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button>
              <% } %>
              <%
                if(user.isCreater()){
              %>
              <button class="btn btn-link btn-sm" data-toggle="modal" data-target="#delGroup" title="解散团队"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
              <% }else{ %>
              <button class="btn btn-link btn-sm" data-toggle="modal" data-target="#exitGroup" title="退出此团队"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></button>
              <% } %>
            </p>
          </div>
        </div>
      </div>
    </div><!-- /.col-lg-6 -->
    <div class="col-lg-6" style="padding-right: 3%;">
      <h4>
        团队成员管理
        <button class="btn btn-default" data-toggle="modal" data-target="#inviteNewUser" title="邀请新成员"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
      </h4>
      <table class="table table-bordered table-hover table-condensed">
        <thead>
        <tr>
          <th>昵称</th>
          <th>角色</th>
          <th>邮箱</th>
          <th>事件数</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
          for (GroupUserInfo userInfo : groupUser){
        %>
        <tr>
          <td><%=userInfo.getUserName()%></td>
          <td><%=userInfo.getUserRule()%></td>
          <td><%=userInfo.getUserEmail()%></td>
          <td><%=userInfo.getUserTask()%></td>
          <td>
            <div class="btn-group btn-group-xs" role="group">
              <%
                if(user.isCreater()){
                  if(!userInfo.getUserRule().equals("创建者")){
              %>
              <button class="btn btn-success disabled" data-toggle="modal" data-target="#editUserRule" data-userId="<%=userInfo.getUserId()%>" data-userName="<%=userInfo.getUserName()%>" title="修改成员角色"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></button>
              <%
                  }else{
              %>
              <button class="btn btn-success" data-toggle="modal" data-target="#editUserRule" data-userId="<%=userInfo.getUserId()%>" data-userName="<%=userInfo.getUserName()%>" title="修改成员角色"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></button>

              <% }} %>
              <a type="button" class="btn btn-warning" title="私信"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span></a>
              <%
                if(user.isCreater() || user.isAdmin()){
              %>
              <button class="btn btn-danger" data-toggle="modal" data-target="#delUser" data-userId="<%=userInfo.getUserId()%>" data-userName="<%=userInfo.getUserName()%>" title="删除用户"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
              <% } %>
            </div>
          </td>
        </tr>
        <%
          }
        %>
        </tbody>
      </table>
    </div><!-- /.col-lg-6 -->
  </div><!--/.row-->
  <div class="row">
    <div class="col-lg-12">
      <h4>
        团队任务
        <a type="button" href="/admin/group/addtask?groupId=<%=groupInfo.getGroupId()%>" class="btn btn-default" title="发起团队任务"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
      </h4>
    </div>
  </div><!--/.row-->
</div>	<!--/.main-->
<%
  if(user.isCreater() || user.isAdmin()){
%>
<!-- 修改团队信息 -->
<div class="modal fade" id="editGroupInfo" tabindex="-1" role="dialog" aria-labelledby="editGroupInfoLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="editGroupInfoLabel">修改团队信息</h4>
      </div>
      <form action="/admin/group/editgroupinfo" method="POST">
        <input type="hidden" name="groupId" value="<%=groupInfo.getGroupId()%>">
        <div class="modal-body">
          <div class="form-group">
            <label>团队名</label>
            <input type="text" class="form-control" name="groupName" placeholder="团队的显示名称" value="${groupName}">
          </div>
          <div class="form-group">
            <label>团队简介</label>
            <textarea class="form-control" rows="5" name="groupIntro" placeholder="团队的简单介绍,不要超过100个字">${groupIntro}</textarea>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-info">修改</button>
        </div>
      </form>
    </div>
  </div>
</div>
<%
  }
%>
<!-- 邀请新成员 -->
<div class="modal fade" id="inviteNewUser" tabindex="-1" role="dialog" aria-labelledby="inviteNewUserLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="inviteNewUserLabel">邀请新成员</h4>
      </div>
      <form action="/admin/group/inviteuser" method="POST">
        <input type="hidden" name="groupId" value="<%=groupInfo.getGroupId()%>">
        <div class="modal-body">
          <div class="form-group">
            <label>用户名或邮箱</label>
            <input type="text" class="form-control" name="userInfo" placeholder="被邀请人的用户名或邮箱">
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-primary">邀请</button>
        </div>
      </form>
    </div>
  </div>
</div>
<%
  if(user.isCreater()){
%>
<!-- 修改成员权限 -->
<div class="modal fade" id="editUserRule" tabindex="-1" role="dialog" aria-labelledby="editUserRuleLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="editUserRuleLabel">修改成员权限</h4>
      </div>
      <form action="#" method="POST">
        <input type="hidden" name="groupId" value="<%=groupInfo.getGroupId()%>">
        <input type="hidden" name="userId">
        <div class="modal-body">
          <div class="form-group">
            <p><b>用户名：</b><label id="userName"></label></p>
            <label>修改角色为：</label>
            <select class="form-control" name="userRule">
              <option value="0">普通成员</option>
              <option value="1">管理员</option>
            </select>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-success">修改</button>
        </div>
      </form>
    </div>
  </div>
</div>
<%
  }
%>
<%
  if(user.isCreater() || user.isAdmin()){
%>
<!-- 删除成员 -->
<div class="modal fade" id="delUser" tabindex="-1" role="dialog" aria-labelledby="delUserLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="delUserLabel">删除成员</h4>
      </div>
      <form action="#" method="POST">
        <input type="hidden" name="groupId" value="<%=groupInfo.getGroupId()%>">
        <input type="hidden" name="userId">
        <div class="modal-body">
            <p>您确认删除成员 <label id="delUserName"></label> 吗？</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-danger">删除</button>
        </div>
      </form>
    </div>
  </div>
</div>
<%
  }
%>
<script src="/static/js/jquery-1.11.1.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/chart.min.js"></script>
<script src="/static/js/chart-data.js"></script>
<script src="/static/js/easypiechart.js"></script>
<script src="/static/js/easypiechart-data.js"></script>
<script src="/static/js/bootstrap-datepicker.js"></script>
<script>
  $('#editUserRule').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var userId = button.data('userid')
    var userName = button.data('username')

    var modal = $(this)
    modal.find('.modal-title').text('修改成员 ' + userName + ' 的团队角色')
    modal.find('#userId').val(userId)
    document.getElementById('userName').innerHTML = userName
  })
  $('#delUser').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var userId = button.data('userid')
    var userName = button.data('username')

    var modal = $(this)
    modal.find('.modal-title').text('删除成员 ' + userName + ' 确认')
    modal.find('#userId').val(userId)
    document.getElementById('delUserName').innerHTML = userName
  })
</script>

</body>

</html>
