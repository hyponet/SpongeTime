<%@page import="net.ihypo.work.WorkGroup"%>
<%@page import="net.ihypo.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User user = (User)session.getAttribute("user");
	if(user != null){
		int taskId = Integer.parseInt(request.getParameter("edittaskid"));
		String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
		int id = user.getId();
		WorkGroup group = new WorkGroup(user.getId(),taskId);
		group.setTitle(title);
		group.update();
%>
<script type="text/javascript">
<!--
	window.location="manage.jsp";
//-->
</script>
<%}else{%>
<script type="text/javascript">
<!--
	window.location="../../login/index.jsp";
	alert("登陆超时！");
//-->
</script>
<%}%>