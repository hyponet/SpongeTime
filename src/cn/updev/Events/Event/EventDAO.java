package cn.updev.Events.Event;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Events.Static.IEvent;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by hypo on 15-9-30.
 */
public class EventDAO {

    private Session session;

    public EventDAO() {

        this.session = HibernateSessionFactory.currentSession();
    }

    public IEvent getEventById(Integer eventId){

        return null;
    }

    public List<IEvent> getEventByUserId(Integer userId){

        return null;
    }

    public List<IEvent> getEventByEventGroupId(Integer eventGroupId){

        return null;
    }

    public List<IEvent> getEventByUserGroupId(Integer userGroupId){

        return null;
    }

    protected void finalize(){
        HibernateSessionFactory.closeSession();
    }
}
