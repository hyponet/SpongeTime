package cn.updev.Users.Group.GroupInfo;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Users.User.GroupUser;
import cn.updev.Users.User.GroupUserFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 15-9-29.
 */
public class GroupInfo {
    private Integer groupId;
    private String groupName;
    private String groupIntro;

    public GroupInfo(String groupName,String groupIntro,GroupUser groupcreater){
        this.groupName = groupName;
        this.groupIntro = groupIntro;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupIntro() {
        return groupIntro;
    }

    public void setGroupIntro(String groupIntro) {
        this.groupIntro = groupIntro;
    }

    public GroupInfo saveGroupInfo(){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.save(this);
        transaction.commit();
        session.close();
        return this;
    }

}
