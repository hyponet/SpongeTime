package cn.updev.Users.Group.GroupInfo;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupMemberInviteInfo {
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

    public GroupMemberInviteInfo(Integer groupId,Integer inviterId,Integer inviteeId,Integer statusNum){
        this.groupId = groupId;
        this.inviterId = inviterId;
        this.inviteeId = inviteeId;
        this.statusNum = statusNum;
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
