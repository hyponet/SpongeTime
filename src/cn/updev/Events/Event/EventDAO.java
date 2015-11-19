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

    private Session session;

    public EventDAO() {

        this.session = HibernateSessionFactory.currentSession();
    }

    public IEvent getEventById(Long eventId){
        Query query =session.createQuery("from Event e where e.eventId=" + eventId);

        if(query.list().size() == 0){
            return null;
        }
        IEvent rnt = (IEvent) query.list().get(0);
        return rnt;
    }

    public List<IEvent> getEventByUserId(Integer userId){

        Query query =session.createQuery("from Event e where e.doerId=" + userId);

        return (List<IEvent>) query.list();
    }

    public List<IEvent> getEventByEventGroupId(Integer eventGroupId){

        Query query =session.createQuery("from Event e where e.groupId=" + eventGroupId);

        return (List<IEvent>) query.list();
    }

    public List<IEvent> getEventByUserGroupId(Integer userGroupId){

        return null;
    }

    public Boolean eventFinish(Long eventId){

        IEvent event = getEventById(eventId);
        if(event.isFinish()){
            event.setFinishTime(new Date());

            session.update(event);

            return true;
        }else {
            event.setFinishTime(null);

            session.update(event);

            return false;
        }
    }

    protected void finalize(){
        HibernateSessionFactory.closeSession();
    }
}
