package net.ihypo.work;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.ihypo.db.DbDriver;

import com.mysql.jdbc.Statement;

public class WorkFactory {
	static private int id = -1;
	
	static private int  getNextId() throws ClassNotFoundException, SQLException{
		if(id == -1){
			//调用数据库里的最新ID
			Statement statement = (Statement) new DbDriver().getConnection().createStatement();
			ResultSet set = statement.executeQuery("select max(work_id) from works;");
			
			if(set.next()){
				id = set.getInt("max(work_id)") + 1;
			}else{
				id = 1;
			}
		}
		System.out.println("id = " + id);
		return id;
	}
	
	public Work createWork(String title,int userId,String data,int rank,int workGroupId) throws ClassNotFoundException, SQLException{
		Work work =  new Work(getNextId(), title, userId, data,rank,workGroupId);
		id++;
		insertWorkList(work);
		return work;
	}
	
	private void insertWorkList(Work work) throws ClassNotFoundException, SQLException{
		//写入数据库
		Statement statement = (Statement) new DbDriver().getConnection().createStatement();
		
		statement.execute("insert into works values(" + work.getId() + ",'" + work.getTitle() + "',"
				 + work.getUserId() + "," + work.getRank() + "," + work.isFinash() + ", " + work.getGroupId() + ");");
	}
}
