package net.ihypo.team;
import net.ihypo.db.DbDriver;

import java.sql.ResultSet;
import java.sql. Statement;
import java.sql.SQLException;

public class AddTeam{
	  public AddTeam(){
		  super();
	  }
	 public void getId(String teamName,String teamEmail,String teamTel,String teamAdd,int temp_id,String temp_name) throws ClassNotFoundException, SQLException{ 
		 
		 Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		 ResultSet  rs  =    statement.executeQuery("select *  from teams");
		 if(!rs.next()) {
			 statement.execute("insert into teams(team_id,team_name,team_email,team_tel,team_add) "
			 			+ "values ('1000','"+teamName+"','"+teamEmail+"','"+teamTel+"','"+teamAdd+"');");
			 statement.execute("insert into teamUser(teamUser_tid,teamUser_tname,teamUser_uid,teamUser_uname) "
			 			+ "values ('1000','"+teamName+"','"+temp_id+"','"+temp_name+"');");
		 }
		 else {
				ResultSet set = statement.executeQuery("select max(team_id) from teams;");
				if(set.next()){
					int ID = set.getInt("max(team_id)") + 1;
					statement.execute("insert into teams(team_id,team_name,team_email,team_tel,team_add) "
				 			+ "values ("+ID+",'"+teamName+"','"+teamEmail+"','"+teamTel+"','"+teamAdd+"');");
					 statement.execute("insert into teamUser(teamUser_tid,teamUser_tname,teamUser_uid,teamUser_uname) "
					 			+ "values ("+ID+",'"+teamName+"','"+temp_id+"','"+temp_name+"');");
				}
		 }
		 
	 }
}

