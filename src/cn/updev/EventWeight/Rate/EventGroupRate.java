package cn.updev.EventWeight.Rate;

import cn.updev.EventWeight.Weight.EventWeightManage;
import cn.updev.Events.Event.EventDAO;
import cn.updev.Events.Group.EventGroupDAO;
import cn.updev.Events.Group.EventGroupInfo;
import cn.updev.Events.Static.EventWeight;
import cn.updev.Events.Static.IEvent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hypo on 15-11-24.
 */
public class EventGroupRate {

    private Integer eventGroupId;
    private String eventGroupTitle;
    private Integer evnetNum;
    private Integer finishEventNum;
    private Integer groupRate;
    private EventWeight weight;
    private String createTime;
    private String groupExpect;
    private Date finishTime;
    private Integer teamId;

    public EventGroupRate(Integer eventGroupId) {
        this.eventGroupId = eventGroupId;
        EventGroupDAO groupDAO = new EventGroupDAO();
        EventDAO eventDAO = new EventDAO();
        EventGroupInfo groupInfo = groupDAO.getEventGroupInfo(eventGroupId);
        this.eventGroupTitle = groupInfo.getGroupTitle();
        this.weight = groupInfo.getWeight();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.createTime = dateFormat.format(groupInfo.getCreateTime());
        this.groupExpect = dateFormat.format(groupInfo.getGroupExpect());
        this.teamId = groupInfo.getTeamId();

        List<IEvent> events = eventDAO.getEventByEventGroupId(eventGroupId);
        this.evnetNum = events.size();
        this.finishEventNum = 0;

        this.finishTime = null;
        for(IEvent event : events){
            if(event.isFinish()){
                this.finishEventNum++;
            }
            EventWeightManage eventWeight = new EventWeightManage();
            cn.updev.EventWeight.Weight.EventWeight weight = eventWeight.getEventWeight(event.getEventId());

            if(finishTime == null){
                finishTime = weight.getEventReckon();
            }else {
                Long temp = finishTime.getTime();
                Long next = weight.getEventReckon().getTime();

                if(next > temp){
                    finishTime = weight.getEventReckon();
                }
            }
        }
        this.groupRate = 100 * this.finishEventNum / this.evnetNum;
    }

    public Integer getEventGroupId() {
        return eventGroupId;
    }

    public String getEventGroupTitle() {
        return eventGroupTitle;
    }

    public Integer getEvnetNum() {
        return evnetNum;
    }

    public Integer getFinishEventNum() {
        return finishEventNum;
    }

    public Integer getGroupRate() {
        return groupRate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getGroupExpect() {
        return groupExpect;
    }

    public EventWeight getWeight() {
        return weight;
    }

    public String getFinishTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(finishTime);
    }

    public Integer getTeamId() {
        return teamId;
    }
}
