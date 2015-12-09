package cn.updev.Action.User;

import cn.updev.Users.NotificationPush.NotificationInfo;
import cn.updev.Users.NotificationPush.NotificationSender;
import cn.updev.Users.Static.EnumeRule.NotificationType;
import cn.updev.Users.Static.FuctionClass.Login;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupQuery;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hypo on 15-12-9.
 */
public class MessageAction extends ActionSupport {

    private Integer id;
    private String toUser;
    private String title;
    private String content;

    public String execute(){

        Login login = new Login();
        if(login.isNotLogined()){
            return LOGIN;
        }

        IUser user = login.getLoginedUser();
        UserOrGroupQuery DAO = new UserOrGroupQuery();

        List<NotificationInfo> list = DAO.queryNotificationAll(user.getUserId());

        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("messageList", list);
        return SUCCESS;
    }

    public String sender(){

        Login login = new Login();
        if(login.isNotLogined()){
            return LOGIN;
        }

        IUser user = login.getLoginedUser();

        NotificationInfo notificationInfo = new NotificationInfo();

        notificationInfo.setNotificationCreaterId(user.getUserId());
        notificationInfo.setTitle(this.title);
        notificationInfo.setNotifucationBody(this.content);
        notificationInfo.setType(NotificationType.user);

        String[] toUsers = this.toUser.split(",");

        for(String userlogin : toUsers){
            UserOrGroupQuery DAO = new UserOrGroupQuery();
            IUser touser = DAO.queryUserByName(userlogin);

            notificationInfo.setNotificationAccepterId(touser.getUserId());
            NotificationSender sender = new NotificationSender(notificationInfo);
            sender.NotificationSendToUser();

        }

        return SUCCESS;
    }

    public String read(){

        Login login = new Login();
        if(login.isNotLogined()){
            return LOGIN;
        }

        UserOrGroupQuery DAO = new UserOrGroupQuery();
        NotificationInfo info = DAO.queryNotificationById(this.id);

        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("messageInfo", info);

        return SUCCESS;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
