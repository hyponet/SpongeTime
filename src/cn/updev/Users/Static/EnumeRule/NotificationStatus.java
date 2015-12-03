package cn.updev.Users.Static.EnumeRule;

/**
 * Created by blf2 on 15-12-1.
 */
public enum NotificationStatus {
    hasPushed,hasRead;

    public boolean isHasPushed(){
        if(this == hasPushed)
            return true;
        return false;
    }

    public boolean isHasRead(){
        if(this == hasRead)
            return true;
        return false;
    }
}
