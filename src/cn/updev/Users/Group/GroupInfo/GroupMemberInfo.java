package cn.updev.Users.Group.GroupInfo;

import java.util.LinkedList;
import java.util.List;
import cn.updev.Users.User.GroupUser;

/**
 * Created by blf2 on 15-10-8.
 */

public class GroupMemberInfo {
    private List <GroupUser> list;
    public GroupMemberInfo(){}
    public GroupMemberInfo(GroupUser gu){//必须有创建者填进来，否这构不成一个团队
        list = new LinkedList<GroupUser>();
        list.add(gu);
        //数据持久化
    }
    public boolean addGroupMemberInfo(GroupUser gu){
        //数据持久化
        return true;
    }

    public boolean delGroupMemberInfo(Integer userId){
        //数据库持久化
        return true;
    }
    public boolean changeGroupMemberInfo(GroupUser gu){
        //数据库持久化
        return true;
    }
    public boolean findGroupMemberInfo(Integer userId,Integer groupId){
        //数据库持久化
        return true;
    }
    public List<GroupUser> findGroupMemberInfoAll(){
        //读取全部团队队员信息
        //数据库持久化
        return list;
    }
}
