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
    public void setGroupMemberRule(Integer groupMemberRule){
        this.groupMemberRule = groupMemberRule;
    }
}
