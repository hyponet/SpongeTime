package cn.updev.Db.Update;

import cn.updev.Users.Static.IUser;
import cn.updev.Users.Static.UserRule;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hypo on 15-9-29.
 */
public class UserUpdate {
    private IUser user;

    public UserUpdate(IUser user) {
        this.user = user;
    }

    public void setNickName(String nickName) {
        //长度判断
        if(nickName.length() > 10){
            nickName = nickName.substring(0,10);
        }
        user.setNickName(nickName);

    }

    public void setPassWord(String passWord) {

        //密码MD5加密 把注册邮箱作为盐
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update((passWord + user.geteMail()).getBytes());
            passWord = new String(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        user.setPassWord(passWord);
    }

    public void setRule(UserRule rule) {

        user.setRule(rule);
    }

    public void setUrl(String url) {
    }

    //数据持久化
    public IUser update(){

        //数据持久化

        if(user.getUserId() == null){
            //获取用户ID

        }
        return user;
    }

    //删除
    public Boolean delete(){

        return false;
    }
}
