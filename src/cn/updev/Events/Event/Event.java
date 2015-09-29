package cn.updev.Events.Event;


import cn.updev.Events.Static.EventWeight;
import cn.updev.Events.Static.IEvent;

import java.sql.Timestamp;

/**
 * Created by hypo on 15-9-28.
 */
public class Event implements IEvent{

    private Long eventId;
    private String eventTitle;
    private Timestamp createTime;
    private Timestamp expectTime;
    private Timestamp finishTime;
    private EventWeight weight;
    private Integer ownerId;
    private Integer doerId;
    private Integer enderId;
    private Integer groupId;

    public Event(Timestamp createTime, Integer doerId, Integer enderId, Long eventId, String eventTitle,
                 Timestamp expectTime, Timestamp finishTime, Integer groupId, Integer ownerId, EventWeight weight) {
        this.createTime = createTime;
        this.doerId = doerId;
        this.enderId = enderId;
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.expectTime = expectTime;
        this.finishTime = finishTime;
        this.groupId = groupId;
        this.ownerId = ownerId;
        this.weight = weight;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
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

    public Timestamp getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Timestamp expectTime) {
        this.expectTime = expectTime;
    }

    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
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
}
