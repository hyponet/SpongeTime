package cn.updev.Users.User;

import cn.updev.Database.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 15-10-8.
 */
public class GroupUser {
    private Integer groupUserId;
    private Integer userId;
    private Integer groupId;
    private Integer groupMemberRule;
    GroupUser(Integer userId,Integer groupId,Integer groupMemberRule){
        this.userId = userId;
        this.groupId = groupId;
        this.groupMemberRule = groupMemberRule;
    }

    //getters and setters


    public Integer getGroupUserId() {
        return groupUserId;
    }

    public void setGroupUserId(Integer groupUserId) {
        this.groupUserId = groupUserId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupMemberRule() {
        return groupMemberRule;
    }

    public boolean saveGroupUser(){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.save(new GroupUser(this.userId,this.groupId,this.groupMemberRule));
        transaction.commit();
        session.close();
        return true;
    }
}
