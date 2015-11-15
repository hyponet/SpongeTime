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
        if(true) {//如果用户名存在
            this.userId = userId;
        }else{
            this.userId = 0;
        }
    }

    private void setGroupId(Integer groupId){
        if(true){//如果这个组存在
            this.groupId = groupId;
        }else{
            this.groupId = 0;
        }
    }
    private void setGroupMemberRule(Integer groupMemberRule){
        if(groupMemberRule > 0 && groupMemberRule < 4){
            this.groupMemberRule = groupMemberRule;
        }else{
            this.groupMemberRule = 0;
        }
    }

    public GroupUser getGroupUser(){
        if(this.userId == 0 || this.groupId < 0 || this.groupMemberRule == 0)//如果出现不合法的情况，返回null
            return null;
        return new GroupUser(userId,groupId,groupMemberRule);
    }

    public Integer createGroup(String groupName,String groupIntro){
            GroupInfoFactory gif = new GroupInfoFactory(groupName,groupIntro,this.userId);
            if(this.userId == 0 || this.groupId < 0 || this.groupMemberRule == 0 || gif == null)
                return null;//如果出现不合法，返回null
            this.groupId = 0;//数据库持久化，并得到groupId
            this.groupMemberRule = 1;
            return new Integer(groupId);
    }
}
