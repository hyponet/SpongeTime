package cn.updev.Users.Static.UserOrGroupInterface;

import cn.updev.Users.Static.EnumeRule.InviteStatus;

/**
 * Created by blf2 on 15-11-29.
 */
public interface IGroupMemberInviteInfo {
    Integer getGroupId();
    Integer getInviterId();
    Integer getInviteeId();
    boolean isInviteUser();
    boolean isInviteAgree();
    boolean isInviteOutTime();
    boolean isAdminAgree();
    boolean isAdminDeny();
    void setInviteStatus(InviteStatus inviteStatus);
}
