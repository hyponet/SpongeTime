package cn.updev.Users.Static.FuctionClass;

/**
 * Created by blf2 on 15-11-22.
 */

import cn.updev.Users.Static.EnumeRule.UserRule;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupQuery;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import cn.updev.Users.User.UserFactory;

public class Register {
    private UserFactory userFactory = null;

    public Register(String userName, String nickName, String eMail, String passWord,String url){
        userFactory = new UserFactory(userName,nickName,eMail,passWord,url,UserRule.Nonactivated);
    }

    public IUser saveUserInfo(){


        if(userFactory != null && new UserOrGroupQuery().queryUserByEMail(userFactory.geteMail()) == null){
            //如果注册数据合法并且不存在重复用户名就保存到数据库
            return userFactory.getUser();
        }
        return null;
    }
}
