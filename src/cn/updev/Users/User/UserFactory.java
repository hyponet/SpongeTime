package cn.updev.Users.User;

import cn.updev.Users.Static.IUser;
import cn.updev.Users.Static.UserRule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hypo on 15-9-28.
 */
public class UserFactory {

    private String userName;
    private String nickName;
    private String eMail;
    private String passWord;

    public UserFactory(String eMail, String nickName, String userName, String passWord) {
        this.eMail = eMail;
        this.nickName = nickName;
        this.userName = userName;
        this.passWord = passWord;
    }

    private String geteMail() {

        //判断合法E-Mail
        Pattern pattern = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
        Matcher matcher = pattern.matcher(eMail);

        if(matcher.matches()){

            return eMail;
        }
        return null;
    }

    private String getNickName() {

        //限制长度
        if(nickName.length() > 10){
            nickName = nickName.substring(0,10);
        }
        return nickName;
    }

    private String getUserName() {

        //限制长度
        if(userName.length() > 10){
            userName = userName.substring(0,10);
        }
        return userName;
    }

    private String getPassWord() {
        return passWord;
    }

    public IUser getUser(){

        if(geteMail() == null){
            return null;
        }

        IUser user = new User(geteMail(),getNickName(),getPassWord(),UserRule.User,null,null,getUserName());
        //数据持久化并获得ID


        return user;
    }
}
