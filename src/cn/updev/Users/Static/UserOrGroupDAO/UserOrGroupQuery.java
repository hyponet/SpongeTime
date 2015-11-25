package cn.updev.Users.Static.UserOrGroupDAO;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Users.User.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 15-11-24.
 */
public class UserOrGroupQuery {

    public User queryUserByEMail(String eMail){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User user where user.eMail=" + eMail);
        if(query.list().size() == 0){
            return null;
        }
        User user = (User)query.list().get(0);
        session.clear();
        session.flush();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return user;
    }
    public User queryUserById(Integer userId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User user where user.userId=" + userId);
        if(query.list().size() == 0){
            return null;
        }
        User user = (User)query.list().get(0);
        session.clear();
        session.flush();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return user;
    }
}
