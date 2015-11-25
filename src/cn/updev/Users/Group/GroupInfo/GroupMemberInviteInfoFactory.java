package cn.updev.Users.Group.GroupInfo;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupMemberInviteInfoFactory {
    private Integer groupId;
    private Integer inviterId;
    private Integer inviteeId;
    private Integer statusNum;
/*statusNum说明：０　表示未处理邀请，应该推送给被邀请者
                １１　表示被邀请者同意，应该推送给管理员或创建者
                １２　表示被邀请者忽略此消息
                １３　表示被邀请人拒绝接受邀请，推送给邀请者
                １０　表示邀请者和被邀请者这一层处理完成（推送也完成）


                ２１　表示管理员或创建者已经同意，推送给邀请者，被邀请者，各位管理员，创建者
                ２２　表示管理员或创建者决绝此邀请　推送给邀请者，被邀请者，各位管理员，创建者
                ２０　表示管理层处理完成（推送也完成）
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
                this.statusNum = statusNum;
                break;
            default:this.statusNum = -1;
        }
    }
    public boolean saveGroupMemberInviteInfo(){
        if(this.groupId == null || this.inviterId == null || this.inviteeId == null || this.statusNum == -1)
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
