package cn.updev.Users.User;

/**
 * Created by hypo on 15-12-4.
 */
public class GroupUserInfo {

    private Integer userId;
    private Integer groupId;
    private String groupName;
    private String userName;
    private String userEmail;
    private Integer userTask;
    private String userRule;

    public GroupUserInfo(Integer groupId, String groupName, String userEmail, Integer userId, String userName, String userRule, Integer userTask) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.userEmail = userEmail;
        this.userId = userId;
        this.userName = userName;
        this.userRule = userRule;
        this.userTask = userTask;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRule() {
        return userRule;
    }

    public void setUserRule(String userRule) {
        this.userRule = userRule;
    }

    public Integer getUserTask() {
        return userTask;
    }

    public void setUserTask(Integer userTask) {
        this.userTask = userTask;
    }
}
