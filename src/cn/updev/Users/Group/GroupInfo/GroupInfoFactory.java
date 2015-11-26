package cn.updev.Users.Group.GroupInfo;

import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupQuery;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupInfo;

/**
 * Created by blf2 on 15-9-29.
 */
public class GroupInfoFactory {
    private Integer groupId;
    private String groupName;
    private String groupIntro;

    public GroupInfoFactory(String groupName,String groupIntro){
        this.setGroupName(groupName);
        this.setGroupIntro(groupIntro);
    }

    private void setGroupName(String groupName){
        if(groupName.length() > 20)
            groupName = groupName.substring(20);
        this.groupName = groupName;
    }
    private void setGroupIntro(String groupIntro){
        if(groupIntro.length() > 100)
            groupIntro = groupIntro.substring(100);
        this.groupIntro = groupIntro;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupIntro() {
        return groupIntro;
    }


    public IGroupInfo saveGroup(){
        IGroupInfo iGroupInfo = null;
        if(new UserOrGroupQuery().queryGroupInfoByName(this.groupName) == null)
            iGroupInfo = new GroupInfo(this.groupName,this.groupIntro).saveGroupInfo();
        return iGroupInfo;
    }
    public boolean updateGroup(){
        //数据库持久化更新用户组信息
        return true;
    }
    public boolean dismissGroup(){
        //删除groupId群组信息
        //删除groupId群组成员
        return true;
    }
}
