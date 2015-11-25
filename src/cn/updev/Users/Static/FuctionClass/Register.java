package cn.updev.Users.Static.FuctionClass;

/**
 * Created by blf2 on 15-11-22.
 */

import  cn.updev.Users.User.User;

public class Register {
    private User user;

    public Register(User user){
        this.user = user;
    }

    public boolean saveUserInfo(){
        //存储user信息
        return true;
    }
}
