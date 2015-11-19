package cn.updev.Users.Group.GroupInfo;

import cn.updev.Users.User.GroupUserFactory;

import java.net.Inet4Address;
import java.util.Iterator;

/**
 * Created by blf2 on 15-9-29.
 */
public class GroupInfoFactory {
    private Integer groupId;
    private String groupName;
    private String groupIntro;
    private Integer userId;//userId为创建者Id

    public GroupInfoFactory(Integer groupId,String groupName,String groupIntro,Integer userId){
        this.setGroupId(groupId);
        this.setGroupName(groupName);
        this.setGroupIntro(groupIntro);
        this.setUserId(userId);
    }

    private void setGroupId(Integer groupId){
        this.groupId = groupId;
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
    private void setUserId(int userId){
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }

    public Integer createGroup(){
        //把数据存入数据库
        groupId = 0;//获得groupId
        GroupUserFactory guf = new GroupUserFactory(userId,groupId,1);
        //把创建者信息更新到数据库
        return groupId;
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
