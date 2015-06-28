<%@page import="net.ihypo.work.WorkFactory"%>
<%@page import="net.ihypo.user.User"%>
<%@page import="net.ihypo.work.Work"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int workId = Integer.parseInt(request.getParameter("editworkid"));
	String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
	User user = (User)session.getAttribute("user");
	if(user != null){
		int id = user.getId();
		Work work = new Work(workId);
		work.setTitle(title);
		work.update();
%>
<script type="text/javascript">
<!--
	window.location="../manage.jsp";
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