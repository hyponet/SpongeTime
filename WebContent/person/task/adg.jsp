<%@page import="net.ihypo.work.WorkGroup"%>
<%@page import="net.ihypo.work.WorkFactory"%>
<%@page import="net.ihypo.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User user = (User)session.getAttribute("user");
	if(user != null){
	int workNum = Integer.parseInt(request.getParameter("worknum"));
	int id = user.getId();
	WorkGroup task = new WorkGroup(id);
	task.setTitle(new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8"));
	task.setRank(Integer.parseInt(request.getParameter("rank")));
	for(int i = 1;i <= workNum;i++){
		String title = new String(request.getParameter("worktitle" + i).getBytes("ISO-8859-1"),"UTF-8");
		int rank = Integer.parseInt(request.getParameter("rank"));
		task.addWork(title, id, null, rank);
	}
	task.insert();
%>
<script type="text/javascript">
<!--
	window.location="addtask.jsp";
	alert("添加成功！");
//-->
</script>
<%}else{%>
<script type="text/javascript">
<!--
	window.location="../../login/index.jsp";
	alert("登录超时！");
//-->
</script>
<%}%>