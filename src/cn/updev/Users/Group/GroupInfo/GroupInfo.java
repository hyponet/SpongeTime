package cn.updev.Users.Group.GroupInfo;

/**
 * Created by blf2 on 15-9-29.
 */
public class GroupInfo {
    private Integer groupId;
    private String groupName;
    private String groupIntro;

    public GroupInfo(Integer groupId, String groupName, String groupIntro) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupIntro = groupIntro;
    }

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
}
