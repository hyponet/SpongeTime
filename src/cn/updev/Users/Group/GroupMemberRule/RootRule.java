package cn.updev.Users.Group.GroupMemberRule;

import cn.updev.Users.Group.GroupInfo.GroupMemberInfoFactory;
import cn.updev.Users.User.GroupUser;

/**
 * Created by blf2 on 15-10-8.
 */
public class RootRule {
    public boolean dismissGroup(Integer groupId){
        //如果这个groupId存在并且在这个团队里这个人是创建者的身份时
        return true;
    }
    public boolean appointAdmin(Integer groupId,Integer userId){
        return new GroupMemberInfoFactory().changeGroupMemberInfo(new GroupUser(userId,groupId,2));
    }
}
