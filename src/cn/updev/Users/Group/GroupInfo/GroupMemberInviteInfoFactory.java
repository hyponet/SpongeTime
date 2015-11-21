package cn.updev.Users.Group.GroupInfo;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupMemberInviteInfoFactory {
    private Integer groupId;
    private Integer inviterId;
    private Integer inviteeId;
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
    public boolean saveGroupMemberInviteInfo(){
        if(this.groupId == null || this.inviterId == null || this.inviteeId == null)
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
