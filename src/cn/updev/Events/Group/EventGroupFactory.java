package cn.updev.Events.Group;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Events.Static.EventGroupWeight;
import cn.updev.Events.Static.IEvent;
import cn.updev.Events.Static.ITeamEvents;
import cn.updev.Events.Static.IUserEvents;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

/**
 * Created by hypo on 15-11-17.
 */
public class EventGroupFactory {

    private Date groupExpect;
    private Integer groupId;
    private String groupTitle;
    private List<IEvent> list;
    private Integer ownerId;
    private EventGroupWeight weight;

    public EventGroupFactory(Date groupExpect, String groupTitle, List<IEvent> list, Integer ownerId, EventGroupWeight weight) {
        this.groupExpect = groupExpect;
        this.groupTitle = groupTitle;
        this.list = list;
        this.ownerId = ownerId;
        this.weight = weight;
    }

    private Date getGroupExpect() {
        return groupExpect;
    }

    private Integer getGroupId() {
        return groupId;
    }

    private String getGroupTitle() {
        if(groupTitle.length() > 20){
            this.groupTitle = groupTitle.substring(0,20);
        }
        return groupTitle;
    }

    private List<IEvent> getList() {
        return list;
    }

    private Integer getOwnerId() {
        return ownerId;
    }

    private EventGroupWeight getWeight() {
        return weight;
    }

    private void save(){

        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();

        for(IEvent event : getList()){
            EventsGroup eventsGroup = new EventsGroup(event.getEventId(), event.getGroupId(), event.getDoerId());
            session.save(eventsGroup);
        }

        EventGroupInfo groupInfo = new EventGroupInfo(getGroupExpect(), getGroupTitle(), getOwnerId(), getWeight());

        transaction.commit();
        HibernateSessionFactory.closeSession();

        this.groupId = groupInfo.getGroupId();
    }

    public IUserEvents getUserEvents(){

        IUserEvents events = new UserEventGroup(getGroupExpect(), getGroupId(), getGroupTitle(),
                getList(), getOwnerId(), getWeight());

        save();

        return  events;
    }

    public ITeamEvents getTeamEvents(){

        ITeamEvents events = new TeamEventGroup(getGroupExpect(), getGroupId(), getGroupTitle(),
                getList(), getOwnerId(), getWeight());

        save();

        return  events;
    }
}
