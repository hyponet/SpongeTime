package cn.updev.Users.Static.EnumeRule;

/**
 * Created by blf2 on 15-12-4.
 */
public enum NotificationType {
    /**
     * user:用户
     * userGroup:团队
     * event:事件
     * system:系统
     */
    user,userGroup,event,system;
    public boolean isUser(){
        if(this == user)
            return true;
        return  false;
    }
    public boolean isUserGroup(){
        if(this == userGroup)
            return true;
        return  false;
    }
    public boolean isEvent(){
        if(this == event)
            return true;
        return  false;
    }
    public boolean isSystem(){
        if(this == system)
            return true;
        return  false;
    }
}
