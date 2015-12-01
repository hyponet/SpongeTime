package cn.updev.Users.NotificationPush;

import cn.updev.Users.Static.EnumeRule.NotificationStatus;
import cn.updev.Users.Static.UserOrGroupInterface.INotificationInfo;

/**
 * Created by blf2 on 15-12-1.
 */
public class NotificationInfoFactory {
    private Integer notificationCreaterId;
    private Integer notificationAccepterId;
    private String notifucationBody;
    private NotificationStatus status;

    public NotificationInfoFactory(Integer notificationCreaterId,Integer notificationAccepterId,String notifucationBody,NotificationStatus status){
        this.setNotificationCreaterId(notificationCreaterId);
        this.setNotificationAccepterId(notificationAccepterId);
        this.setNotifucationBody(notifucationBody);
    }

    private void setNotificationCreaterId(Integer createrId){
        this.notificationCreaterId = createrId;
    }

    private void setNotificationAccepterId(Integer accepterId){
        this.notificationAccepterId = accepterId;
    }

    private void setNotifucationBody(String body){
        if(body.length() > 100)
            body = body.substring(0,100);
        this.notifucationBody = body;
    }

    public Integer getNotificationCreaterId() {
        return notificationCreaterId;
    }

    public Integer getNotificationAccepterId() {
        return notificationAccepterId;
    }

    public String getNotifucationBody() {
        return notifucationBody;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public INotificationInfo getNotificationInfo(){
        return new NotificationInfo(this.notificationCreaterId,this.notificationAccepterId,this.notifucationBody,NotificationStatus.notPush)
                .saveNotificationInfo();
    }
    public boolean updateNotificationInfo(){
        return new NotificationInfo(this.notificationCreaterId,this.notificationAccepterId,this.notifucationBody,NotificationStatus.notPush)
                .updateNotificationInfo();
    }
}
