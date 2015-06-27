<%@page import="net.ihypo.work.WorkGroup"%>
<%@page import="net.ihypo.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int taskId = Integer.parseInt(request.getParameter("deltaskid"));
	User user = (User)session.getAttribute("user");
	if(user != null){
		WorkGroup group = new WorkGroup(user.getId(),taskId);
		group.drop();
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