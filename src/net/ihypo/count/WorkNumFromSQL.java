package net.ihypo.count;

import net.ihypo.db.DbDriver;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class WorkNumFromSQL {
	public double getRate(int userId)throws SQLException,ClassNotFoundException{
		Statement state = new DbDriver().getConnection().createStatement();
		ResultSet resultSet = state.executeQuery("select count('work_id') num from works where work_user_id = " + userId + ";");
		int total = 1;
		int sum = 0;
		if(resultSet.next()){
			total = resultSet.getInt("num");
		}
		ResultSet set = state.executeQuery("select count('work_id') num from works where work_finash=true and work_user_id = " + userId + ";");
		if(set.next()){
			sum = set.getInt("num");
		}
		return ((double)sum) /total;
	}
}
