<%@page import="net.ihypo.work.Work"%>
<%@page import="net.ihypo.work.WorkFactory"%>
<%@page import="net.ihypo.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User user = (User)session.getAttribute("user");
	if(user != null){
	int userid = user.getId();
	int taskid = Integer.parseInt(request.getParameter("taskid"));
	String rankString = request.getParameter("rank");
	if(rankString != null){
		int rank = Integer.parseInt(rankString);
		String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
		new WorkFactory().createWork(title, userid, null, rank,taskid);
	}else{
		int id = Integer.parseInt(request.getParameter("id"));
		Work work = new Work(id);
		if(work.getGroupId() == taskid){
			work.setGroupId(-1);
		}else{
			work.setGroupId(taskid);
		}
		work.update();
	}
%>
<script type="text/javascript">
<!--
	window.location="addwork.jsp?id=<%=taskid%>";
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