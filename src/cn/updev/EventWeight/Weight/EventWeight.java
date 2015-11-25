package cn.updev.EventWeight.Weight;

import java.util.Date;

/**
 * Created by hypo on 15-11-25.
 */
public class EventWeight {

    private Long id;
    private Long eventId;
    private Integer groupId;
    private Double eventWeight;
    private Date eventExpect;
    private Date eventReckon;
    private Date updateTime;

    public EventWeight() {
    }

    public EventWeight(Date eventExpect, Long eventId, Date eventReckon, Double eventWeight, Integer groupId, Date updateTime) {
        this.eventExpect = eventExpect;
        this.eventId = eventId;
        this.eventReckon = eventReckon;
        this.eventWeight = eventWeight;
        this.groupId = groupId;
        this.updateTime = updateTime;
    }

    public Date getEventExpect() {
        return eventExpect;
    }

    public void setEventExpect(Date eventExpect) {
        this.eventExpect = eventExpect;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Date getEventReckon() {
        return eventReckon;
    }

    public void setEventReckon(Date eventReckon) {
        this.eventReckon = eventReckon;
    }

    public Double getEventWeight() {
        return eventWeight;
    }

    public void setEventWeight(Double eventWeight) {
        this.eventWeight = eventWeight;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
