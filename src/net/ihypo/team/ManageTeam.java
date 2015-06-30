package net.ihypo.team;
import net.ihypo.db.DbDriver;

import java.sql.ResultSet;
import java.sql. Statement;
import java.sql.SQLException;

public class ManageTeam
{
	  public ManageTeam(){
		  super();
	  }
	  
	 public void getId(String teamName,String teamEmail,String teamTel,String teamAdd,int temp_id,String temp_name) throws ClassNotFoundException, SQLException{ 
		 
		 Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		 ResultSet  rs  =    statement.executeQuery("select *  from teams");
		 if(!rs.next()) {
			 statement.execute("insert into teams(team_id,team_name,team_email,team_tel,team_add) "
			 			+ "values ('1000','"+teamName+"','"+teamEmail+"','"+teamTel+"','"+teamAdd+"');");
			 statement.execute("insert into teamUser(teamUser_tid,teamUser_tname,teamUser_uid,teamUser_uname,teamUser_host) "
			 			+ "values ('1000','"+teamName+"','"+temp_id+"','"+temp_name+"','"+temp_name+"');");
		 }
		 else {
				ResultSet set = statement.executeQuery("select max(team_id) from teams;");
				if(set.next()){
					int ID = set.getInt("max(team_id)") + 1;
					statement.execute("insert into teams(team_id,team_name,team_email,team_tel,team_add) "
				 			+ "values ("+ID+",'"+teamName+"','"+teamEmail+"','"+teamTel+"','"+teamAdd+"');");
					 statement.execute("insert into teamUser(teamUser_tid,teamUser_tname,teamUser_uid,teamUser_uname,teamUser_host) "
					 			+ "values ("+ID+",'"+teamName+"','"+temp_id+"','"+temp_name+"','"+temp_name+"');");
				}
		 }
	 }
	 
	  public boolean getTeam(int Team_tid,int Temp_uid,String Temp_uname) throws ClassNotFoundException, SQLException{ 
			 
			 Statement statement = (Statement) new DbDriver().getConnection().createStatement();
			 ResultSet  rs  =    statement.executeQuery("select teamUser_tid from teamUser where teamUser_tid="+Team_tid+";");
			 
			 if(!rs.next()) {
				return false;
			 }
			 else {
				   String Zan_name;
				   String Zan_host;
				     ResultSet  Temp  =    statement.executeQuery("select *  from teamUser where teamUser_tid="+Team_tid+";");
				     if(Temp.next()){
				    	 Zan_name  = Temp.getString("teamUser_tname");
				    	 Zan_host  = Temp.getString("teamUser_host");
				    		statement.execute("insert into teamUser(teamUser_tid,teamUser_tname,teamUser_uid,teamUser_uname,teamUser_host) "
						 			+ "values ("+Team_tid+",'"+Zan_name+"','"+Temp_uid+"','"+Temp_uname+"','"+Zan_host+"');");
				     }
				    return true;
				}
		 }
}
     