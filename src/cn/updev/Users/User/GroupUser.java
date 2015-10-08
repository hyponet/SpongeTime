package cn.updev.Users.User;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupUser {
    private Integer userId;
    private Integer groupId;
    private Integer groupMemberRule;
    public GroupUser(Integer userId,Integer groupId,Integer groupMemberRule){
        this.userId = userId;
        this.groupId = groupId;
        this.groupMemberRule = groupMemberRule;
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

    public Integer getGroupMemberRule() {
        return groupMemberRule;
    }

    public void setGroupMemberRule(Integer groupMemberRule) {
        this.groupMemberRule = groupMemberRule;
    }
}
