package cn.updev.Users.Static.UserOrGroupDAO;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 15-11-26.
 */
public class UserOrGroupDelete {
    public boolean deleteGroupMemberByName(String userName,Integer groupId){
        IUser iUser = new UserOrGroupQuery().queryUserByName(userName);
        Integer userId = iUser.getUserId();
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete("from GroupUser groupUser where groupUser.groupid="+groupId+" && userId ="+userId);
        session.clear();
        session.flush();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
    public boolean deleteGroupInfoById(Integer groupId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete("from GroupInfo groupInfo where groupInfo.groupId="+"groupId");
        session.clear();
        session.flush();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
    public boolean deleteGroupMemberAllById(Integer groupId){//用于解散一个团队
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete("from GroupUser groupUser where groupUser.groupId="+groupId);
        session.clear();
        session.flush();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
    public boolean deleteUserById(Integer userId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete("from User user where user.userId="+userId);
        session.clear();
        session.flush();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
    public boolean deleteUserByEMail(String eMail){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete("from User user where user.eMail='"+eMail+"'");
        session.clear();
        session.flush();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
}
