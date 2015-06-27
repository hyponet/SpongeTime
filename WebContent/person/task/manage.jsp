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

    <title>添加事件组 - SpongeTime个人中心</title>

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
			  事件与事件组是不一样的！事件更适合单一/琐碎事件计划，事件组更适合任务安排。
			</div>
          	</div>
          	<h2 class="sub-header">管理事件组</h2>
          	<div class="table-responsive">
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <% 
            	TaskGroup taskGroup = new TaskGroup(user.getId());
            	for(WorkGroup group:taskGroup.getList()){
            %>
			  <div class="panel panel-default">
			    <div class="panel-heading" role="tab" id="headingOne">
			      <h4 class="panel-title">
			        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#workgroup<%=group.getId() %>" aria-expanded="true" aria-controls="collapseOne">
			          <%=group.getTitle() %>
			        </a>
			        <div class="btn-group navbar-right" role="group" aria-label="...">
                  		<a data-toggle="modal" data-target="#edit" class="btn btn-primary btn-xs editbtn" id="">编辑</a>
					    <a data-toggle="modal" data-target="#del" class="btn btn-danger btn-xs delbtn" id="">删除</a>
					  <div class="btn-group" role="group">
					    <button type="button" class="btn btn-warning btn-xs dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					      优先级
					      <span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu">
					      <li><a href="update.jsp?id=&rank=1">紧急 | 重要</a></li>
					      <li><a href="update.jsp?id=&rank=2">紧急 | 不重要</a></li>
					      <li><a href="update.jsp?id=&rank=3">不紧急 | 重要</a></li>
					      <li><a href="update.jsp?id=&rank=4">不紧急 | 不重要</a></li>
					    </ul>
					  </div>
					</div>
			      </h4>
			    </div>
			    <div id="workgroup<%=group.getId() %>" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
			      <div class="panel-body">
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
		    			for(Work work:group.getList()){
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
		                  <td><%=work.getTitle()%></td>
		                  <td>目前还没这个功能！</td>
		                  <td><%=rank%></td>
		                  <td>X天后</td>
		                  <td>
		                  	<div class="btn-group" role="group" aria-label="...">
		                  		<a data-toggle="modal" data-target="#edit" class="btn btn-primary btn-sm editbtn" id="<%=work.getId()%>">编辑</a>
							    <a data-toggle="modal" data-target="#del" class="btn btn-danger btn-sm delbtn" id="<%=work.getId()%>">删除</a>
								<a class="btn btn-sm <%=work.isFinash()? "btn-default" : "btn-success" %>" href="work/finash.jsp?id=<%=work.getId() %>" role="button"><%=work.isFinash()? "取消" : "完成" %></a>
							</div>
		                  </td>
		                </tr>
		                <%} %>
		              </tbody>
		            </table>
			      </div>
			    </div>
			  </div>
			  <%} %>
			</div>
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
    $(document).ready( function() {
        $(".addwork").click(function(){
        	var work_num = $(".work").length;
            $(".works").append(
            		"<tr class=\"work\" id=\""+"work"+(work_num + 1)+"\">"+
              		"<td><b>"+ (work_num+1) +"</b></td>"+
              		"<td>"+"<input type=\"text\" class=\"form-control\" name=\""+"worktitle"+(work_num+1)+"\" placeholder=\"主题\">"+"</td>"+
              		"<td>"+"<input type=\"text\" class=\"form-control\" name=\""+"workremark"+(work_num+1)+"\" placeholder=\"备注\" disabled=\"disabled\">"+"</td>"+
             		"</tr>"
              );
            $("#worknum").attr("value",'');//清空内容
        	$("#worknum").attr("value",work_num+1);//填充内容
        });
      })

      $(document).ready(function() {
        $(".delwork").click(function() {
        	var work_num = $(".work").length;
            if(work_num > 2) {
              $("#work" + work_num).remove();
              $("#worknum").attr("value",'');//清空内容
          	  $("#worknum").attr("value",work_num-1);//填充内容
            }
            else
              alert("事件组中的事件不能小于两件！");
        }); 
      })
    </script>
  </body>
</html>
<%}%>