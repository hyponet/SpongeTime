<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page  import="net.ihypo.team.AddTeam" %> 
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.io.*"%>

<%
    String  teamName = request.getParameter("teamName");
   String  teamEmail = request.getParameter("teamEmail");
   String    teamTel = request.getParameter("teamTel");
   String  teamAdd = request.getParameter("teamAdd");
   AddTeam zan = new AddTeam();
    zan.getId(teamName,teamEmail, teamTel,teamAdd);
%>