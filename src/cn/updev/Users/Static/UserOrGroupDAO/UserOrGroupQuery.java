package cn.updev.Users.Static.UserOrGroupDAO;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Users.Group.GroupInfo.GroupInfo;
import cn.updev.Users.Group.GroupInfo.GroupMemberInviteInfo;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupInfo;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupMemberInviteInfo;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupUser;
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
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return groupInfo;
    }
    public IGroupInfo queryGroupInfoById(Integer groupId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from  GroupInfo groupInfo where groupInfo.groupId = " + groupId);
        if(query.list().size() == 0){
            return null;
        }
        GroupInfo groupInfo = (GroupInfo)query.list().get(0);
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
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }
    public IGroupUser queryGroupUser(Integer userId,Integer groupId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from  GroupUser groupUser where groupUser.groupId = " + groupId +
                " and groupUser.userId="+userId);
        if(query.list().size() == 0){
            return null;
        }
       IGroupUser iGroupUser = (IGroupUser)query.list().get(0);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return iGroupUser;
    }
    public IGroupMemberInviteInfo queryGroupMemberInviteInfo(Integer inviterId,Integer inviteeId,Integer groupId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from  GroupMemberInviteInfo gmii where gmii.groupId = " + groupId +" and " +
                "gmii.inviteeId=" + inviterId +" and inviteeId="+inviteeId);
        if(query.list().size() == 0){
            return null;
        }
        GroupMemberInviteInfo groupMemberInviteInfo = (GroupMemberInviteInfo) query.list().get(0);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return groupMemberInviteInfo;
    }
    public List<GroupUser> queryGroupAllUserJoined(Integer userId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from  GroupUser groupUser where groupUser.userId = " + userId);
        if(query.list().size() == 0){
            return null;
        }
        LinkedList <GroupUser> list = (LinkedList <GroupUser>)query.list();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }
}
