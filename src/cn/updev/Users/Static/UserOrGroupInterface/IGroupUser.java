package cn.updev.Users.Static.UserOrGroupInterface;

import cn.updev.Users.Static.EnumeRule.GroupRule;

/**
 * Created by blf2 on 15-11-24.
 */
public interface IGroupUser {
    Integer getUserId();
    Integer getGroupId();
    GroupRule getGroupMemberRule();
    boolean setGroupMemberRule(GroupRule groupMemberRule);
    boolean isCreater();
    boolean isAdmin();
    boolean isUser();
}
