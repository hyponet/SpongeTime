package cn.updev.Users.Static.EnumeRule;

/**
 * Created by blf2 on 15-11-27.
 */
public enum InviteStatus {
    invite,inviteeAgree,inviteFinish;
    /*
    invite:新建邀请
    inviteAgree:被邀请者同意
    inviteFinish:邀请结束
     */
    public boolean isInvite(){
        if(this == invite)
            return true;
        return false;
    }
    public boolean isInviteeAgree(){
        if(this == inviteeAgree)
            return  true;
        return false;
    }
    public boolean isInviteFinish(){
        if(this == inviteFinish)
            return true;
        return false;
    }
}
