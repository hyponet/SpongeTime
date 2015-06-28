package net.ihypo.team;
import net.ihypo.db.DbDriver;

import java.sql.ResultSet;
import java.sql. Statement;
import java.sql.SQLException;

public class AddTeam{
	  public AddTeam(){
		  super();
	  }
	 public void getId(String teamName,String teamEmail,String teamTel,String teamAdd) throws ClassNotFoundException, SQLException{ 
		 Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		 ResultSet  rs  =    statement.executeQuery("select *  from teams");
		 boolean flag = false;
		 String str="1000";
		 if(rs.next())
		 {
		 	 str =  rs.getString("teams_id");
		 	System.out. println("sdhuaaaaaaaaaaaaaaaaaaa");
		 	 flag = true;
		 }
			
		 if(!rs.next()){
		    str = rs.getString("teams_id");
		 }
		 if(flag==true){
		 	 long ID = Long.parseLong(str);
		 	 ID++;
		 	str =  Long.toString(ID); 
		 	statement.execute("insert into teams(teams_id,teams_name,teams_email,teams_Tel,teams_Add) values ("+str+",'"+teamName+"','"+teamEmail+"','"+teamTel+"','"+teamAdd+"');");
		 }
		 else{
		 	 statement.execute("insert into teams(teams_id,teams_name,teams_email,teams_Tel,teams_Add) values ("+str+",'"+teamName+"','"+teamEmail+"','"+teamTel+"','"+teamAdd+"');");
		 	// out.println("insert into teams(teams_id,teams_name,teams_email,teams_Tel,teams_Add) values ("+str+",'"+teamName+",'"+teamEmail+",'"+teamTel+",'"+teamAdd+"');");
		 }
		 
	 }
	/* public static void main(String[] args) throws Exception {
		AddTeam temp  = new AddTeam();
		temp.getId("1222","aaa","sss","saaa");
		}*/
	
}

