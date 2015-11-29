package cn.updev.Users.Group.GroupMemberRule;

import cn.updev.Users.Group.GroupInfo.GroupInfo;
import cn.updev.Users.Group.GroupInfo.GroupInfoFactory;
import cn.updev.Users.Group.GroupInfo.GroupMemberInfoFactory;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupDelete;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupQuery;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupUpdate;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupInfo;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupUser;

/**
 * Created by blf2 on 15-10-8.
 */
public class AdminRule extends PrimaryUserRule {
    public boolean removeGroupMember(IGroupInfo iGroupInfo,IGroupUser iGroupUser1,IGroupUser iGroupUser2){//１　是删除执行者　２是被删除人员
        if(iGroupUser1.isAdmin() || iGroupUser1.isCreater()){
            if(new UserOrGroupQuery().queryGroupInfoById(iGroupInfo.getGroupId()) != null){
                return new UserOrGroupDelete().deleteGroupMemberById(iGroupUser2.getUserId(), iGroupInfo.getGroupId());
            }
        }
        return false;
    }
    public boolean changeGroupInfo(IGroupInfo iGroupInfo){
        return new UserOrGroupUpdate().updateGroupInfo((GroupInfo)iGroupInfo);
    }
}
