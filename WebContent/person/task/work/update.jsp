<%@page import="net.ihypo.work.Work"%>
<%@page import="net.ihypo.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	User user = (User)session.getAttribute("user");
	if(user != null){
		Work work = new Work(id);
		if(work.getUserId() != 0){
			int rank = Integer.parseInt(request.getParameter("rank"));
			work.setRank(rank);
			int tId = work.getGroupId();
			work.update();
		}
%>
<script type="text/javascript">
<!--
	window.location="../manage.jsp?tid=<%=tId%>";
--!>
</script>
<%}else{%>
<script type="text/javascript">
<!--
	window.location="manage.jsp";
	alert("登录超时！");
//-->
</script>
<%}%>