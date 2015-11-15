package cn.updev.Users.User;

import cn.updev.Users.Group.GroupInfo.GroupInfoFactory;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupUserFactory {
    private Integer userId;
    private Integer groupId;
    private Integer groupMemberRule;

    public GroupUserFactory(Integer userId,Integer groupId,Integer groupMemberRule){
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
    private void setGroupMemberRule(Integer groupMemberRule){
        this.groupMemberRule = groupMemberRule;
    }

    public GroupUser getGroupUser(){
        return new GroupUser(userId,groupId,groupMemberRule);
    }

    public Integer createGroup(String groupName,String groupIntro){
            GroupInfoFactory gif = new GroupInfoFactory(groupName,groupIntro,this.userId);
            this.groupId = 0;//数据库持久化，并得到groupId
            this.groupMemberRule = 1;
            return new Integer(groupId);
    }
}
