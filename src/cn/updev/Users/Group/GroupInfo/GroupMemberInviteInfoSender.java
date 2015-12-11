package cn.updev.Users.Group.GroupInfo;

import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupDelete;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupSave;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupUpdate;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupMemberInviteInfo;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupMemberInviteInfoSender {
    private GroupMemberInviteInfo groupMemberInviteInfo;

    public GroupMemberInviteInfoSender(GroupMemberInviteInfo groupMemberInviteInfo){
        this.groupMemberInviteInfo = groupMemberInviteInfo;
    }

    public IGroupMemberInviteInfo saveGroupMemberInviteInfo(){
        return new UserOrGroupSave().saveGroupMemberInviteInfo(groupMemberInviteInfo);
    }

    public boolean updateGroupMemberInviteInfo(){

//        if(用户拒绝){
//            已经finish
//            直接给邀请者说用户拒绝
//        }else if(用户同意){
//            没有finish
//            if(管理员同意){
//                没有finish
//                发送反馈给邀请者： 用户同意并添加
//            }else if(管理员拒绝){
//                变成finis
//                发送反馈给邀请者： 管理员拒绝
//            }
//        }

        return new UserOrGroupUpdate().updateGroupMemberInviteInfo(groupMemberInviteInfo);
    }

    public boolean deleteGroupMemberInviteInfo(){
        return new UserOrGroupDelete().deleteGroupMemberInviteInfo(groupMemberInviteInfo);
    }
}
