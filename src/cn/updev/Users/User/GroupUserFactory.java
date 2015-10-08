package cn.updev.Users.User;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupUserFactory {
    private Integer userId;
    private Integer groupId;
    private Integer groupMemberRule;
    public GroupUserFactory(Integer userId,Integer groupId,Integer groupMemberRule){
        this.userId = userId;
        this.groupId = groupId;
        this.groupMemberRule = groupMemberRule;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public Integer getGroupMemberRule() {
        return groupMemberRule;
    }
    public GroupUser getGroupUser(){
        //如果userId和groupId存在并且groupRule值合法,数据持久化
        GroupUser gu = new GroupUser(this.userId,this.groupId,this.groupMemberRule);

        return gu;
    }
}
