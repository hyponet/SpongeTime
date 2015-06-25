<%@page import="net.ihypo.user.User"%>
<%@page import="net.ihypo.db.UserDb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String email = request.getParameter("email");
	String pwd = request.getParameter("password");
	out.println("get email:" + email + " password:" + pwd);
	User user = new UserDb().judgeLogin(email, pwd);
	if(user == null){
%>
123
<%}else{%>
456
<%}%>