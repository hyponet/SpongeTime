package cn.updev.Events.Group;

import cn.updev.Events.Static.EventWeight;
import cn.updev.Events.Static.IEvent;

import java.util.Date;
import java.util.List;

/**
 * Created by hypo on 15-11-14.
 */
public abstract class AbstractEventGroup {
    private EventGroupInfo groupInfo;
    private List<IEvent> list;

    public AbstractEventGroup(EventGroupInfo groupInfo, List<IEvent> list) {
        this.groupInfo = groupInfo;
        this.list = list;
    }

    public AbstractEventGroup(Date groupExpect, String groupTitle, List<IEvent> list, Integer ownerId, EventWeight weight) {

        this.groupInfo = new EventGroupInfo(groupExpect, groupTitle, ownerId, weight);
        this.list = list;

    }

    public EventGroupInfo getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(EventGroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }

    public List<IEvent> getList() {
        return list;
    }

    public void setList(List<IEvent> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEventGroup)) return false;

        AbstractEventGroup that = (AbstractEventGroup) o;

        if (getGroupInfo() != null ? !getGroupInfo().equals(that.getGroupInfo()) : that.getGroupInfo() != null)
            return false;
        return !(getList() != null ? !getList().equals(that.getList()) : that.getList() != null);

    }

    @Override
    public int hashCode() {
        int result = getGroupInfo() != null ? getGroupInfo().hashCode() : 0;
        result = 31 * result + (getList() != null ? getList().hashCode() : 0);
        return result;
    }
}
