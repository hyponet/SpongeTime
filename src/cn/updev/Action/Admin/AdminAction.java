package cn.updev.Action.Admin;

import cn.updev.EventWeight.Rate.EventGroupRateManage;
import cn.updev.Events.Event.EventDAO;
import cn.updev.Events.Group.EventGroupDAO;
import cn.updev.Users.Static.FuctionClass.Login;
import cn.updev.Users.Static.FuctionClass.Register;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 作为后台的第一层拦截器
 * 作为区分普通用户和超级管理员用户进行分流
 * Created by hypo on 15-11-22.
 */
public class AdminAction extends ActionSupport {

    private String email;
    private String password;
    private String remember;
    private String userName;
    private String nickName;
    private String rePassword;
    private String url;

    private String code;

    public String login(){

        Login login = new Login();
        if(!login.isNotLogined()){
            return SUCCESS;
        }

        HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies = request.getCookies();

        String key = null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("ID")){
                this.email = cookie.getValue();
            }else if(cookie.getName().equals("KEY")){
                key = cookie.getValue();
            }
        }

        if(this.email == null || (this.password == null && key == null)){
            return LOGIN;
        }

        login = new Login(this.email, this.password);

        if(key != null){
            // 从Cookie获得了值
            login.setKey(key);
        }

        if(login.judge()){

            if(this.remember != null && this.remember.equals("Remember Me")){

                //把用户邮箱和密码存入Cookie
                IUser user = login.getLoginedUser();
                Cookie cookieID = new Cookie("ID", user.geteMail());
                Cookie cookieKEY = new Cookie("KEY", user.getPassWord());
                cookieID.setMaxAge(60*60*24*7);
                cookieKEY.setMaxAge(60*60*24*7);
                ServletActionContext.getResponse().addCookie(cookieID);
                ServletActionContext.getResponse().addCookie(cookieKEY);
            }
            return SUCCESS;
        }else {
            return LOGIN;
        }
    }

    public String logout(){

        Login login = new Login();

        if(login.getLoginedUser() == null){
            return LOGIN;
        }

        login.logout();

        return SUCCESS;
    }

    public String execute() throws Exception {

        Login login = new Login();
        if(login.isNotLogined()){
            return LOGIN;
        }

        // 获得用户ID并进行权限判断权限判断
        Integer userId = login.getLoginedUser().getUserId();

        //如果是普通用户
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        EventDAO eventDAO = new EventDAO();
        EventGroupDAO groupDAO = new EventGroupDAO();

        Integer allUserEventNum = eventDAO.getAllUserEventNum(userId);
        Integer unFinishUserEventNum = eventDAO.getUnFinishUserEventNum(userId);
        Integer allteamEventNum = eventDAO.getAllTeamEventNum(userId);
        Integer unFinishteamEventNum = eventDAO.getUnFinishteamEventNum(userId);
        Integer allFinishEventNum = allUserEventNum + allteamEventNum - unFinishUserEventNum - unFinishteamEventNum;

        Integer allEventNum = allUserEventNum + allteamEventNum;
        Integer eventFinishRate;

        if(allEventNum == 0){
            eventFinishRate = 0;
        }else {
            Integer finishEventNum = allEventNum - unFinishUserEventNum - unFinishteamEventNum;
            eventFinishRate = 100 * finishEventNum / allEventNum;
        }

        session.setAttribute("unFinishUserEventNum", unFinishUserEventNum);
        session.setAttribute("unFinishteamEventNum", unFinishteamEventNum);
        session.setAttribute("allFinishEventNum", allFinishEventNum);
        session.setAttribute("eventFinishRate", eventFinishRate);

        List<Integer> groupIds = groupDAO.getUserEventGroupId(userId);
        EventGroupRateManage rateManage = new EventGroupRateManage();
        rateManage.setEventGroupRate(groupIds);

        return "user";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
