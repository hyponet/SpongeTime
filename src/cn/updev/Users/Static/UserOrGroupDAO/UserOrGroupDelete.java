package cn.updev.Users.Static.UserOrGroupDAO;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupInfo;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupMemberInviteInfo;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupUser;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import cn.updev.Users.User.GroupUser;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

/**
 * Created by blf2 on 15-11-26.
 */
public class UserOrGroupDelete {
    public boolean deleteGroupMemberByName(String userName,Integer groupId){
        IUser iUser = new UserOrGroupQuery().queryUserByName(userName);
        IGroupUser iGroupUser = new UserOrGroupQuery().queryGroupUser(iUser.getUserId(),groupId);
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(iGroupUser);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }

    public boolean deleteGroupMemberById(Integer userId,Integer groupId){
        IGroupUser iGroupUser = new UserOrGroupQuery().queryGroupUser(userId,groupId);
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(iGroupUser);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }

    public boolean deleteGroupInfoById(Integer groupId){
        IGroupInfo iGroupInfo = new UserOrGroupQuery().queryGroupInfoById(groupId);
        deleteGroupMemberAllById(groupId);
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(iGroupInfo);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
    private boolean deleteGroupMemberAllById(Integer groupId){//用于解散一个团队
        List<GroupUser> list = new UserOrGroupQuery().queryGroupMemberInfoAll(groupId);
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Iterator<GroupUser>iter = list.iterator();
        while(iter.hasNext()) {
            session.delete(iter.next());
        }
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
    private boolean deleteUserAllGroup(Integer userId){
        List<GroupUser>list = new UserOrGroupQuery().queryGroupAllUserJoined(userId);
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Iterator<GroupUser> iter = list.iterator();
        while(iter.hasNext()){
            session.delete(iter.next());
        }
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
    public boolean deleteUserById(Integer userId){
        IUser iUser = new UserOrGroupQuery().queryUserById(userId);
        deleteUserAllGroup(userId);
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(iUser);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
    public boolean deleteUserByEMail(String eMail){
        IUser iUser = new UserOrGroupQuery().queryUserByEMail(eMail);
        deleteUserAllGroup(iUser.getUserId());
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(iUser);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }

    public boolean deleteGroupMemberInviteInfo(IGroupMemberInviteInfo iGroupMemberInviteInfo){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(iGroupMemberInviteInfo);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
}
