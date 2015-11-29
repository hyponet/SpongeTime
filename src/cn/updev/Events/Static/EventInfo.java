package cn.updev.Events.Static;

import cn.updev.EventWeight.Weight.EventWeightManage;
import cn.updev.Events.Group.EventGroupDAO;
import cn.updev.Events.Group.EventGroupInfo;

import java.util.Date;

/**
 * Created by hypo on 15-11-27.
 */
public class EventInfo {
    private Long eventId;
    private String eventTitle;
    private Date createTime;
    private Date reckonTime;
    private Date expectTime;
    private Date userExpectTime;
    private Date finishTime;
    private EventWeight weight;
    private Integer ownerId;
    private Integer doerId;
    private Integer enderId;
    private String status;
    private Integer groupId;
    private String groupTitle;

    public EventInfo(IEvent event) {
        this.eventId = event.getEventId();
        this.eventTitle = event.getEventTitle();
        this.createTime = event.getCreateTime();
        this.finishTime = event.getFinishTime();
        this.weight = event.getWeight();
        this.ownerId = event.getOwnerId();
        this.doerId = event.getDoerId();
        this.enderId = event.getEnderId();
        this.groupId = event.getGroupId();
        this.groupTitle = event.getEventTitle();
        this.userExpectTime = event.getExpectTime();

        setReckonTime();
        setStatus();

        if(groupId != null){

            EventGroupDAO groupDAO = new EventGroupDAO();
            EventGroupInfo group = groupDAO.getEventGroupInfo(groupId);
            this.groupTitle = group.getGroupTitle();
        }else {
            this.groupTitle = null;
        }
    }

    private void setReckonTime(){
        EventWeightManage weightManage = new EventWeightManage();
        cn.updev.EventWeight.Weight.EventWeight weight = weightManage.getEventWeight(this.eventId);
        this.expectTime = weight.getEventExpect();
        this.reckonTime = weight.getEventReckon();
    }

    private void setStatus(){

        if(isFinish()){
            this.status = "已完成";
        }else {
            Date now = new Date();
            Long nowLong = now.getTime();
            Long expectLong = expectTime.getTime();
            Long reckonLong = reckonTime.getTime();

            if(nowLong > expectLong){
                status = "超期";
            }else {
                if(reckonLong < expectLong){
                    status = "进行中";
                }else {
                    status = "可能超期";
                }
            }
        }
    }

    public Boolean isFinish(){
        return (this.finishTime != null);
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getDoerId() {
        return doerId;
    }

    public Integer getEnderId() {
        return enderId;
    }

    public Long getEventId() {
        return eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public Date getExpectTime() {
        return expectTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public EventWeight getWeight() {
        return weight;
    }

    public Date getReckonTime() {
        return reckonTime;
    }

    public String getStatus() {
        return status;
    }

    public Date getUserExpectTime() {
        return userExpectTime;
    }
}
