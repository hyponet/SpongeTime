package cn.updev.Users.Static.UserOrGroupInterface;

import cn.updev.Users.Static.EnumeRule.InviteStatus;

/**
 * Created by blf2 on 15-11-29.
 */
public interface IGroupMemberInviteInfo {
    Integer getGroupId();
    Integer getInviterId();
    Integer getInviteeId();
    void setInviteStatus(InviteStatus inviteStatus);
    boolean isInvite();
    boolean isInviteeAgree();
    boolean isInviteFinish();
}
