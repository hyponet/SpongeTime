package cn.updev.Users.Group.GroupMemberRule;

import cn.updev.Users.Group.GroupInfo.GroupMemberInfoFactory;
import cn.updev.Users.Static.EnumeRule.GroupRule;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupDelete;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupQuery;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupUpdate;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupUser;
import cn.updev.Users.User.GroupUser;

/**
 * Created by blf2 on 15-10-8.
 */
public class RootRule {
    public boolean dismissGroup(Integer userId,Integer groupId){
        IGroupUser iGroupUser = new UserOrGroupQuery().queryGroupUser(userId,groupId);
        if(iGroupUser != null && iGroupUser.getGroupMemberRule() == GroupRule.Creater){
            return new UserOrGroupDelete().deleteGroupInfoById(groupId);
        }
        return false;
    }
    public boolean appointAdmin(Integer groupId,Integer createrId,Integer userId){
        IGroupUser iGroupUser = new UserOrGroupQuery().queryGroupUser(createrId,groupId);
        if(iGroupUser != null && iGroupUser.getGroupMemberRule() == GroupRule.Creater){
            IGroupUser iGroupUser1 = new UserOrGroupQuery().queryGroupUser(userId,groupId);
            iGroupUser1.setGroupMemberRule(GroupRule.Admin);
            return new UserOrGroupUpdate().updateGroupUser((GroupUser)iGroupUser1);
        }
        return false;
    }
    public boolean cancelAdmin(Integer groupId,Integer createrId,Integer userId){
        IGroupUser iGroupUser = new UserOrGroupQuery().queryGroupUser(createrId,groupId);
        if(iGroupUser != null && iGroupUser.getGroupMemberRule() == GroupRule.Creater){
            IGroupUser iGroupUser1 = new UserOrGroupQuery().queryGroupUser(userId,groupId);
            iGroupUser1.setGroupMemberRule(GroupRule.User);
            return new UserOrGroupUpdate().updateGroupUser((GroupUser)iGroupUser1);
        }
        return false;
    }
}
