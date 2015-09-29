package cn.updev.Users.User;

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

    public UserFactory(String eMail, String nickName, String userName) {
        this.eMail = eMail;
        this.nickName = nickName;
        this.userName = userName;
    }

    public String geteMail() {

        //判断合法E-Mail
        Pattern pattern = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
        Matcher matcher = pattern.matcher(eMail);

        if(matcher.matches()){

            return eMail;
        }
        return null;
    }

    public String getNickName() {

        //限制长度
        if(nickName.length() > 10){
            nickName = nickName.substring(0,10);
        }
        return nickName;
    }

    public String getUserName() {

        //限制长度
        if(userName.length() > 10){
            userName = userName.substring(0,10);
        }
        return userName;
    }

    public User getUser(){

        if(geteMail() == null){
            return null;
        }

        User user = new User(geteMail(),getNickName(),UserRule.User,null,-1,getUserName());

        //数据持久化并获得ID

        return user;
    }
}
