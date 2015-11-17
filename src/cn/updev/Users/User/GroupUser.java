package cn.updev.Users.User;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupUser {
    private Integer userId;
    private Integer groupId;
    private Integer groupMemberRule;
    GroupUser(Integer userId,Integer groupId,Integer groupMemberRule){
        this.userId = userId;
        this.groupId = groupId;
        this.groupMemberRule = groupMemberRule;
    }

    //getters
    public Integer getUserId(){
        return userId;
    }
    public Integer getGroupId(){
        return groupId;
    }
    public Integer getGroupMemberRule(){
        return groupMemberRule;
    }

    //setters
    public boolean setGroupMemberRule(Integer groupMemberRule){
        //接口留给修改某个人在群组中的权限
        //更新这个人的权限值
        return true;
    }
}
