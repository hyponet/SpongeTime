<%@page import="net.ihypo.user.User"%>
<%@page import="net.ihypo.db.UserDb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String email = request.getParameter("email");
	String pwd = request.getParameter("password");
	User user = new UserDb().judgeLogin(email, pwd);
	if(user == null){
%>
<script type="text/javascript">
<!--
	window.location="index.html";
	document.getElementById("login").insertAdjacentHTML("beforeBegin","<h1>11</h1>"); 
//-->
</script>

<%}else{
	session.setAttribute("user", user);
%>
	
<%}%>