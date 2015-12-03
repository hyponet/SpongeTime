package cn.updev.Users.NotificationPush;

import cn.updev.Users.Static.EnumeRule.NotificationStatus;
import cn.updev.Users.Static.EnumeRule.NotificationType;
import cn.updev.Users.Static.UserOrGroupInterface.INotificationInfo;

/**
 * Created by blf2 on 15-12-1.
 */
public class NotificationInfoFactory {
    private Integer notificationCreaterId;
    private Integer notificationAccepterId;
    private String notifucationBody;
    private NotificationType type;
    private NotificationStatus status;

    public NotificationType getType() {
        return type;
    }

    public NotificationInfoFactory(Integer notificationCreaterId,Integer notificationAccepterId,NotificationType type,
                                   String notifucationBody,NotificationStatus status){
        this.setNotificationCreaterId(notificationCreaterId);
        this.setNotificationAccepterId(notificationAccepterId);
        this.setType(type);

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
    private void setType(NotificationType type){
        this.type = type;
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
        return new NotificationInfo(this.notificationCreaterId,this.notificationAccepterId,this.type,
                this.notifucationBody,NotificationStatus.hasPushed).saveNotificationInfo();
    }
    public boolean updateNotificationInfo(){
        return new NotificationInfo(this.notificationCreaterId,this.notificationAccepterId,this.type,this.notifucationBody,this.status)
                .updateNotificationInfo();
    }
}
