package net.ihypo.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbDriver {
	private Connection connection;
	private String url = "jdbc:mysql://localhost/SpongeTime";
	private String user =  "root";
	private String password = "password";
	
	public DbDriver() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection( url + 
				"?user=" + user + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8" );
	}
	
	public Connection getConnection(){
		return this.connection;
	}
}
