package cn.updev.Users.Static.UserOrGroupInterface;

import cn.updev.Users.Group.GroupInfo.GroupInfo;

/**
 * Created by blf2 on 15-11-24.
 */
public interface IGroupInfo {
    Integer getGroupId();
    String getGroupName();
    String getGroupIntro();
    void setGroupName(String groupName);
    void setGroupIntro(String groupIntro);
    GroupInfo saveGroupInfo();
}
