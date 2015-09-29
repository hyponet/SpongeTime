package cn.updev.Events.Static;

import java.sql.Timestamp;

/**
 * Created by hypo on 15-9-28.
 */
public interface IEvent {

    Timestamp getCreateTime();
    Integer getDoerId();
    void setDoerId(Integer doerId);
    Integer getEnderId();
    void setEnderId(Integer enderId);
    Long getEventId();
    String getEventTitle();
    void setEventTitle(String eventTitle);
    Timestamp getExpectTime();
    void setExpectTime(Timestamp expectTime);
    Timestamp getFinishTime();
    void setFinishTime(Timestamp finishTime);
    Integer getGroupId();
    void setGroupId(Integer groupId);
    Integer getOwnerId();
    void setOwnerId(Integer ownerId);
    EventWeight getWeight();
    void setWeight(EventWeight weight);
}
