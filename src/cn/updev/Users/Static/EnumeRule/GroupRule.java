package cn.updev.Users.Static.EnumeRule;

/**
 * Created by blf2 on 15-11-24.
 */
public enum GroupRule {
    Creater,Admin,User;
    public boolean isCreater(){
        if(this == Creater){
            return true;
        }
        return false;
    }

    public boolean isAdmin(){
        if(this == Admin){
            return true;
        }
        return false;
    }

    public boolean isUser(){
        if(this == User){
            return true;
        }
        return false;
    }
}
