package cn.updev.Users.Group.GroupMemberRule;

/**
 * Created by blf2 on 15-10-8.
 */
public class AdminRule extends PrimaryUserRule {
    publuc boolean removeGroupMember(Integer userId){
        //数据库持久化
        return true;
    }
    public boolean changeGroupInfo(Integer groupId){
        //数据库持久化
        return true;
    }
}
