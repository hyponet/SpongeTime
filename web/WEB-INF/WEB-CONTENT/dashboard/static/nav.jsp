<%@ page import="cn.updev.Users.Static.FuctionClass.Login" %>
<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-22
  Time: 上午2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/admin"><span>SPONGE</span>TIME</a>
      <ul class="user-menu">
        <li class="dropdown pull-right">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">你好， <span class="glyphicon glyphicon-user"></span> <%=new Login().getLoginedUser().getNickName()%> <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li class="disabled"><a href="/admin/system/message"><span class="glyphicon glyphicon-bell"></span> 消息通知</a></li>
            <li class="disabled"><a href="#"><span class="glyphicon glyphicon-cog"></span> 用户设置</a></li>
            <li><a href="https://github.com/Coderhypo/SpongeTime/blob/master/README.md" target="_blank"><span class="glyphicon glyphicon-zoom-in"></span> 了解更多</a></li>
            <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div><!-- /.container-fluid -->
</nav>