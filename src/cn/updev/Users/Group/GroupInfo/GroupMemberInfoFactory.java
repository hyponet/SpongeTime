package cn.updev.Users.Group.GroupInfo;

import cn.updev.Users.User.GroupUser;
import cn.updev.Users.User.GroupUserFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupMemberInfoFactory {
    private List <GroupUserFactory> list;
  //  public GroupMemberFactory(GroupUserFactory guf){
  //      list = new LinkedList<GroupUserFactory>();
  //      list.add(guf);
  //  }
    public boolean addGroupMemberInfo(GroupUser gu){
        return new GroupMemberInfo().addGroupMemberInfo(gu);
    }
    public boolean delGroupMemberInfo(Integer userId){
        return new GroupMemberInfo().delGroupMemberInfo(userId);
    }
    public boolean changeGroupMemberInfo(GroupUser gu){
        return new GroupMemberInfo().changeGroupMemberInfo(gu);
    }
    public boolean findGroupMemberInfo(Integer userId,Integer groupId){
        return new GroupMemberInfo().findGroupMemberInfo(userId,groupId);
    }
    public List<GroupUser> findGroupMemberInfoAll(){
        return new GroupMemberInfo().findGroupMemberInfoAll();
    }
}
