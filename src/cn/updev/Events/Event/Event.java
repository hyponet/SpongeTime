package cn.updev.Events.Event;


import cn.updev.Events.Static.EventWeight;
import cn.updev.Events.Static.IEvent;

import java.sql.Timestamp;

/**
 * Created by hypo on 15-9-28.
 */
public class Event implements IEvent{

    private long eventId;
    private String eventTitle;
    private Timestamp createTime;
    private Timestamp expectTime;
    private Timestamp finishTime;
    private EventWeight weight;
    private int ownerId;
    private int doerId;
    private int enderId;
    private int groupId;

    public Event(Timestamp createTime, int doerId, int enderId, long eventId, String eventTitle,
                 Timestamp expectTime, Timestamp finishTime, int groupId, int ownerId, EventWeight weight) {
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

    public int getDoerId() {
        return doerId;
    }

    public void setDoerId(int doerId) {
        this.doerId = doerId;
    }

    public int getEnderId() {
        return enderId;
    }

    public void setEnderId(int enderId) {
        this.enderId = enderId;
    }

    public long getEventId() {
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
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
