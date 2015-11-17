package cn.updev.Events.Group;

import java.util.Date;

/**
 * Created by hypo on 15-11-17.
 */
public class EventsGroup {

    private Integer egId;
    private Long eventId;
    private Integer groupId;
    private Integer userId;
    private Boolean isFinish;
    private Date finishTime;

    public EventsGroup(Long eventId, Integer groupId, Integer userId) {
        this.eventId = eventId;
        this.groupId = groupId;
        this.userId = userId;
    }

    public EventsGroup() {
    }

    public Integer getEgId() {
        return egId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Boolean getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Boolean isFinish) {
        this.isFinish = isFinish;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
