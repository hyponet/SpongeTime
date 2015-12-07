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

    public NotificationInfo(Integer notificationCreaterId,Integer notificationAccepterId,NotificationType type,
                            String notifucationBody,NotificationStatus status){
        this.notificationCreaterId = notificationCreaterId;
        this.notificationAccepterId = notificationAccepterId;
        this.notifucationBody = notifucationBody;
        this.type = type;
        this.status = status;
    }

    public Integer getNotificationInfoId() {
        return notificationInfoId;
    }

    public void setNotificationInfoId(Integer notificationInfoId) {
        this.notificationInfoId = notificationInfoId;
    }

    @Override
    public Integer getNotificationCreaterId() {
        return notificationCreaterId;
    }

    public void setNotificationCreaterId(Integer notificationCreaterId) {
        this.notificationCreaterId = notificationCreaterId;
    }

    @Override
    public Integer getNotificationAccepterId() {
        return notificationAccepterId;
    }

    public void setNotificationAccepterId(Integer notificationAccepterId) {
        this.notificationAccepterId = notificationAccepterId;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    @Override
    public String getNotifucationBody() {
        return notifucationBody;
    }

    @Override
    public void setNotifucationBody(String notifucationBody) {
        this.notifucationBody = notifucationBody;
    }

    @Override
    public NotificationStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public boolean isHasPushed(){
        if(status.isHasPushed()){
            return true;
        }
        return false;
    }
    public boolean isHasRead(){
        if(status.isHasRead())
            return true;
        return false;
    }
}
