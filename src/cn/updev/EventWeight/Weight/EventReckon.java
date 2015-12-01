package cn.updev.EventWeight.Weight;

import cn.updev.Events.Event.EventDAO;
import cn.updev.Events.Group.EventGroupDAO;
import cn.updev.Events.Group.EventGroupInfo;
import cn.updev.Events.Static.IEvent;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 事件组完成时间预测
 * 事件组每个事件权重计算
 * Created by hypo on 15-11-25.
 */
public class EventReckon {

    private Integer groupId;
    private EventGroupInfo groupInfo;
    private List<IEvent> events;
    private Date reckonFinishTime;
    private Map<Long, Date> expectTime;
    private Map<Long, Date> reckonTime;
    private Map<Long, Double> weight;

    public EventReckon(Integer groupId) {
        this.groupId = groupId;

        EventGroupDAO groupDAO = new EventGroupDAO();
        this.groupInfo = groupDAO.getEventGroupInfo(groupId);

        EventDAO eventDAO = new EventDAO();
        this.events = eventDAO.getEventByEventGroupId(groupId);

        updateExpectTime();
        updateReckonTime();
        updateWeight();
    }

    private void updateExpectTime(){
        this.expectTime = new HashMap<Long, Date>();
        if(events.size() < 1){
            return;
        }

        Long groupExpectTime = groupInfo.getGroupExpect().getTime();
        Long groupCreateTime = groupInfo.getCreateTime().getTime();

        Long firstEventFinishTime = null;
        if(events.get(0).isFinish()){
            firstEventFinishTime = events.get(0).getFinishTime().getTime();
        }
        Long startTime;

        if(firstEventFinishTime == null){
            startTime = groupCreateTime;
        }else {
            startTime = groupCreateTime + (firstEventFinishTime - groupCreateTime) / 2;
        }

        Long aveTime = (groupExpectTime - startTime) / events.size();

        Integer order = 1;
        for(IEvent event : events){

            Long touchDate = event.getCreateTime().getTime();
            Long groupDate = groupInfo.getCreateTime().getTime();
            if(touchDate/(1000 * 60) == groupDate/(1000 * 60)){

                expectTime.put(event.getEventId(), new Date(startTime + aveTime * order));
            }else {

                expectTime.put(event.getEventId(), event.getExpectTime());
            }
            order++;
        }
    }

    private void updateReckonTime(){

        this.reckonTime = new HashMap<Long, Date>();
        if(events.size() < 1){
            return;
        }

        Long firstEventFinishTime = null;
        if(events.get(0).isFinish()){
            firstEventFinishTime = events.get(0).getFinishTime().getTime();
        }
        Long groupCreateTime = groupInfo.getCreateTime().getTime();
        Long startTime;

        if(firstEventFinishTime == null){
            startTime = groupCreateTime;
        }else {
            startTime = groupCreateTime + (firstEventFinishTime - groupCreateTime) / 2;
        }

        EventGroupDAO groupDAO = new EventGroupDAO();

        Integer unFinishEventNum = groupDAO.getUnFinishEventNum(groupId);
        Long aveTime;
        if(unFinishEventNum == 0){

            aveTime = 0L;
        }else if(unFinishEventNum == events.size()){

            aveTime = new Date().getTime() - groupCreateTime;
        }else {

            aveTime = (new Date().getTime() - startTime) / (events.size() - unFinishEventNum);
        }

        if(unFinishEventNum == 0){

            this.reckonFinishTime = events.get(events.size() - 1).getFinishTime();
        }else {

            this.reckonFinishTime = new Date(new Date().getTime() + aveTime * unFinishEventNum);
        }

        int order = 1;
        for (IEvent event : events){
            if(event.isFinish()){

                reckonTime.put(event.getEventId(), event.getFinishTime());
            }else {

                reckonTime.put(event.getEventId(), new Date(new Date().getTime() + aveTime * order));
            }
            order++;
        }
    }

    private void updateWeight(){
        this.weight = new HashMap<Long, Double>();

        Double dmax = Double.MIN_VALUE;
        Double dmin = Double.MAX_VALUE;

        for(IEvent event : events){
            Double baseWeight = (event.getWeight().ordinal() + 1) * 2.5 + (groupInfo.getWeight().ordinal() + 1) * 25;
            Long subTime = expectTime.get(event.getEventId()).getTime() - reckonTime.get(event.getEventId()).getTime();
            subTime /= 3600000 * 24;
            Double addPower;

            if(subTime >= 0){
                // 可能提前完成
                if(subTime > 7){
                    // 如果有可能提前一周
                    addPower = -subTime * 1.0 - 10;
                }else {
                    addPower = -subTime * 2.0;
                }
            }else {
                subTime = -subTime;
                // 可能延期完成
                if(subTime > 7){
                    // 如果延期超过一周
                    addPower = subTime * 1.0 + 20;
                }else {
                    addPower = subTime * 3.0;
                }
            }

            Double eventWeight = baseWeight + addPower;

            if(eventWeight > dmax){
                dmax = eventWeight;
            }

            if(eventWeight < dmin){
                dmin = eventWeight;
            }

            weight.put(event.getEventId(), eventWeight);
        }

        Double sub = events.size() - (dmax - dmin);

        for (IEvent event : events){

            Double eventWeight = weight.get(event.getEventId());
            eventWeight += sub--;
            weight.put(event.getEventId(), eventWeight);
        }
    }


    public List<IEvent> getEvents() {
        return events;
    }

    public Date getReckonFinishTime() {
        return reckonFinishTime;
    }

    public void setReckonFinishTime(Date reckonFinishTime) {
        this.reckonFinishTime = reckonFinishTime;
    }

    public void setEvents(List<IEvent> events) {
        this.events = events;
    }

    public Map<Long, Date> getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Map<Long, Date> expectTime) {
        this.expectTime = expectTime;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public EventGroupInfo getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(EventGroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }

    public Map<Long, Date> getReckonTime() {
        return reckonTime;
    }

    public void setReckonTime(Map<Long, Date> reckonTime) {
        this.reckonTime = reckonTime;
    }

    public Map<Long, Double> getWeight() {
        return weight;
    }

    public void setWeight(Map<Long, Double> weight) {
        this.weight = weight;
    }
}
