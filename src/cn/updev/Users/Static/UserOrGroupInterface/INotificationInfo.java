package cn.updev.Users.Static.UserOrGroupInterface;

import cn.updev.Users.NotificationPush.NotificationInfo;
import cn.updev.Users.Static.EnumeRule.NotificationStatus;
import cn.updev.Users.Static.EnumeRule.NotificationType;

/**
 * Created by blf2 on 15-12-1.
 */
public interface INotificationInfo {
    Integer getNotificationCreaterId();
    Integer getNotificationAccepterId();
    String getNotifucationBody();
    void setNotifucationBody(String notifucationBody);
    void setType(NotificationType type);
    NotificationType getType();
    NotificationStatus getStatus();
    void setStatus(NotificationStatus status);
    boolean isHasRead();
}
