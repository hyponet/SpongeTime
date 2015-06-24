package net.ihypo.work;

public class WorkFactory {
	static private int id = -1;
	
	static private int  getNextId(){
		if(id == -1){
			//调用数据库里的最新ID
			id = 1;
		}
		
		return id;
	}
	
	static public Work createWork(String title,int userId,String data,int rank){
		Work work =  new Work(getNextId(), title, userId, data,rank);
		id++;
		
		//写入数据库
		insertWorkList(work);
		
		return work;
	}
	
	static private void insertWorkList(Work work){
		//写入数据库
	}
}
