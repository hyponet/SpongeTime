package net.ihypo.work;

import java.util.ArrayList;
import java.util.List;

public class WorkGroup {
	private List<Work> list;
	private int total;
	private int userId;
	
	public WorkGroup(int userId){
		list = new ArrayList<Work>();
		total = 0;
		this.userId = userId;
	}
	
	public void addWork(String title,int userId,String data){
		list.add(WorkFactory.createWork(title, userId, data));
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
