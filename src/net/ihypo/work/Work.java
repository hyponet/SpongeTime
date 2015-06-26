package net.ihypo.work;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.ihypo.db.DbDriver;

import com.mysql.jdbc.Statement;

public class Work {
	private int id;
	private String title;
	private int userId = 0;
	private String data;
	//rank：1=重要且紧急 2=不重要但紧急 3=重要不紧急 4=不重要不紧急
	private int rank;
	private boolean finash;
	
	public Work(int id) throws ClassNotFoundException, SQLException{
		this.id = id;
		Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		ResultSet set = statement.executeQuery("select * from works where work_id = " + id + ";");
		if(set.next()){
			this.title = set.getString("work_title");
			this.userId = set.getInt("work_user_id");
			this.data = null;
			this.rank = set.getInt("work_rank");
			this.finash = set.getBoolean("work_finash");
		}
	}
	
	public Work(int id,String title,int userId,String data,int rank){
		this.id = id;
		this.title = title;
		this.userId = userId;
		this.data = data;
		this.rank = rank;
		this.finash = false;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getUserId() {
		return userId;
	}

	public String getData() {
		return data;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank){
		this.rank = rank;
	}
	
	public boolean isFinash() {
		return finash;
	}
	
	public void finash(){
		this.finash = true;
	}
	
	public void unFinash(){
		this.finash = false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Work other = (Work) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public void update() throws ClassNotFoundException, SQLException{
		Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		statement.execute("update works set work_title = '" + title + "',work_user_id = "
				 + userId + ",work_rank = " + rank + ", work_finash = " + finash + " where work_id = " + id + ";");
	}
}
