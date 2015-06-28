package net.ihypo.work;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.ihypo.db.DbDriver;

import com.mysql.jdbc.Statement;

public class WorkGroup {
	private int id;
	private List<Work> list;
	private String title;
	private int rank;
	private int userId;
	private int total;
	
	public WorkGroup(int userId) throws ClassNotFoundException, SQLException{
		list = new ArrayList<Work>();
		total = 0;
		this.userId = userId;
		Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		ResultSet set = statement.executeQuery("select max(task_id) id from tasks;");
		set.next();
		id = set.getInt("id") + 1;
	}
	
	public WorkGroup(int userId,int taskId) throws ClassNotFoundException, SQLException{
		id = taskId;
		list = new ArrayList<Work>();
		total = 0;
		this.userId = userId;
		Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		ResultSet set = statement.executeQuery("select * from tasks "
				+ "where task_id = " + taskId + ";");
		if(set.next()){
			title = set.getString("task_title");
			rank = set.getInt("task_rank");
			statement = (Statement) new DbDriver().getConnection().createStatement();
			set = statement.executeQuery("select * from works "
					+ "where work_user_id = " + userId + " and work_group_id = " + taskId + ";");
			
			while(set.next()){
				Work work = new Work(set.getInt("work_id"),set.getString("work_title"),
						set.getInt("work_user_id"),null, set.getInt("work_rank"),taskId);
				if(set.getBoolean("work_finash"))
					work.finash();
				else {
					total++;
				}
				list.add(work);
			}
		}
	}
	
	public List<Work> getUserAll() throws ClassNotFoundException, SQLException{
		list.clear();
		total = 0;
		Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		ResultSet set = statement.executeQuery("select * from works where work_user_id = " + userId + ";");
		while(set.next()){
			Work work = new Work(set.getInt("work_id"),set.getString("work_title"),
					set.getInt("work_user_id"),null, set.getInt("work_rank"),set.getInt("work_group_id"));
			if(set.getBoolean("work_finash"))
				work.finash();
			else {
				total++;
			}
			list.add(work);
		}
		return list;
	}
	
	public void addWork(String title,int userId,String data,int rank) throws ClassNotFoundException, SQLException{
		list.add(new WorkFactory().createWork(title, userId, data,rank,id));
		total++;
	}
	
	public Work getWork(int id) throws ClassNotFoundException, SQLException{
		int index = list.indexOf(new Work(id));
		if(index >= 0){
			return list.get(index);
		}
		return null;
	}
	
	public int getId(){
		return this.id;
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
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public int getRank(){
		return this.rank;
	}
	public void setRank(int rank){
		this.rank = rank;
	}
	
	public String getTitle(){
		return this.title;
	}
	public void insert() throws ClassNotFoundException, SQLException{
		Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		ResultSet set = statement.executeQuery("select max(task_id) id from tasks;");
		if(set.next()){
			this.id = set.getInt("id") + 1;
		}else{
			this.id = 1;
		}
		
		statement.execute("insert into tasks values("
				+ id + ",'"+ title + "'," + rank + "," + userId + "," + total + ");");
	}
	
	public void update() throws ClassNotFoundException, SQLException{
		Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		statement.execute("update tasks set task_title = '"
				+ title + "',task_rank = " + rank + ", task_user_id = " + userId + ",task_unfinash = " + total
				+ " where task_id = " + id + ";");
	}
	
	public void drop() throws ClassNotFoundException, SQLException{
		if(id != 0 && userId != 0){
			Statement statement = (Statement) new DbDriver().getConnection().createStatement();
			statement.execute("delete from works where work_group_id = " + id + ";");
			statement.execute("delete from tasks where task_id = " + id + ";");
		}
	}
}
