package cn.updev.Users.Group.GroupInfo;

import cn.updev.Users.Static.EnumeRule.InviteStatus;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupMemberInviteInfoFactory {
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
    public GroupMemberInviteInfoFactory(Integer groupId,Integer inviterId,Integer inviteeId){
        this.setGroupId(groupId);
        this.setInviteeId(inviteeId);
        this.setInviterId(inviterId);
    }
    private void setGroupId(Integer groupId){
        //如果存在groupId
        this.groupId = groupId;
        //否则
        //this.groupId = null;
    }
    private void setInviterId(Integer inviterId){
        //如果存在inviterId
        this.inviterId = inviterId;
        //否则
        //this.inviterId = null;
    }
    private void setInviteeId(Integer inviteeId){
        //如果存在inviteeId并且不在这个团队中
        this.inviteeId = inviteeId;
        //否则
        //this.inviteeId = null;
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
    public boolean saveGroupMemberInviteInfo(){
        if(this.groupId == null || this.inviterId == null || this.inviteeId == null || this.inviteStatus == null)
            return false;
        return new GroupMemberInviteInfo().saveGroupMemberInviteInfo();
    }
    public boolean deleteGroupMemberInviteInfo(){
        return new GroupMemberInviteInfo().deleteGroupMemberInviteInfo();
    }
    public boolean saveGroupUserInfo(Integer inviteeId){//管理员同意后把被邀请人加入到数据库
        return new GroupMemberInviteInfo().saveGroupUserInfo(inviteeId);
    }
}
