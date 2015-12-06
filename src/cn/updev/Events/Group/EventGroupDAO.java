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

    public EventGroupDAO() {

    }

    public List<UserEventGroup> getAllUserEventGroup(Integer userId){

        Session session = HibernateSessionFactory.currentSession();
        Query query = session.createQuery("from EventGroupInfo info where info.ownerId=" + userId + " and info.teamId=null");
        List<EventGroupInfo> list = (List<EventGroupInfo>)query.list();

        if(list.size() == 0){
            return null;
        }

        List<UserEventGroup> rnt = new ArrayList<UserEventGroup>();
        for(EventGroupInfo groupInfo : list){

            query =session.createQuery("from Event e where e.groupId=" + groupInfo.getGroupId());
            List<IEvent> events = query.list();
            if (events != null) {

                rnt.add(new UserEventGroup(groupInfo, events));
            }
        }
        HibernateSessionFactory.closeSession();
        return rnt;
    }

    public EventGroupInfo getEventGroupInfo(Integer groupId){

        Session session = HibernateSessionFactory.currentSession();
        Query query =session.createQuery("from EventGroupInfo info where info.groupId=" + groupId);

        if(query.list().size() == 0){
            return null;
        }

        EventGroupInfo rnt = (EventGroupInfo) query.list().get(0);

        HibernateSessionFactory.closeSession();
        return rnt;
    }

    public ITeamEvents getTeamEventGroup(Integer groupId){

        Session session = HibernateSessionFactory.currentSession();
        Query query =session.createQuery("from EventGroupInfo info where info.groupId=" + groupId);

        if(query.list().size() == 0){
            return null;
        }

        query =session.createQuery("from Event e where e.groupId=" + groupId);
        List<IEvent> events = query.list();

        EventGroupInfo group = (EventGroupInfo)query.list().get(0);
        HibernateSessionFactory.closeSession();
        return new TeamEventGroup(group, events);
    }

    public IUserEvents getUserEventGroup(Integer groupId){

        Session session = HibernateSessionFactory.currentSession();
        Query query =session.createQuery("from EventGroupInfo info where info.groupId=" + groupId);

        if(query.list().size() == 0){
            return null;
        }

        Query getEvents =session.createQuery("from Event e where e.groupId=" + groupId);
        List<IEvent> events = getEvents.list();

        EventGroupInfo group = (EventGroupInfo)query.list().get(0);
        HibernateSessionFactory.closeSession();
        return new UserEventGroup(group, events);
    }

    public List<Integer> getUserEventGroupId(Integer userId){

        Session session = HibernateSessionFactory.currentSession();
        Query query =session.createQuery("select groupId from EventGroupInfo info where info.ownerId=" + userId);

        List<Integer> rnt = query.list();

        HibernateSessionFactory.closeSession();
        return rnt;
    }

    public Integer getUnFinishEventNum(Integer groupId){
        Session session = HibernateSessionFactory.currentSession();
        String hql = "select count(*) from Event e where e.groupId=" + groupId +" and e.finishTime=null";
        Query query =session.createQuery(hql);
        Integer rnt = ((Number)query.uniqueResult()).intValue();

        HibernateSessionFactory.closeSession();
        return rnt;
    }
}
