package net.ihypo.task;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.ihypo.db.DbDriver;

import com.mysql.jdbc.Statement;

public class TaskFactory {
	static public void finashWork(int taskId) throws ClassNotFoundException, SQLException{
		Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		System.out.println("select task_unfinash from tasks where task_id = " + taskId + ";");
		ResultSet set = statement.executeQuery("select task_unfinash from tasks where task_id = " + taskId + ";");
		if(set.next()){
			int unFinash = set.getInt("task_unfinash") - 1;
			if(unFinash < 0)
				unFinash = 0;
			System.out.println("update tasks set task_unfinash = " + unFinash + " where task_id = " + taskId + ";");
			statement.execute("update tasks set task_unfinash = " + unFinash + " where task_id = " + taskId + ";");
		}
	}
	static public void unFinashWork(int taskId) throws ClassNotFoundException, SQLException{
		Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		ResultSet set = statement.executeQuery("select task_unfinash from tasks where task_id = " + taskId + ";");
		if(set.next()){
			int unFinash = set.getInt("task_unfinash") + 1;
			if(unFinash < 0)
				unFinash = 0;
			statement.execute("update tasks set task_unfinash = " + unFinash + " where task_id = " + taskId + ";");
		}
	}
}
