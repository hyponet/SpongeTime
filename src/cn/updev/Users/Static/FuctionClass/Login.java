package cn.updev.Users.Static.FuctionClass;

import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupQuery;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import org.apache.struts2.ServletActionContext;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 登录判断
 * 获得登录用户
 * Created by hypo on 15-9-29.
 */
public class Login {
    private IUser user;
    private String passWord;
    private String key;

    public Login(){

    }

    public Login(String email, String passWord) {

        //判断合法E-Mail
        Pattern pattern = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
        Matcher matcher = pattern.matcher(email);

        if(matcher.matches()){

            // email是用户注册邮箱
            UserOrGroupQuery query = new UserOrGroupQuery();
            user = query.queryUserByEMail(email);
        }else{

            // 邮箱非法，不用再去尝试获取用户
            user = null;
        }

        this.passWord = passWord;
    }

    public Boolean judge(){

        if(user == null){
            return false;
        }

        if(key != null){
            if(key.equals(user.getPassWord())){
                setSession();
                return true;
            }
        }

        passWord = passWord + user.geteMail();

        //确定计算方法
        MessageDigest md5= null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //加密后的字符串
        BASE64Encoder base64en = new BASE64Encoder();
        try {
            passWord = base64en.encode(md5.digest(passWord.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if(passWord.equals(user.getPassWord())){
            setSession();
            return true;
        }

        return false;
    }

    private void setSession(){

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();

        session.setAttribute("LoingedUser", user);

    }

    public IUser getLoginedUser(){

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();

        IUser rnt = (IUser) session.getAttribute("LoingedUser");

        return rnt;
    }

    public void logout(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();

        session.setAttribute("LoingedUser", null);
    }

    public Boolean isNotLogined(){

        IUser user = getLoginedUser();

        if(user == null){
            return true;
        }else {
            return false;
        }
    }

    public void setUser(IUser user) {
        this.user = user;
        setSession();
    }

    public void setKey(String key) {
        this.key = key;
    }
}
