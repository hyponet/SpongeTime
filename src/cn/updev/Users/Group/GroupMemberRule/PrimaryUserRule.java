package cn.updev.Users.Group.GroupMemberRule;

/**
 * Created by blf2 on 15-10-8.
 */

import cn.updev.Users.Group.GroupInfo.GroupInfo;
import cn.updev.Users.Group.GroupInfo.GroupMemberInviteInfo;

public class PrimaryUserRule {
    public boolean createGroup(GroupInfo gi){
        String name = gi.getGroupName();
        //判断是否存在这个名字的团队
        return true;
    }
    public boolean changeMyInfo(){
        //调用数据库更新函数
        return true;
    }
    public boolean inviteUser(GroupMemberInviteInfo gmii){
        //数据库持久化
        return true;
    }
}
