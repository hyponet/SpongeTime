package net.ihypo.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.ihypo.user.User;

import com.mysql.jdbc.Statement;

public class UserDb {
	
	private boolean getUser(String email,String psw) throws ClassNotFoundException, SQLException{
		
		Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		ResultSet set = statement.executeQuery("select user_pwd from users where user_email = " + email + ";");
		
		if(set.next()){
			String password = set.getString("user_pwd");
			set = statement.executeQuery("select PASSWORD(" + psw + ") pwd;");
			set.next();
			psw = set.getString("psw");
			if(psw == password){
				return true;
			}
		}
		return false;
	}
	
	public User judgeLogin(String email,String pwd) throws SQLException, ClassNotFoundException{
		if(getUser(email, pwd)){
			Statement statement = (Statement) new DbDriver().getConnection().createStatement();
			ResultSet set = statement.executeQuery("select user_id,user_name,user_email"
					+ " from users where user_email = " + email + ";");
			set.next();
			int id = set.getInt("user_id");
			User user = new User(id, set.getString("user_name"), set.getString("user_email"));
			
			return user; 
		}
		
		return null;
	}
}
