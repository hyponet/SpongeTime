package cn.updev.Users.NotificationPush;

import cn.updev.Users.Static.EnumeRule.NotificationStatus;
import cn.updev.Users.Static.EnumeRule.NotificationType;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupDelete;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupSave;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupUpdate;
import cn.updev.Users.Static.UserOrGroupInterface.INotificationInfo;

/**
 * Created by blf2 on 15-12-1.
 */
public class NotificationInfo implements INotificationInfo{
    private Integer notificationInfoId;//没有实际意义，只是为了Hibernate
    private Integer notificationCreaterId;
    private Integer notificationAccepterId;
    private NotificationType type;
    private String notifucationBody;
    private NotificationStatus status;

    public NotificationInfo(){}

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public NotificationInfo(Integer notificationCreaterId,Integer notificationAccepterId,NotificationType type,
                            String notifucationBody,NotificationStatus status ){
        this.notificationCreaterId = notificationCreaterId;
        this.notificationAccepterId = notificationAccepterId;
        this.notifucationBody = notifucationBody;
        this.status = status;
        this.type = type;

    }

    public Integer getNotificationCreaterId() {
        return notificationCreaterId;
    }

    public void setNotificationCreaterId(Integer notificationCreaterId) {
        this.notificationCreaterId = notificationCreaterId;
    }

    public Integer getNotificationAccepterId() {
        return notificationAccepterId;
    }

    public void setNotificationAccepterId(Integer notificationAccepterId) {
        this.notificationAccepterId = notificationAccepterId;
    }

    public String getNotifucationBody() {
        return notifucationBody;
    }

    public void setNotifucationBody(String notifucationBody) {
        this.notifucationBody = notifucationBody;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }


    public boolean isHasRead(){
        if(this.status == NotificationStatus.hasRead)
            return true;
        return false;
    }

    public NotificationInfo saveNotificationInfo(){
        return new UserOrGroupSave().saveNotificationInfo(this);
    }

    public boolean updateNotificationInfo(){
        return new UserOrGroupUpdate().updateNotificationInfo(this);
    }

    public boolean deleteNotificationInfo(){
        return new UserOrGroupDelete().deleteNotificationInfo(this);
    }

    public Integer getNotificationInfoId() {
        return notificationInfoId;
    }

    public void setNotificationInfoId(Integer notificationInfoId) {
        this.notificationInfoId = notificationInfoId;
    }
}
