package cn.updev.Events.Static;

import java.util.Date;

/**
 * Created by hypo on 15-9-28.
 */
public interface IEvent {

    Date getCreateTime();
    void setCreateTime(Date createTime);
    Integer getDoerId();
    void setDoerId(Integer doerId);
    Integer getEnderId();
    void setEnderId(Integer enderId);
    Long getEventId();
    String getEventTitle();
    void setEventTitle(String eventTitle);
    Date getExpectTime();
    void setExpectTime(Date expectTime);
    Date getFinishTime();
    void setFinishTime(Date finishTime);
    Boolean isFinish();
    Integer getGroupId();
    void setGroupId(Integer groupId);
    Integer getOwnerId();
    void setOwnerId(Integer ownerId);
    EventWeight getWeight();
    void setWeight(EventWeight weight);
}
