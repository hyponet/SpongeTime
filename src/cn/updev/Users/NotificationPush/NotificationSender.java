package cn.updev.Users.NotificationPush;

import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupSave;
import cn.updev.Users.Static.UserOrGroupInterface.INotificationInfo;

/**
 * Created by blf2 on 15-12-7.
 */
public class NotificationSender {
    private NotificationInfo notificationInfo;

    public NotificationSender(){}

    public NotificationSender(NotificationInfo notificationInfo){
        this.notificationInfo = notificationInfo;
    }

    public INotificationInfo NotificationSendToUser(){
        return new UserOrGroupSave().saveNotificationInfo(notificationInfo);
    }
}
