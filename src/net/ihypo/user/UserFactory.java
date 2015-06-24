package net.ihypo.user;

public class UserFactory {
	static private int id = -1;
	
	@SuppressWarnings("unused")
	static private int  getId(){
		if(id == -1){
			//在数据库获取最新的ID
			id = 1;
		}
		return id;
	}
	
	static public User createUser(String name,String email){
		User user = new User(id, name, email);
		id++;
		insertUser(user);
		return user;
	}
	
	static public void insertUser(User user){
		//新建用户到数据库
	}
}
