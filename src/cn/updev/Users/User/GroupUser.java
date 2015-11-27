package cn.updev.Users.User;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Users.Static.EnumeRule.GroupRule;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupUser;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupUser implements IGroupUser{
    private Integer groupUserId;//为数据库而生，是数据库的主键
    private Integer userId;
    private Integer groupId;
    private GroupRule groupMemberRule;
    public GroupUser(Integer userId,Integer groupId,GroupRule groupMemberRule){
        this.userId = userId;
        this.groupId = groupId;
        this.groupMemberRule = groupMemberRule;
    }

    public GroupUser() {
    }

    //getters and setters


    public Integer getGroupUserId() {
        return groupUserId;
    }

    public void setGroupUserId(Integer groupUserId) {
        this.groupUserId = groupUserId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public GroupRule getGroupMemberRule() {
       return groupMemberRule;
    }

    public boolean setGroupMemberRule(GroupRule groupMemberRule){
        if(groupMemberRule.isCreater() || groupMemberRule.isAdmin() || groupMemberRule.isUser()) {
            this.groupMemberRule = groupMemberRule;
            return true;
        }
        return false;
    }

    public boolean isCreater(){
        return groupMemberRule.isCreater();
    }

    public boolean isAdmin(){
        return groupMemberRule.isAdmin();
    }

    public boolean isUser(){
        return groupMemberRule.isUser();
    }

}
