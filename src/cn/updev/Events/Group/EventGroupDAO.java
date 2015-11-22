package cn.updev.Events.Group;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Events.Event.EventDAO;
import cn.updev.Events.Static.IEvent;
import cn.updev.Events.Static.ITeamEvents;
import cn.updev.Events.Static.IUserEvents;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hypo on 15-11-18.
 */
public class EventGroupDAO {

    private Session session;

    public EventGroupDAO() {

        this.session = HibernateSessionFactory.currentSession();
        this.session.clear();
    }

    public List<UserEventGroup> getAllUserEventGroup(Integer userId){

        Query query = session.createQuery("from EventGroupInfo info where info.ownerId=" + userId);
        List<EventGroupInfo> list = (List<EventGroupInfo>)query.list();

        if(list.size() == 0){
            return null;
        }

        List<UserEventGroup> rnt = new ArrayList<UserEventGroup>();
        for(EventGroupInfo groupInfo : list){
            List<IEvent> events = new EventDAO().getEventByEventGroupId(groupInfo.getGroupId());
            if(events != null){

                rnt.add(new UserEventGroup(groupInfo, events));
            }
        }
        return rnt;
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
