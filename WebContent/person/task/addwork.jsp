<%@page import="net.ihypo.work.WorkGroup"%>
<%@page import="net.ihypo.task.TaskGroup"%>
<%@page import="net.ihypo.work.Work"%>
<%@page import="java.util.Iterator"%>
<%@page import="net.ihypo.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	User user = (User)session.getAttribute("user");
	if(user == null){
%>
<script type="text/javascript">
<!--
	window.location="../../login/index.jsp";
	alert("请登录");
//-->
</script>
<%}else{
	int taskId = Integer.parseInt(request.getParameter("id"));
	WorkGroup group = new WorkGroup(user.getId(),taskId);
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>添加事件到[<%=group.getTitle() %>] - SpongeTime个人中心</title>

    <!-- Bootstrap core CSS -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../js/html5shiv.min.js"></script>
      <script src="../../js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="../index.jsp">SpongeTime 个人中心</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">通知</a></li>
            <li><a href="#">设置</a></li>
            <li><a href="#">帮助</a></li>
            <li><a href="../../login/logout.jsp">(<%=user.getName() %>) 注销</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="查找...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="../index.jsp">概观</a></li>
            <li><a href="../../task/index.jsp">任务进度</a></li>
            <li><a href="#">时间线</a></li>
            <li><a href="#">计划月历</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="../work/addwork.jsp">添加事件</a></li>
            <li><a href="../work/manage.jsp">管理事件</a></li>
            <li><a href="addtask.jsp">添加事件组</a></li>
            <li class="active"><a href="manage.jsp">管理事件组<span class="sr-only">(current)</span></a></li>
            <li><a href="">计划规划</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">创建团队</a></li>
            <li><a href="">加入团队</a></li>
            <li><a href="">团队计划</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          	<div>
          	<div class="alert alert-info alert-dismissible" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  	可以新建事件并直接添加到事件组[<%=group.getTitle() %>]，也可以直接把已有事件添加。
			  	注意，一个事件只能属于一个事件组，如果添加已归属其他事件组的事件，会将事件转移。
			</div>
          	</div>
          	<h2 class="sub-header">添加事件到 [<%=group.getTitle() %>]</h2>
          	
          	<h4 class="sub-header">新建事件</h4>
          	<form action="" method="post">
				  <div class="form-group">
				    <label for="title">主题</label>
				    <input type="text" class="form-control" id="title" name="title" placeholder="主题">
				  </div>
				  <div class="form-group">
				    <label for="title">优先级</label>
				    <select class="form-control" name="rank">
					  <option value="1">紧急且重要</option>
					  <option value="2">紧急但不重要</option>
					  <option value="3">不紧急但重要</option>
					  <option value="4">不紧急且不重要</option>
					</select>
				  </div>
				  <div class="form-group">
				    <label for="title">完成时间</label>
				    <input type="date" class="form-control" id="date" name="date" disabled>
				  </div>
				  <button type="submit" class="btn btn-default">添加事件</button>
				</form>
				<br/>
          	<h4 class="sub-header">添加事件</h4>
          	<div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>状态</th>
                  <th>主题</th>
                  <th>备注</th>
                  <th>优先级</th>
                  <th>预计完成</th>
                  <th>FINASH</th>
                </tr>
              </thead>
              <tbody>
              <%
    			for(Iterator<Work> i = group.getUserAll().iterator();i.hasNext();){
    				Work work = i.next();
    				String classType = null;
    				String rank = null;
    				if(work.getRank() == 1){
    					classType = "danger";
    					rank = "<b>紧急</b> | <b>重要</b>";
    				}else if(work.getRank() == 2){
    					classType = "info";
    					rank = "<b>紧急</b>";
    				}else if(work.getRank() == 3){
    					classType = "warning";
    					rank = "<b>重要</b>";
    				}else if(work.getRank() == 4){
    					classType = "success";
    					rank = "";
    				}else{
    					classType = "active";
    					rank = "出现BUG";
    					rank = "出现BUG";
    				}
              %>
                <tr class="<%=classType%>">
                   <td><%=work.isFinash()? "已完成" : "<b>未完成</b>" %></td>
                  <td><%=work.getGroupName() == null ? "": "<b>" + work.getGroupName() + "</b>:"%><%=work.getTitle()%></td>
                  <td>目前还没这个功能！</td>
                  <td><%=rank%></td>
                  <td>X天后</td>
                  <td><a class="btn btn-sm <%=work.isFinash()? "btn-default" : "btn-success" %>" href="work/finash.jsp?id=<%=work.getId() %>" role="button"><%=work.isFinash()? "取消" : "完成" %></a></td>
                </tr>
                <%} %>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
<%}%>