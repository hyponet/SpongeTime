package net.ihypo.task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import net.ihypo.db.DbDriver;
import net.ihypo.work.WorkGroup;

public class TaskGroup {
	private List<WorkGroup> list;
	private int userId;
	
	public TaskGroup(int userId) throws ClassNotFoundException, SQLException{
		this.userId = userId;
		list = new ArrayList<WorkGroup>();
		Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		ResultSet set = statement.executeQuery("select task_id,task_title from tasks where task_user_id = " + userId + ";");
		while(set.next()){
			int taskId = set.getInt("task_id");
			WorkGroup task = new WorkGroup(userId, taskId);
			task.setTitle(set.getString("task_title"));
			list.add(task);
		}
	}
	
	public List<WorkGroup> getList(){
		return this.list;
	}
}
