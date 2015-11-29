package cn.updev.Users.Group.GroupInfo;

import cn.updev.Users.Static.EnumeRule.InviteStatus;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupMemberInviteInfo;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupMemberInviteInfo implements IGroupMemberInviteInfo{
    private Integer inviteInfoId;//位数据库专门设计，没有实际意义
    private Integer groupId;
    private Integer inviterId;
    private Integer inviteeId;
    private InviteStatus inviteStatus;

    /*statusNum说明：inviteUser　表示未处理邀请，应该推送给被邀请者
                inviteeAgree　表示被邀请者同意，应该推送给管理员或创建者
                inviteeDeny　表示被邀请人拒绝接受邀请，推送给邀请者
                inviteOutTime　表示邀请消息超期

                adminAgree　表示管理员或创建者已经同意，推送给邀请者，被邀请者，各位管理员，创建者
                adminDeny　表示管理员或创建者决绝此邀请　推送给邀请者，被邀请者，各位管理员，创建者
 */

    public GroupMemberInviteInfo(Integer groupId,Integer inviterId,Integer inviteeId,InviteStatus inviteStatus){
        this.groupId = groupId;
        this.inviterId = inviterId;
        this.inviteeId = inviteeId;
        this.inviteStatus = inviteStatus;
    }

    public Integer getInviteInfoId() {
        return inviteInfoId;
    }

    public void setInviteInfoId(Integer inviteInfoId) {
        this.inviteInfoId = inviteInfoId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getInviterId() {
        return inviterId;
    }

    public void setInviterId(Integer inviterId) {
        this.inviterId = inviterId;
    }

    public Integer getInviteeId() {
        return inviteeId;
    }

    public void setInviteeId(Integer inviteeId) {
        this.inviteeId = inviteeId;
    }

    public InviteStatus getInviteStatus() {
        return inviteStatus;
    }



    public boolean isInviteUser(){
        if(this.inviteStatus == InviteStatus.inviteUser)
            return true;
        return false;
    }

    public boolean isInviteAgree(){
        if(this.inviteStatus == InviteStatus.adminAgree)
            return true;
        return false;
    }

    public boolean isInviteOutTime(){
        if(this.inviteStatus == InviteStatus.inviteOutTime)
            return true;
        return false;
    }

    public boolean isAdminAgree(){
        if(this.inviteStatus == InviteStatus.adminAgree)
            return true;
        return false;
    }

    public boolean isAdminDeny(){
        if(this.inviteStatus == InviteStatus.adminDeny)
            return true;
        return false;
    }


    public void setInviteStatus(InviteStatus inviteStatus) {
        this.inviteStatus = inviteStatus;
    }

    public GroupMemberInviteInfo(){}
    public boolean saveGroupMemberInviteInfo(){

        return true;
    }
    public boolean deleteGroupMemberInviteInfo(){
        //数据库持久化
        return true;
    }
    public boolean saveGroupUserInfo(Integer inviteeId){
        //从数据库中获得inviteeId的信息，然后存储
        return true;
    }
}
