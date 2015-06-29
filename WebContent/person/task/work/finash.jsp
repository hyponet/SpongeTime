<%@page import="net.ihypo.task.TaskFactory"%>
<%@page import="net.ihypo.work.Work"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int workId = Integer.parseInt(request.getParameter("id"));
	int tId = Integer.parseInt(request.getParameter("tid"));
	Work work = new Work(workId);
	if(work.getUserId() != 0){
		if(work.isFinash()){
			work.unFinash();
			if(work.getGroupId() != -1)
				TaskFactory.unFinashWork(work.getGroupId());
		}else{
			work.finash();
			if(work.getGroupId() != -1)
				TaskFactory.finashWork(work.getGroupId());
		}
		work.update();
	}
%>
<script type="text/javascript">
	window.location="../manage.jsp?tid=<%=tId%>";
</script>