package cn.updev.Users.Static.UserOrGroupInterface;

import cn.updev.Users.NotificationPush.NotificationInfo;
import cn.updev.Users.Static.EnumeRule.NotificationStatus;

/**
 * Created by blf2 on 15-12-1.
 */
public interface INotificationInfo {
    Integer getNotificationCreaterId();
    Integer getNotificationAccepterId();
    String getNotifucationBody();
    void setNotifucationBody(String notifucationBody);
    NotificationStatus getStatus();
    void setStatus(NotificationStatus status);
    NotificationInfo saveNotificationInfo();
    boolean updateNotificationInfo();
    boolean deleteNotificationInfo();
    boolean isNotPush();
    boolean isHasPushed();
    boolean isHasRead();
}
