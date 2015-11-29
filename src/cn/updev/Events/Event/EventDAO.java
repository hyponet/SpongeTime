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
        HibernateSessionFactory.closeSession();
        return rnt;
    }

    public List<IEvent> getUnfinishEventByUserId(Integer userId){

        Session session = HibernateSessionFactory.currentSession();
        Query query =session.createQuery("from Event e where e.doerId=" + userId + " and e.finishTime = NULL");
        List<IEvent> list = query.list();

        HibernateSessionFactory.closeSession();

        return list;
    }

    public List<IEvent> getFinishEventByUserId(Integer userId){

        Session session = HibernateSessionFactory.currentSession();
        Query query =session.createQuery("from Event e where e.doerId=" + userId + " and e.finishTime != NULL");
        List<IEvent> list = query.list();

        HibernateSessionFactory.closeSession();

        return list;
    }

    public List<IEvent> getSingleEventByUserId(Integer userId){

        Session session = HibernateSessionFactory.currentSession();
        Query query =session.createQuery("from Event e where e.doerId=" + userId + " and e.groupId = NULL");
        List<IEvent> list = query.list();

        HibernateSessionFactory.closeSession();

        return list;
    }

    public List<IEvent> getEventByUserId(Integer userId){

        Session session = HibernateSessionFactory.currentSession();
        Query query =session.createQuery("from Event e where e.doerId=" + userId);
        List<IEvent> list = query.list();

        HibernateSessionFactory.closeSession();

        return list;
    }

    public List<IEvent> getEventByEventGroupId(Integer eventGroupId){

        Session session = HibernateSessionFactory.currentSession();
        Query query =session.createQuery("from Event e where e.groupId=" + eventGroupId);
        List<IEvent> list = query.list();
        HibernateSessionFactory.closeSession();

        return list;
    }

    public List<IEvent> getEventByUserGroupId(Integer userGroupId){

        Session session = HibernateSessionFactory.currentSession();
        HibernateSessionFactory.closeSession();
        return null;
    }

    public Integer getAllUserEventNum(Integer userId){
        Session session = HibernateSessionFactory.currentSession();
        String hql = "select count(*) from Event e where e.ownerId=" + userId;
        Query query =session.createQuery(hql);
        Integer rnt = ((Number)query.uniqueResult()).intValue();

        HibernateSessionFactory.closeSession();
        return rnt;
    }
    public Integer getUnFinishUserEventNum(Integer userId){

        Session session = HibernateSessionFactory.currentSession();
        String hql = "select count(*) from Event e where e.ownerId=" + userId +" and e.finishTime=null";
        Query query =session.createQuery(hql);
        Integer rnt = ((Number)query.uniqueResult()).intValue();

        HibernateSessionFactory.closeSession();
        return rnt;
    }
    public Integer getAllTeamEventNum(Integer userId){

        return 0;
    }
    public Integer getUnFinishteamEventNum(Integer userId){

        return 0;
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
