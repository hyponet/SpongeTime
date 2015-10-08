package cn.updev.Users.Group.GroupMemberRule;

/**
 * Created by blf2 on 15-10-8.
 */
public class RootRule {
    public boolean dismissGroup(Integer groupId){
        //数据库持久化
        return true;
    }
    public boolean appointAdmin(Integer groupId,Integer userId){
        //数据库持久化
        return true;
    }
}
