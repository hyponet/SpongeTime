<%@page import="net.ihypo.work.WorkFactory"%>
<%@page import="net.ihypo.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title = request.getParameter("title");
	int rank = Integer.parseInt(request.getParameter("rank"));
	User user = (User)session.getAttribute("user");
	if(user != null){
	int id = user.getId();
	new WorkFactory().createWork(title, id, null, rank);
%>
<script type="text/javascript">
<!--
	window.location="addwork.jsp";
	alert("添加成功！");
//-->
</script>
<%}else{%>
<script type="text/javascript">
<!--
	window.location="addwork.jsp";
	alert("登录超时！");
//-->
</script>
<%}%>