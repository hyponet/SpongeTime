<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page  import="net.ihypo.team.ManageTeam" %> 
<%@page import="net.ihypo.user.User"%>

<%
	User user = (User)session.getAttribute("user");
	int temp_uid=user. getId();
   String temp_uname=user.getName();
   
   String temp = new String(request.getParameter("teamPsw").getBytes("ISO-8859-1"),"UTF-8");
   int team_tid=Integer.parseInt(temp);
   
   ManageTeam zan = new ManageTeam();
   boolean Flag= zan.getTeam(team_tid, temp_uid,temp_uname);
   if(Flag == false){
%>   
<script type="text/javascript">
     alert("不存在这个团队");
    window.location="index.jsp";
</script>   
<% 
   }
 %>
<script type="text/javascript">
      alert("加入成功");
    window.location="index.jsp";
</script>