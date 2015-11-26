package cn.updev.Users.Static.UserOrGroupDAO;

import cn.updev.Database.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 15-11-26.
 */
public class UserOrGroupDelete {
    public boolean deleteGroupMemberByName(String userName,Integer groupId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete("");
        session.clear();
        session.flush();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
}
