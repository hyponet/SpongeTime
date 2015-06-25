<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("user") != null)
		session.removeAttribute("user");
%>
<script type="text/javascript">
<!--
	window.location="index.jsp";
	alert("注销成功！")
//-->
</script>