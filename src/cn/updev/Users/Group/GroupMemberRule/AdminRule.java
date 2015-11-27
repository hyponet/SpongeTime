package cn.updev.Users.Group.GroupMemberRule;

import cn.updev.Users.Group.GroupInfo.GroupInfoFactory;
import cn.updev.Users.Group.GroupInfo.GroupMemberInfoFactory;

/**
 * Created by blf2 on 15-10-8.
 */
public class AdminRule extends PrimaryUserRule {
  //  public boolean removeGroupMember(Integer userId){
        //如果userId存在并且删除人有权限请出团队成员时
  //      return new GroupMemberInfoFactory().delGroupMemberInfo(userId);
  //  }
    public boolean changeGroupInfo(GroupInfoFactory gif){
     //   gif.updateGroupInfo();
        return true;
    }
}
