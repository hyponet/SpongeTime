package cn.updev.Events.Static;

import java.sql.Timestamp;

/**
 * Created by hypo on 15-9-28.
 */
public interface IEvent {

    Timestamp getCreateTime();
    int getDoerId();
    void setDoerId(int doerId);
    int getEnderId();
    void setEnderId(int enderId);
    long getEventId();
    String getEventTitle();
    void setEventTitle(String eventTitle);
    Timestamp getExpectTime();
    void setExpectTime(Timestamp expectTime);
    Timestamp getFinishTime();
    void setFinishTime(Timestamp finishTime);
    int getGroupId();
    void setGroupId(int groupId);
    int getOwnerId();
    void setOwnerId(int ownerId);
    EventWeight getWeight();
    void setWeight(EventWeight weight);
}
