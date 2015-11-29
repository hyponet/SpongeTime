package cn.updev.Users.Static.EnumeRule;

/**
 * Created by blf2 on 15-11-27.
 */
public enum InviteStatus {
    inviteUser,inviteeAgree,inviteOutTime,adminAgree,adminDeny;


     /*statusNum说明：inviteUser　表示未处理邀请，应该推送给被邀请者
                inviteeAgree　表示被邀请者同意，应该推送给管理员或创建者
                inviteeDeny　表示被邀请人拒绝接受邀请，推送给邀请者
                inviteOutTime　表示邀请消息超期

                adminAgree　表示管理员或创建者已经同意，推送给邀请者，被邀请者，各位管理员，创建者
                adminDeny　表示管理员或创建者决绝此邀请　推送给邀请者，被邀请者，各位管理员，创建者
 */

    public boolean isInviteUser(){
        if(this == inviteUser)
            return true;
        return false;
    }

    public boolean isInviteAgree(){
        if(this == inviteeAgree)
            return true;
        return false;
    }

    public boolean isInviteOutTime(){
        if(this == inviteOutTime)
            return true;
        return false;
    }

    public boolean isAdminAgree(){
        if(this == adminAgree)
            return true;
        return false;
    }

    public boolean isAdminDeny(){
        if(this == adminDeny)
            return true;
        return false;
    }

}
