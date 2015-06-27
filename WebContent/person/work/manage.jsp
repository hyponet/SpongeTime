<%@page import="net.ihypo.work.Work"%>
<%@page import="java.util.Iterator"%>
<%@page import="net.ihypo.work.WorkGroup"%>
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
<%}else{%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>添加事件 - SpongeTime个人中心</title>

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
            <li ><a href="addwork.jsp">添加事件</a></li>
            <li class="active"><a href="manage.jsp">管理事件<span class="sr-only">(current)</span></a></li>
            <li><a href="../task/addtask.jsp">添加事件组</a></li>
            <li><a href="">管理事件组</a></li>
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
			  无论是独立事件还是事件组事件都可以在此管理！
			</div>
          	</div>
          	<h2 class="sub-header">事件管理</h2>

          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>状态</th>
                  <th>主题</th>
                  <th>备注</th>
                  <th>优先级</th>
                  <th>预计完成</th>
                  <th>管理</th>
                </tr>
              </thead>
              <tbody>
              <%
              	WorkGroup group = new WorkGroup(user.getId());
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
                  <td><%=work.getGroupName() == null ? "":  "<b>" + work.getGroupName() + "</b>:"%><%=work.getTitle()%></td>
                  <td>目前还没这个功能！</td>
                  <td><%=rank%></td>
                  <td>X天后</td>
                  <td>
                  	<div class="btn-group" role="group" aria-label="...">
                  		<a data-toggle="modal" data-target="#edit" class="btn btn-primary btn-sm editbtn" id="<%=work.getId()%>">编辑</a>
					    <a data-toggle="modal" data-target="#del" class="btn btn-danger btn-sm delbtn" id="<%=work.getId()%>">删除</a>
					
					  <div class="btn-group" role="group">
					    <button type="button" class="btn btn-warning btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					      优先级
					      <span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu">
					      <li><a href="update.jsp?id=<%=work.getId()%>&rank=1">紧急 | 重要</a></li>
					      <li><a href="update.jsp?id=<%=work.getId()%>&rank=2">紧急 | 不重要</a></li>
					      <li><a href="update.jsp?id=<%=work.getId()%>&rank=3">不紧急 | 重要</a></li>
					      <li><a href="update.jsp?id=<%=work.getId()%>&rank=4">不紧急 | 不重要</a></li>
					    </ul>
					  </div>
					</div>
                  </td>
                </tr>
                <%} %>
              </tbody>
            </table>
          </div>
        </div>
      </div>
        </div>
        <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="EditLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="EditLabel">编辑事件详情</h4>
		      </div>
		      <form action="edit.jsp" method="post">
		      <div class="modal-body">
		      		<input type="hidden" id="editworkid" name="editworkid">
				  <div class="form-group">
				    <label for="title">主题</label>
				    <input type="text" class="form-control" id="title" name="title" placeholder="主题">
				  </div>
				  <div class="form-group">
				    <label for="title">完成时间</label>
				    <input type="date" class="form-control" id="date" name="date" disabled>
				  </div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button type="submit" class="btn btn-primary">保存修改</button>
		      </div>
		      </form>
		    </div>
		  </div>
</div>
<div class="modal fade" id="del" tabindex="-1" role="dialog" aria-labelledby="DelLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="DelLabel">警告</h4>
      </div>
      <div class="modal-body">
        <p>删除后不可找回，确认删除？</p>
      </div>
      <div class="modal-footer">
      	<form action="del.jsp" method="post">
      		<input type="hidden" id="delworkid" name="delworkid" /> 
       		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        	<button type="submit" class="btn btn-danger">删除</button>
        </form>
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
     <script type="text/javascript">
    $(document).ready(function (){
    	$(".editbtn").click(function(){
    		$("#editworkid").attr("value",'');//清空内容
        	$("#editworkid").attr("value",$(this).attr("id"));//填充内容
    	});
    })
    $(document).ready(function (){
    	$(".delbtn").click(function(){
        	$("#delworkid").attr("value",'');//清空内容
        	$("#delworkid").attr("value",$(this).attr("id"));//填充内容
    	});
    })
    </script>
  </body>
</html>
<%}%>