package cn.updev.Users.User;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import cn.updev.Users.Static.EnumeRule.UserRule;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by hypo on 15-9-28.
 */
public class User implements IUser{
    private Integer userId;
    private String userName;
    private String nickName;
    private String eMail;
    private String passWord;
    private String url;
    private UserRule rule;

    public User(){

    }

   public User(String userName,String nickName,String eMail,String passWord,String url,UserRule rule){
       this.userName = userName;
       this.nickName = nickName;
       this.eMail = eMail;
       this.passWord = passWord;
       this.url = url;
       this.rule = rule;
   }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UserRule getRule() {
        return rule;
    }

    public void setRule(UserRule rule) {
        this.rule = rule;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public boolean isAdmin(){
        return rule.isAdmin();
    }

    public boolean isUser(){return rule.isUser();}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return getUserId() == user.getUserId();

    }

    @Override
    public int hashCode() {
        return getUserId();
    }
}
