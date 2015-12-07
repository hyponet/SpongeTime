package cn.updev.Users.Group.GroupInfo;

import cn.updev.Users.Static.EnumeRule.InviteStatus;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupMemberInviteInfo;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupMemberInviteInfoSender {
    private Integer groupId;
    private Integer inviterId;
    private Integer inviteeId;
    private InviteStatus inviteStatus;

    public GroupMemberInviteInfoSender(Integer groupId, Integer inviterId, Integer inviteeId){
        this.setGroupId(groupId);
        this.setInviteeId(inviteeId);
        this.setInviterId(inviterId);
    }
    private void setGroupId(Integer groupId){
        this.groupId = groupId;
    }
    private void setInviterId(Integer inviterId){
        this.inviterId = inviterId;
    }
    private void setInviteeId(Integer inviteeId){
        this.inviteeId = inviteeId;
    }
    private void setStatusNum(Integer statusNum){
        switch (statusNum){
            case 0:
            case 10:
            case 11:
            case 12:
            case 13:
            case 20:
            case 21:
            case 22:
                this.inviteStatus = inviteStatus;
                break;
            default:this.inviteStatus = null;
        }
    }
    public IGroupMemberInviteInfo saveGroupMemberInviteInfo(){
        if(this.groupId == null || this.inviterId == null || this.inviteeId == null || this.inviteStatus == null)
            return null;
        return new GroupMemberInviteInfo().saveGroupMemberInviteInfo();
    }
    public boolean deleteGroupMemberInviteInfo(){
        return new GroupMemberInviteInfo().deleteGroupMemberInviteInfo();
    }
    public boolean saveGroupUserInfo(){//管理员同意后把被邀请人加入到数据库
        return new GroupMemberInviteInfo(this.groupId,this.inviterId,this.inviteeId,InviteStatus.inviteUser).saveGroupUserInfo();
    }
}
