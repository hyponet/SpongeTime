package cn.updev.Users.Group.GroupInfo;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupMemberInviteInfoFactory {
    private Integer groupId;
    private Integer inviterId;
    private Integer inviteeId;
    public GroupMemberInviteInfoFactory(Integer groupId,Integer inviterId,Integer inviteeId){
        this.groupId = groupId;
        this.inviterId = inviterId;
        this.inviteeId = inviteeId;
    }
    public boolean saveGroupMemberInviteInfo(){
        //如果inviteeId和inviterId存在，调用

        return new GroupMemberInviteInfo().saveGroupMemberInviteInfo();
        //不存在则返回false

    }
    public boolean deleteGroupMemberInviteInfo(){
        return new GroupMemberInviteInfo().deleteGroupMemberInviteInfo();
    }
}
