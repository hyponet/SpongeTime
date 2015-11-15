package cn.updev.Events.Group;

import cn.updev.Events.Static.EventGroupWeight;
import cn.updev.Events.Static.IEvent;

import java.util.Date;
import java.util.List;

/**
 * Created by hypo on 15-11-14.
 */
public abstract class AbstractEventGroup {
    private Integer groupId;
    private List<IEvent> list;
    private String groupTitle;
    private Date createTime;
    private Date groupExpect;
    private Date finishTime;
    private EventGroupWeight weight;
    private Integer ownerId;

    public AbstractEventGroup(Date groupExpect, Integer groupId, String groupTitle, List<IEvent> list, Integer ownerId, EventGroupWeight weight) {
        this.groupExpect = groupExpect;
        this.groupId = groupId;
        this.groupTitle = groupTitle;
        this.list = list;
        this.ownerId = ownerId;
        this.weight = weight;

        this.createTime = new Date();
        this.finishTime = null;

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

    public List<IEvent> getList() {
        return list;
    }

    public void setList(List<IEvent> list) {
        this.list = list;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public EventGroupWeight getWeight() {
        return weight;
    }

    public void setWeight(EventGroupWeight weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEventGroup)) return false;

        AbstractEventGroup that = (AbstractEventGroup) o;

        return !(getGroupId() != null ? !getGroupId().equals(that.getGroupId()) : that.getGroupId() != null);

    }

    @Override
    public int hashCode() {
        return getGroupId() != null ? getGroupId().hashCode() : 0;
    }
}
