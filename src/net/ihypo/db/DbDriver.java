package net.ihypo.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DbDriver {
	static private List<Connection> list;
	static private String url = "jdbc:mysql://localhost/SpongeTime";
	static private String user =  "root";
	static private String password = "password";
	static private int total = 20;
	static private int now = 0;
	
	public DbDriver() throws ClassNotFoundException, SQLException{
		if(list == null)
		{
			list = new ArrayList<Connection>();
			Class.forName("com.mysql.jdbc.Driver");
			for(int i = 0;i < total;i++){
				list.add(DriverManager.getConnection( url + 
						"?user=" + user + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8" ));
			}
		}
	}
	
	public Connection getConnection(){
		
		int rtn = now;
		now = (now + 1) % total;
		return list.get(rtn);
	}

}
