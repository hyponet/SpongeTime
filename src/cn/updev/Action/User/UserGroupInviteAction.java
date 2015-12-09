package cn.updev.Action.User;

import cn.updev.Users.Group.GroupInfo.GroupMemberInviteInfo;
import cn.updev.Users.Group.GroupInfo.GroupMemberInviteInfoSender;
import cn.updev.Users.NotificationPush.NotificationInfo;
import cn.updev.Users.NotificationPush.NotificationSender;
import cn.updev.Users.Static.EnumeRule.InviteStatus;
import cn.updev.Users.Static.EnumeRule.NotificationType;
import cn.updev.Users.Static.FuctionClass.Login;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupQuery;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupUser;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hypo on 15-12-4.
 */
public class UserGroupInviteAction extends ActionSupport{

    /**
     * userInfo : 在团队邀请新成员时作为新成员的信息查询
     *            既可以是用户邮箱，也可以是用户名
     */
    private String userInfo;
    private Integer groupId;

    /**
     * inviteId : 邀请信息的ID
     * rnt      : 邀请信息的用户反馈
     *   |
     *   --- AGREE    : 同意
     *   |
     *   --- DISAGREE : 拒绝
     */

    private Integer inviteId;
    private String rnt;

    public String inviteNewUser(){

        Login login = new Login();

        if(login.isNotLogined()){
            return LOGIN;
        }

        if(groupId < 1){

            return ERROR;
        }

        if(userInfo == null || userInfo.trim().length() == 0){

            return SUCCESS;
        }

        IUser user = login.getLoginedUser();

        UserOrGroupQuery DAO = new UserOrGroupQuery();

        // 获得被邀请的成员
        IUser invitee = DAO.queryUserByName(userInfo);
        if(invitee == null){
            invitee = DAO.queryUserByEMail(userInfo);
        }
        if(invitee == null){
            String err = "用户 " + userInfo + " 不存在，请核实！";
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("error", err);
            return SUCCESS;
        }

        // 判断被邀请的成员是否在用户组中
        IGroupUser groupUser = DAO.queryGroupUser(invitee.getUserId(), groupId);

        if(groupUser != null){
            return SUCCESS;
        }

        // 保存邀请请求
        saveInvite(this.groupId, user.getUserId(), invitee.getUserId());

        // 发送邀请信息
        invite(invitee);

        return SUCCESS;
    }

    public String updateInfo(){

        Login login = new Login();

        if(login.isNotLogined()){
            return LOGIN;
        }

        if(this.rnt == null || this.inviteId == null){
            return ERROR;
        }

        UserOrGroupQuery DAO = new UserOrGroupQuery();
        GroupMemberInviteInfo inviteInfo = null;

        if(this.rnt.equals("AGREE")){

            inviteInfo.setInviteStatus(InviteStatus.inviteeAgree);
        }else if(this.rnt.equals("DISAGREE")) {

            inviteInfo.setInviteStatus(InviteStatus.inviteFinish);
        }else {
            return ERROR;
        }

        GroupMemberInviteInfoSender sender = new GroupMemberInviteInfoSender(inviteInfo);
        sender.updateGroupMemberInviteInfo();

        return SUCCESS;
    }

    private void invite(IUser touser){

        Login login = new Login();

        IUser user = login.getLoginedUser();

        NotificationInfo notificationInfo = new NotificationInfo();

        notificationInfo.setNotificationCreaterId(user.getUserId());
        notificationInfo.setTitle("邀请标题");
        notificationInfo.setNotifucationBody("邀请内容");
        notificationInfo.setType(NotificationType.userGroup);

        notificationInfo.setNotificationAccepterId(touser.getUserId());
        NotificationSender sender = new NotificationSender(notificationInfo);
        sender.NotificationSendToUser();

    }

    private void saveInvite(Integer groupId, Integer inviterId, Integer inviteeId){

        GroupMemberInviteInfo inviteInfo = new GroupMemberInviteInfo();

        inviteInfo.setGroupId(groupId);
        inviteInfo.setInviterId(inviterId);
        inviteInfo.setInviteeId(inviteeId);
        inviteInfo.setInviteStatus(InviteStatus.invite);

        GroupMemberInviteInfoSender sender = new GroupMemberInviteInfoSender(inviteInfo);
        sender.saveGroupMemberInviteInfo();

    }


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
