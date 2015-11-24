package cn.updev.Action.Admin;

import cn.updev.EventWeight.Rate.EventGroupRateManage;
import cn.updev.Events.Event.EventDAO;
import cn.updev.Events.Group.EventGroupDAO;
import cn.updev.Users.Static.Login;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

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

    public String login(){

        if(this.email == null || this.password == null){
            return LOGIN;
        }

        Login login = new Login(this.email, this.password);

        if(login.judge()){

            return SUCCESS;
        }else {
            return LOGIN;
        }
    }

    public String execute() throws Exception {

        // 获得用户ID并进行权限判断权限判断
        Integer userId = 1;

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
}
