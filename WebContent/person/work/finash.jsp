<%@page import="net.ihypo.work.Work"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int workId = Integer.parseInt(request.getParameter("id"));
	Work work = new Work(workId);
	if(work.getUserId() != 0){
		if(work.isFinash())
			work.unFinash();
		else
			work.finash();
		work.update();
	}
%>
<script type="text/javascript">
	window.location="../index.jsp";
</script>