package net.ihypo.user;

import java.util.ArrayList;
import java.util.List;

public class UserGroup {
	private List<User> list;
	private int total;
	
	public UserGroup(){
		this.list = new ArrayList<User>();
		this.total = 0;
	}
	
	public boolean addUser(int id,String name,String email){
		return list.add(new User(id, name, email));
	}
	
	public User getUser(int id){
		int index = list.indexOf(new User(id));
		if(index >= 0){
			return list.get(index);
		}
		return null;
	}
	
	public List<User> getList() {
		return list;
	}

	public int getTotal() {
		return total;
	}
	
}
