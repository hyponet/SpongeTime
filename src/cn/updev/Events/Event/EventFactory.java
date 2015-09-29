package cn.updev.Events.Event;

import cn.updev.Events.Static.EventWeight;
import cn.updev.Events.Static.IEvent;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by hypo on 15-9-29.
 */
public class EventFactory {

    private String eventTitle;
    private Timestamp createTime;
    private Timestamp expectTime;
    private Timestamp finishTime;
    private EventWeight weight;
    private Integer ownerId;
    private Integer doerId;
    private Integer enderId;
    private Integer groupId;

    //个人事件添加
    public EventFactory(String eventTitle, Date expectTime,int ownerId, EventWeight weight) {
        this.eventTitle = eventTitle;
        this.expectTime = new Timestamp(expectTime.getTime());
        this.groupId = null;
        this.ownerId = ownerId;
        this.weight = weight;
    }

    //团队事件添加
    public EventFactory(String eventTitle, Date expectTime, int groupId, int ownerId, EventWeight weight) {
        this.eventTitle = eventTitle;
        this.expectTime = new Timestamp(expectTime.getTime());
        this.groupId = groupId;
        this.ownerId = ownerId;
        this.weight = weight;
    }

    public Timestamp getCreateTime() {
        createTime = new Timestamp(new Date().getTime());
        return createTime;
    }

    private Integer getDoerId() {
        doerId = ownerId;
        return doerId;
    }

    private Integer getEnderId() {
        enderId = null;
        return enderId;
    }

    private String getEventTitle() {

        if(eventTitle.length() > 20){
            eventTitle = eventTitle.substring(0,20);
        }

        return eventTitle;
    }

    private Timestamp getExpectTime() {

        return expectTime;
    }

    private Timestamp getFinishTime() {
        finishTime = null;
        return finishTime;
    }

    private Integer getGroupId() {
        return groupId;
    }

    private Integer getOwnerId() {
        return ownerId;
    }

    private EventWeight getWeight() {
        return weight;
    }

    public IEvent getEvent(){

        IEvent event = new Event(getCreateTime(),getDoerId(),getEnderId(),
                null,getEventTitle(),getExpectTime(),null,getGroupId(),getOwnerId(),getWeight());

        //事件数据持久化 并获得 事件ID


        return event;
    }
}
