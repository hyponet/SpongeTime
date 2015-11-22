package cn.updev.Events.Group;

import cn.updev.Events.Static.EventWeight;

import java.util.Date;

/**
 * Created by hypo on 15-11-17.
 */
public class EventGroupInfo {

    private Integer groupId;
    private String groupTitle;
    private Date createTime;
    private Date groupExpect;
    private Date finishTime;
    private Integer ownerId;
    private Integer teamId;
    private EventWeight weight;

    public EventGroupInfo() {
    }

    public EventGroupInfo(Date groupExpect, String groupTitle, Integer ownerId, EventWeight weight) {
        this.createTime = new Date();
        this.groupExpect = groupExpect;
        this.groupTitle = groupTitle;
        this.ownerId = ownerId;
        this.weight = weight;
        this.teamId = null;
    }

    public EventGroupInfo(Date groupExpect, String groupTitle, Integer ownerId, EventWeight weight, Integer teamId) {
        this.createTime = new Date();
        this.groupExpect = groupExpect;
        this.groupTitle = groupTitle;
        this.ownerId = ownerId;
        this.weight = weight;
        this.teamId = teamId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getGroupExpect() {
        return groupExpect;
    }

    public void setGroupExpect(Date groupExpect) {
        this.groupExpect = groupExpect;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public EventWeight getWeight() {
        return weight;
    }

    public void setWeight(EventWeight weight) {
        this.weight = weight;
    }
}
