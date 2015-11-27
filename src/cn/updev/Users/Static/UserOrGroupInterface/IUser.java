package cn.updev.Users.Static.UserOrGroupInterface;

import cn.updev.Users.Static.EnumeRule.UserRule;

/**
 * 用户接口，约束用户对象的操作
 * Created by hypo on 15-9-28.
 */
public interface IUser {

    String geteMail();
    String getNickName();
    void setNickName(String nickName);
    UserRule getRule();
    void setRule(UserRule rule);
    String getUrl();
    void setUrl(String url);
    Integer getUserId();
    String getUserName();
    void setUserName(String userName);
    boolean isAdmin();
    boolean isUser();
    void setPassWord(String passWord);
    String getPassWord();
    boolean isDisabled();
    boolean isNonactivated();
}
