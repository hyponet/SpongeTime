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
        return new UserOrGroupUpdate().updateGroupMemberInviteInfo(groupMemberInviteInfo);
    }

    public boolean deleteGroupMemberInviteInfo(){
        return new UserOrGroupDelete().deleteGroupMemberInviteInfo(groupMemberInviteInfo);
    }
}
