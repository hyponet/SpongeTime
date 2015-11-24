package cn.updev.Users.Static;

/**
 * Created by hypo on 15-9-28.
 */
public enum UserRule {
    Admin,User;

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
        return  false;
    }
}
