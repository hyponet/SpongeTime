<%@page import="net.ihypo.work.WorkFactory"%>
<%@page import="net.ihypo.user.User"%>
<%@page import="net.ihypo.work.Work"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int workId = Integer.parseInt(request.getParameter("delworkid"));
	User user = (User)session.getAttribute("user");
	if(user != null){
		Work work = new Work(workId);
		work.drop();
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