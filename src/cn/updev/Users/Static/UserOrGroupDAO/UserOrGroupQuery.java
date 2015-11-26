package cn.updev.Users.Static.UserOrGroupDAO;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Users.Group.GroupInfo.GroupInfo;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupInfo;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import cn.updev.Users.User.GroupUser;
import cn.updev.Users.User.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by blf2 on 15-11-24.
 */
public class UserOrGroupQuery {

    public IUser queryUserByEMail(String eMail){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User user where user.eMail='" + eMail +"'");
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
    public IUser queryUserById(Integer userId){
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
    public IUser queryUserByName(String userName){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User user where user.userName='" + userName+"'");
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
    public IGroupInfo queryGroupInfoByName(String groupName){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from  GroupInfo groupInfo where groupInfo.groupName = '" + groupName+ "'");
        if(query.list().size() == 0){
            return null;
        }
        GroupInfo groupInfo = (GroupInfo)query.list().get(0);
        session.clear();
        session.flush();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return groupInfo;
    }

    public List<GroupUser> queryGroupMemberInfoAll(Integer groupId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from  GroupUser groupUser where groupUser.groupId = " + groupId);
        if(query.list().size() == 0){
            return null;
        }
        LinkedList <GroupUser> list = (LinkedList <GroupUser>)query.list();
        session.clear();
        session.flush();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }
}
