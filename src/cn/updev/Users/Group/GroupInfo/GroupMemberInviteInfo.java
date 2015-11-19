package cn.updev.Users.Group.GroupInfo;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupMemberInviteInfo {
    private Integer groupId;
    private Integer inviterId;
    private Integer inviteeId;
    public GroupMemberInviteInfo(Integer groupId,Integer inviterId,Integer inviteeId){
        this.groupId = groupId;
        this.inviterId = inviterId;
        this.inviteeId = inviteeId;
    }
    public GroupMemberInviteInfo(){}
    public boolean saveGroupMemberInviteInfo(){
        //存储邀请信息
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
