package cn.updev.Users.Static.EnumeRule;

/**
 * Created by hypo on 15-9-28.
 */
public enum UserRule {
    Admin,User,Nonactivated,Disabled;//未激活　已禁用

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

    public boolean isNonactivated(){
        if(this == Nonactivated){
            return true;
        }
        return false;
    }

    public boolean isDisabled(){
        if(this == Disabled){
            return true;
        }
        return false;
    }
}
