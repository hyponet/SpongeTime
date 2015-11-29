package cn.updev.Users.Group.GroupInfo;

import java.util.LinkedList;
import java.util.List;

import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupQuery;
import cn.updev.Users.User.GroupUser;

/**
 * Created by blf2 on 15-10-8.
 */

public class GroupMemberInfo {
    private List <GroupUser> list = new LinkedList<GroupUser>();

    public GroupMemberInfo(){}

    public List<GroupUser> findGroupMemberInfoAll(Integer groupId){
        list = new UserOrGroupQuery().queryGroupMemberInfoAll(groupId);
        return list;
    }
}
