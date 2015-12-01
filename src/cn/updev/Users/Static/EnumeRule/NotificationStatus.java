package cn.updev.Users.Static.EnumeRule;

/**
 * Created by blf2 on 15-12-1.
 */
public enum NotificationStatus {
    notPush,hasPushed,hasRead;

    public boolean isNotPush(){
        if(this == notPush)
            return true;
        return false;
    }

    public boolean isHasPushed(){
        if(this == notPush)
            return true;
        return false;
    }

    public boolean isHasRead(){
        if(this == hasRead)
            return true;
        return false;
    }
}
