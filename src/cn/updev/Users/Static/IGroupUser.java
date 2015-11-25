package cn.updev.Users.Static;

import cn.updev.Users.Static.UserRule;

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
