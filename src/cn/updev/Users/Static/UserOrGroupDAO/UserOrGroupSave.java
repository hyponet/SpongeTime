package cn.updev.Users.Static.UserOrGroupDAO;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Users.User.GroupUser;
import cn.updev.Users.User.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 15-11-24.
 */
public class UserOrGroupSave {

    public User saveUser(User user){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return user;
    }

    public GroupUser saveGroupUser(GroupUser groupUser){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.save(groupUser);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return groupUser;
    }
}
