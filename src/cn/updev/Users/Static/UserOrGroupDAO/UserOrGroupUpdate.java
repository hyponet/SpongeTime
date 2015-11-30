package cn.updev.Users.Static.UserOrGroupDAO;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Users.Group.GroupInfo.GroupInfo;
import cn.updev.Users.User.GroupUser;
import cn.updev.Users.User.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 15-11-25.
 */
public class UserOrGroupUpdate {
    public boolean updateUser(User user){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }

    public boolean updateGroupUser(GroupUser groupUser){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.update(groupUser);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }

    public boolean updateGroupInfo(GroupInfo groupInfo){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.update(groupInfo);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
}
