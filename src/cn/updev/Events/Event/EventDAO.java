package cn.updev.Events.Event;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Events.Static.IEvent;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

/**
 * Created by hypo on 15-9-30.
 */
public class EventDAO {

    public EventDAO() {

    }

    public IEvent getEventById(Long eventId){

        Session session = HibernateSessionFactory.currentSession();
        Query query =session.createQuery("from Event e where e.eventId=" + eventId);

        if(query.list().size() == 0){
            return null;
        }
        IEvent rnt = (IEvent) query.list().get(0);
        session.clear();
        session.flush();
        HibernateSessionFactory.closeSession();
        return rnt;
    }

    public List<IEvent> getSingleEventByUserId(Integer userId){

        Session session = HibernateSessionFactory.currentSession();
        Query query =session.createQuery("from Event e where e.doerId=" + userId + " and e.groupId = NULL");
        List<IEvent> list = query.list();

        session.clear();
        session.flush();
        HibernateSessionFactory.closeSession();

        return list;
    }

    public List<IEvent> getEventByUserId(Integer userId){

        Session session = HibernateSessionFactory.currentSession();
        Query query =session.createQuery("from Event e where e.doerId=" + userId);
        List<IEvent> list = query.list();

        session.clear();
        session.flush();
        HibernateSessionFactory.closeSession();

        return list;
    }

    public List<IEvent> getEventByEventGroupId(Integer eventGroupId){

        Session session = HibernateSessionFactory.currentSession();
        Query query =session.createQuery("from Event e where e.groupId=" + eventGroupId);
        List<IEvent> list = query.list();
        session.clear();
        session.flush();
        HibernateSessionFactory.closeSession();

        return list;
    }

    public List<IEvent> getEventByUserGroupId(Integer userGroupId){

        Session session = HibernateSessionFactory.currentSession();
        session.clear();
        session.flush();
        HibernateSessionFactory.closeSession();
        return null;
    }

    public Boolean eventFinish(Long eventId){

        Session session = HibernateSessionFactory.currentSession();
        IEvent event = getEventById(eventId);
        if(event.isFinish()){
            event.setFinishTime(new Date());

            session.update(event);

            session.clear();
            session.flush();
            HibernateSessionFactory.closeSession();

            return true;
        }else {
            event.setFinishTime(null);

            session.update(event);

            session.clear();
            session.flush();
            HibernateSessionFactory.closeSession();

            return false;
        }

    }
}
