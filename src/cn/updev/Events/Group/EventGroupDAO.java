package cn.updev.Events.Group;

import cn.updev.Database.HibernateSessionFactory;
import org.hibernate.Session;

/**
 * Created by hypo on 15-11-18.
 */
public class EventGroupDAO {

    private Session session;

    public EventGroupDAO() {

        this.session = HibernateSessionFactory.currentSession();
    }

    protected void finalize(){
        HibernateSessionFactory.closeSession();
    }

}
