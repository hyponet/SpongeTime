package cn.updev.Users.User;

import cn.updev.Users.Static.EnumeRule.GroupRule;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupUser;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupUserFactory {
    private Integer userId;
    private Integer groupId;
    private GroupRule groupMemberRule;

    public GroupUserFactory(Integer userId,Integer groupId,GroupRule groupMemberRule){
        this.setUserId(userId);
        this.setGroupId(groupId);
        this.setGroupMemberRule(groupMemberRule);
    }
    private void setUserId(Integer userId){
      this.userId = userId;
    }

    private void setGroupId(Integer groupId){
            this.groupId = groupId;

    }
    private void setGroupMemberRule(GroupRule groupMemberRule){
        if(groupMemberRule.isCreater() || groupMemberRule.isAdmin() || groupMemberRule.isUser())
            this.groupMemberRule = groupMemberRule;
        else
            this.groupMemberRule = null;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupRule getGroupMemberRule() {
        return groupMemberRule;
    }

    public IGroupUser getGroupUser(){
        if(userId == null || groupId == null || groupMemberRule == null)
            return null;
        IGroupUser groupUser = new GroupUser(userId,groupId,groupMemberRule);
        return groupUser;
    }

}
