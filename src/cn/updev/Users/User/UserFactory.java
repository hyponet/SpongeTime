package cn.updev.Users.User;

import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupQuery;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupSave;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import cn.updev.Users.Static.EnumeRule.UserRule;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by blf2 on 15-9-28.
 */
public class UserFactory {

    private String userName;
    private String nickName;
    private String eMail;
    private String passWord;
    private String url;
    private UserRule rule;

    public UserFactory(String userName, String nickName, String eMail, String passWord,String url,UserRule rule) {
        this.seteMail(eMail);//this.eMail = eMail;
        this.setNickName(nickName);
        this.setUserName(userName);
        this.setPassWord(passWord);
        this.setRule(rule);
        this.setUrl(url);
    }

    private void seteMail(String eMail) {

        //判断合法E-Mail
        Pattern pattern = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
        Matcher matcher = pattern.matcher(eMail);

        if(matcher.matches()){
            this.eMail = eMail;
        }else{
            this.eMail = null;
        }

    }

    private void setNickName(String nickName) {

        //限制长度
        if(nickName.length() > 10){
            nickName = nickName.substring(0,10);
        }
        this.nickName = nickName;
    }

    private void setUserName(String userName) {

        //限制长度
        if(userName.length() > 10){
            userName = userName.substring(0,10);
        }
        this.userName = userName;
    }

    private void setPassWord(String passWord) {

        //密码MD5加密 把注册邮箱作为盐
        //确定计算方法
        passWord = passWord + this.eMail;
        MessageDigest md5= null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        try {
            passWord=base64en.encode(md5.digest(passWord.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        this.passWord = passWord;
    }

    private void setUrl(String url){
        //限制长度
        if(url.length() > 50){
            url = url.substring(0,50);
        }
        this.url = url;
    }

    private void setRule(UserRule rule){
        if(rule.isAdmin() || rule.isUser()){
            this.rule = rule;
        }else{
            this.rule = null;
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getNickName() {
        return nickName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUrl() {
        return url;
    }

    public UserRule getRule() {
        return rule;
    }

    public IUser getUser(){

        if(this.eMail == null || this.rule == null){
            return null;
        }
        User user = new User(this.userName,this.nickName,this.eMail,this.passWord,this.url,this.rule);
        IUser iUser = new UserOrGroupSave().saveUser(user);
        return iUser;
    }

    public boolean updateUser(){
        return true;
    }
}
