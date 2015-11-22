package cn.updev.Events.Static;

import cn.updev.Events.Group.EventGroupInfo;

import java.util.List;

/**
 * Created by hypo on 15-11-14.
 */
public interface IUserEvents {
    EventGroupInfo getGroupInfo();
    List<IEvent> getList();
}
