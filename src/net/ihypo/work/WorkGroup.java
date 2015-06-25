package net.ihypo.work;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.ihypo.db.DbDriver;

import com.mysql.jdbc.Statement;

public class WorkGroup {
	private List<Work> list;
	private int total;
	private int userId;
	
	public WorkGroup(int userId){
		list = new ArrayList<Work>();
		total = 0;
		this.userId = userId;
	}
	
	public List<Work> getUserAll() throws ClassNotFoundException, SQLException{
		list.clear();
		Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		ResultSet set = statement.executeQuery("select * from works where work_user_id = " + userId + ";");
		while(set.next()){
			list.add(new Work(set.getInt("work_id"),set.getString("work_title"),
					set.getInt("work_user_id"),null, set.getInt("work_rank")));
		}
		return list;
	}
	
	public void addWork(String title,int userId,String data,int rank) throws ClassNotFoundException, SQLException{
		list.add(new WorkFactory().createWork(title, userId, data,rank));
	}
	
	public Work getWork(int id){
		int index = list.indexOf(new Work(id));
		if(index >= 0){
			return list.get(index);
		}
		return null;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Work> getList() {
		return list;
	}

	public int getUserId() {
		return userId;
	}
	
	
}
