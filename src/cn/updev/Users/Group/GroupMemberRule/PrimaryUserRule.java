package cn.updev.Users.Group.GroupMemberRule;

/**
 * Created by blf2 on 15-10-8.
 */

import cn.updev.Users.Group.GroupInfo.*;
import cn.updev.Users.Static.EnumeRule.GroupRule;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupUpdate;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupInfo;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupMemberInviteInfo;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupUser;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import cn.updev.Users.User.GroupUserFactory;
import cn.updev.Users.User.User;

import java.awt.*;

public class PrimaryUserRule {
    public IGroupInfo createGroup(String groupName,String groupIntro,Integer userId){//前端传来请求,包括
        GroupInfoFactory groupInfoFactory = new GroupInfoFactory(groupName,groupIntro);
        if(groupInfoFactory != null) {
            IGroupInfo iGroupInfo = groupInfoFactory.saveGroupInfo();
            GroupUserFactory groupUserFactory = new GroupUserFactory(userId,iGroupInfo.getGroupId(), GroupRule.Creater);
            IGroupUser iGroupUser = groupUserFactory.getGroupUser();
            if(iGroupUser != null)
                return iGroupInfo;
        }
        return null;
    }
    public IGroupMemberInviteInfo inviteUser(Integer groupId,Integer inviterId,Integer inviteeId){
        GroupMemberInviteInfoFactory gmiif = new GroupMemberInviteInfoFactory(groupId,inviterId,inviteeId);
        if(gmiif != null) {
            return gmiif.saveGroupMemberInviteInfo();
        }
        return null;
    }
    public boolean updataUserInfo(IUser iUser){
        return new UserOrGroupUpdate().updateUser((User)iUser);
    }
}
