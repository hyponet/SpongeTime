package cn.updev.Users.Group.GroupInfo;

import cn.updev.Users.User.GroupUser;
import cn.updev.Users.User.GroupUserFactory;

/**
 * Created by blf2 on 15-9-29.
 */
public class GroupInfo {
    private Integer groupId;
    private String groupName;
    private String groupIntro;
    private GroupUser groupcreater;
    public GroupInfo(Integer groupId, String groupName, String groupIntro,Integer userId) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupIntro = groupIntro;
        groupcreater = new GroupUserFactory(userId,groupId,1).getGroupUser();//第一个参数是创建者的userId
        GroupMemberInfo gmi = new GroupMemberInfo(groupcreater);
    }
    public GroupInfo(){}
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupIntro() {
        return groupIntro;
    }

    public void setGroupIntro(String groupIntro) {
        this.groupIntro = groupIntro;
    }
    public boolean updateGroupInfo(){
        //数据库更新,只更新团队介绍
        return true;
    }
    public boolean dismissGroup(){
        //删除groupId的团队记录
        return new GroupMemberInfoFactory().delGroupMemberInfo(groupId);
    }
}
