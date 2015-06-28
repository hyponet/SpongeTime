<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page  import="net.ihypo.team.AddTeam" %> 
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.io.*"%>

<%
    String  teamName = new String(request.getParameter("teamName").getBytes("ISO-8859-1"),"UTF-8");
   String  teamEmail = new String(request.getParameter("teamEmail").getBytes("ISO-8859-1"),"UTF-8");
   String    teamTel = request.getParameter("teamTel");
   String  teamAdd = new String(request.getParameter("teamAdd").getBytes("ISO-8859-1"),"UTF-8");
   AddTeam zan = new AddTeam();
    zan.getId(teamName,teamEmail, teamTel,teamAdd);
%>
<script type="text/javascript">
    window.location="index.jsp";
</script>