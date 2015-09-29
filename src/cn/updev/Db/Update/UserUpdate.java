package cn.updev.Db.Update;

import cn.updev.Users.Static.IUser;
import cn.updev.Users.Static.UserRule;

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
    }

    public void setRule(UserRule rule) {
    }

    public void setUrl(String url) {
    }

    //数据持久化
    public Boolean update(){

        return false;
    }

    //删除
    public Boolean delete(){

        return false;
    }
}
