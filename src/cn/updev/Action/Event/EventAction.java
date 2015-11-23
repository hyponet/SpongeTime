package cn.updev.Action.Event;

import cn.updev.Events.Event.EventFactory;
import cn.updev.Events.Static.EventWeight;
import cn.updev.Events.Static.IEvent;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

/**
 * Created by hypo on 15-11-19.
 */
public class EventAction extends ActionSupport {

    private String eventTitle;
    private Date expectTime;
    private Integer weight;

    public String execute() throws Exception {

        if(this.eventTitle == null || this.eventTitle.trim().length() == 0){
            return INPUT;
        }

        // 获得Session下的已经登录用户的ID
        int ownerId = 1;

        //权重
        EventWeight eventWeight = EventWeight.values()[this.weight];

        //创建事件
        EventFactory factory = new EventFactory(this.eventTitle, this.expectTime, ownerId, eventWeight);
        IEvent event = factory.getEvent();

        if(event != null){
            return SUCCESS;
        }

        return ERROR;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
