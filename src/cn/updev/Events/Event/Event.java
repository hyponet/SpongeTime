package cn.updev.Events.Event;


import cn.updev.Events.Static.EventWeight;
import cn.updev.Events.Static.IEvent;

import java.util.Date;

/**
 * Created by hypo on 15-9-28.
 */

public class Event implements IEvent{

    private Long eventId;
    private String eventTitle;
    private Date createTime;
    private Date expectTime;
    private Date finishTime;
    private EventWeight weight;
    private Integer ownerId;
    private Integer doerId;
    private Integer enderId;
    private Integer groupId;

    public Event(){

    }

    public Event(Integer doerId, String eventTitle, Date expectTime, Integer groupId,
                 Integer ownerId, EventWeight weight) {
        this.createTime = new Date();
        this.doerId = doerId;
        this.eventTitle = eventTitle;
        this.expectTime = expectTime;
        this.groupId = groupId;
        this.ownerId = ownerId;
        this.weight = weight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDoerId() {
        return doerId;
    }

    public void setDoerId(Integer doerId) {
        this.doerId = doerId;
    }

    public Integer getEnderId() {
        return enderId;
    }

    public void setEnderId(Integer enderId) {
        this.enderId = enderId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public Date getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Date expectTime) {
        this.expectTime = expectTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Boolean isFinish(){
        return (this.finishTime != null);
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public EventWeight getWeight() {
        return weight;
    }

    public void setWeight(EventWeight weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        return getEventId() == event.getEventId();

    }

    @Override
    public int hashCode() {
        return (int) (getEventId() ^ (getEventId() >>> 32));
    }

    @Override
    public String toString() {
        return "Event{" +
                "createTime=" + createTime +
                ", eventId=" + eventId +
                ", eventTitle='" + eventTitle + '\'' +
                ", expectTime=" + expectTime +
                ", finishTime=" + finishTime +
                ", weight=" + weight +
                ", ownerId=" + ownerId +
                ", doerId=" + doerId +
                ", enderId=" + enderId +
                ", groupId=" + groupId +
                '}';
    }
}
