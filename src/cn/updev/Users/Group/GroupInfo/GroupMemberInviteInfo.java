package cn.updev.Users.Group.GroupInfo;

import cn.updev.Users.Static.EnumeRule.GroupRule;
import cn.updev.Users.Static.EnumeRule.InviteStatus;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupDelete;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupSave;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupMemberInviteInfo;
import cn.updev.Users.User.GroupUserFactory;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupMemberInviteInfo implements IGroupMemberInviteInfo{
    private Integer inviteInfoId;//位数据库专门设计，没有实际意义
    private Integer groupId;
    private Integer inviterId;
    private Integer inviteeId;
    private InviteStatus inviteStatus;

   /*
    invite:新建邀请
    inviteAgree:被邀请者同意
    inviteFinish:邀请结束
     */

    public GroupMemberInviteInfo(){}

    public GroupMemberInviteInfo(Integer groupId, Integer inviterId, Integer inviteeId, InviteStatus inviteStatus) {
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

    @Override
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public Integer getInviterId() {
        return inviterId;
    }

    public void setInviterId(Integer inviterId) {
        this.inviterId = inviterId;
    }

    @Override
    public Integer getInviteeId() {
        return inviteeId;
    }

    public void setInviteeId(Integer inviteeId) {
        this.inviteeId = inviteeId;
    }

    public InviteStatus getInviteStatus() {
        return inviteStatus;
    }

    @Override
    public void setInviteStatus(InviteStatus inviteStatus) {
        this.inviteStatus = inviteStatus;
    }

    public boolean isInvite(){
        if(this.inviteStatus.isInvite())
            return true;
        return false;
    }

    public boolean isInviteeAgree(){
        if(this.inviteStatus.isInviteeAgree())
            return true;
        return false;
    }

    public boolean isInviteFinish(){
        if(this.inviteStatus.isInviteFinish())
            return true;
        return false;
    }
}
