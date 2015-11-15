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

    public GroupInfo(Integer groupId,String groupName,String groupIntro,GroupUser groupcreater){
        this.groupId = groupId;
        this.groupName = groupName;
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

}
