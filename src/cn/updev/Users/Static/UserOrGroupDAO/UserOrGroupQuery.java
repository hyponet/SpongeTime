package cn.updev.Users.Static.UserOrGroupDAO;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Events.Group.EventGroupInfo;
import cn.updev.Events.Static.IEvent;
import cn.updev.Users.Group.GroupInfo.GroupInfo;
import cn.updev.Users.Group.GroupInfo.GroupMemberInviteInfo;
import cn.updev.Users.NotificationPush.NotificationInfo;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupInfo;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupMemberInviteInfo;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupUser;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import cn.updev.Users.User.GroupUser;
import cn.updev.Users.User.GroupUserInfo;
import cn.updev.Users.User.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
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

    public List<GroupUserInfo> queryGroupMemberInfoAll(Integer groupId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from  GroupUser groupUser where groupUser.groupId = " + groupId);

        List<GroupUserInfo> rnt = new ArrayList<GroupUserInfo>();

        if(query.list().size() == 0){
            return rnt;
        }
        List <GroupUser> list = query.list();

        for (GroupUser groupUser : list){

            query = session.createQuery("from  User u where u.userId = " + groupUser.getUserId());
            if(query.list().size() == 0){
                continue;
            }
            IUser user = (IUser) query.list().get(0);

            query = session.createQuery("from  GroupInfo groupInfo where groupInfo.groupId = " + groupId);
            if(query.list().size() == 0){
                continue;
            }
            IGroupInfo groupInfo = (IGroupInfo) query.list().get(0);

            Integer taskNum = 0;
            query = session.createQuery("from  EventGroupInfo groupInfo where groupInfo.teamId = " + groupId);

            List<EventGroupInfo> eventGroupInfos = query.list();
            for(EventGroupInfo eventGroupInfo : eventGroupInfos){
                query = session.createQuery("from  Event e where e.groupId = " + eventGroupInfo.getGroupId());
                if(query.list().size() == 0){
                    continue;
                }

                List<IEvent> events = query.list();
                for(IEvent event : events){
                    if(event.getDoerId() == user.getUserId()){
                        taskNum++;
                    }
                }
            }

            String rule;

            if(groupUser.isUser()){
                rule = "成员";
            }else if(groupUser.isAdmin()){
                rule = "管理员";
            }else if(groupUser.isCreater()){
                rule = "创建者";
            }else {
                rule = "火星群众";
            }

            GroupUserInfo userInfo = new GroupUserInfo(groupId, groupInfo.getGroupName(),user.geteMail(),
                    user.getUserId(),user.getNickName(),rule,taskNum);

            rnt.add(userInfo);
        }

        transaction.commit();
        HibernateSessionFactory.closeSession();
        return rnt;
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
    public List<IGroupInfo> queryGroupAllUserJoined(Integer userId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from  GroupUser groupUser where groupUser.userId = " + userId);

        List <IGroupInfo> rnt = new ArrayList<IGroupInfo>();
        if(query.list().size() == 0){
            return rnt;
        }
        List <GroupUser> list = query.list();
        Iterator<GroupUser> iterator = list.iterator();
        while(iterator.hasNext()){
            IGroupUser iGroupUser = (IGroupUser)iterator.next();
            query = session.createQuery("from  GroupInfo groupInfo where groupInfo.groupId = " + iGroupUser.getGroupId());
            if(query.list().size() == 0){
                continue;
            }
            GroupInfo iGroupInfo = (GroupInfo)query.list().get(0);
            rnt.add(iGroupInfo);
        }
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return rnt;
    }

    public List<NotificationInfo> queryNotification(Integer createrId,Integer accepterId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from  NotificationInfo nInfo where nInfo.notificationCreaterId = " + createrId+
                " and nInfo.notificationAccepterId="+accepterId);
        if(query.list().size() == 0){
            return null;
        }
        List <NotificationInfo> list = query.list();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }
    public List<NotificationInfo> queryNotificationAll(Integer accepterId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from  NotificationInfo nInfo where nInfo.notificationAccepterId ="+accepterId);
        if(query.list().size() == 0){
            return null;
        }
        List <NotificationInfo> list = query.list();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }
    public NotificationInfo queryNotificationById(Integer notificationInfoId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from  NotificationInfo nInfo where nInfo.notificationInfoId ="+notificationInfoId);
        if(query.list().size() == 0){
            return null;
        }
        NotificationInfo notificationInfo = (NotificationInfo) query.list().get(0);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return notificationInfo;
    }
    public GroupMemberInviteInfo queryGroupMemberInviteInfoById(Integer inviteInfoId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from  GroupMemberInviteInfo gmii where gmii.inviteInfoId="+inviteInfoId);
        if(query.list().size() == 0){
            return null;
        }
        GroupMemberInviteInfo groupMemberInviteInfo = (GroupMemberInviteInfo) query.list().get(0);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return groupMemberInviteInfo;
    }
}
