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

    public TeamEventGroup(Date groupExpect, Integer groupId, String groupTitle, List<IEvent> list, Integer ownerId, EventGroupWeight weight) {
        super(groupExpect, groupId, groupTitle, list, ownerId, weight);
    }
}
