package cn.updev.Events.Group;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Events.Event.EventDAO;
import cn.updev.Events.Static.IEvent;
import cn.updev.Events.Static.ITeamEvents;
import cn.updev.Events.Static.IUserEvents;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by hypo on 15-11-18.
 */
public class EventGroupDAO {

    private Session session;

    public EventGroupDAO() {

        this.session = HibernateSessionFactory.currentSession();
    }

    public ITeamEvents getTeamEventGroup(Integer groupId){
        Query query =session.createQuery("from EventGroupInfo info where info.groupId=" + groupId);

        if(query.list().size() == 0){
            return null;
        }

        List<IEvent> events = new EventDAO().getEventByEventGroupId(groupId);
        EventGroupInfo group = (EventGroupInfo)query.list().get(0);
        return new TeamEventGroup(group, events);
    }

    public IUserEvents getUserEventGroup(Integer groupId){
        Query query =session.createQuery("from EventGroupInfo info where info.groupId=" + groupId);

        if(query.list().size() == 0){
            return null;
        }

        List<IEvent> events = new EventDAO().getEventByEventGroupId(groupId);
        EventGroupInfo group = (EventGroupInfo)query.list().get(0);
        return new UserEventGroup(group, events);
    }

    protected void finalize(){
        HibernateSessionFactory.closeSession();
    }

}
