package cn.updev.Users.Group.GroupInfo;

import cn.updev.Users.User.GroupUser;
import cn.updev.Users.User.GroupUserFactory;

import java.util.List;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupMemberInfoFactory {
  public List <GroupUser> showAllGroupMember(Integer groupId){
      return new GroupMemberInfo().findGroupMemberInfoAll(groupId);
  }
}
