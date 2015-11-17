package cn.updev.Events.Group;

import cn.updev.Events.Static.EventGroupWeight;
import cn.updev.Events.Static.IEvent;
import cn.updev.Events.Static.ITeamEvents;

import java.util.Date;
import java.util.List;

/**
 * Created by hypo on 15-11-17.
 */
public class TeamEventGroup extends AbstractEventGroup implements ITeamEvents {

    public TeamEventGroup(Date groupExpect, String groupTitle, List<IEvent> list, Integer ownerId, EventGroupWeight weight) {
        super(groupExpect, groupTitle, list, ownerId, weight);
    }

    public TeamEventGroup(EventGroupInfo groupInfo, List<IEvent> list) {
        super(groupInfo, list);
    }
}
