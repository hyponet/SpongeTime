package cn.updev.Events.Event;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Events.Static.EventWeight;
import cn.updev.Events.Static.IEvent;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by hypo on 15-9-29.
 */
public class EventFactory {

    private String eventTitle;
    private Date expectTime;
    private EventWeight weight;
    private Integer ownerId;
    private Integer doerId;
    private Integer groupId;

    public EventFactory(){

    }

    //个人事件添加
    public EventFactory(String eventTitle, Date expectTime, int ownerId, EventWeight weight) {
        this.eventTitle = eventTitle;
        this.expectTime = expectTime;
        this.groupId = null;
        this.ownerId = ownerId;
        this.weight = weight;
    }

    //团队事件添加
    public EventFactory(String eventTitle, Date expectTime, int ownerId, EventWeight weight, int groupId) {
        this.eventTitle = eventTitle;
        this.expectTime = expectTime;
        this.groupId = groupId;
        this.ownerId = ownerId;
        this.weight = weight;
    }

    //默认正在做这件事的人为创建者
    private Integer getDoerId() {
        doerId = ownerId;
        return doerId;
    }

    private String getEventTitle() {

        //限制事件Title长度，超出则截取
        if(eventTitle.length() > 20){
            eventTitle = eventTitle.substring(0,20);
        }

        return eventTitle;
    }

    //事件预期完成时间
    private Date getExpectTime() {

        return expectTime;
    }

    //如果不是团队事件，将返回null
    private Integer getGroupId() {
        return groupId;
    }

    //返回创建者的ID
    private Integer getOwnerId() {
        return ownerId;
    }

    //权重
    private EventWeight getWeight() {
        return weight;
    }

    //创建一个事件，通过数据持久化获得ID，并返回这个事件对象
    public IEvent getEvent(){

        if(doerId == null || eventTitle == null || expectTime == null || ownerId == null){
            return null;
        }

        IEvent event = new Event(getDoerId(), getEventTitle(), getExpectTime(),
                       getGroupId(),getOwnerId(),getWeight());

        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();

        session.save(event);
        transaction.commit();
        HibernateSessionFactory.closeSession();

        return event;
    }

    public IEvent update(IEvent event){
        this.eventTitle = event.getEventTitle();
        this.expectTime = event.getExpectTime();
        this.weight = event.getWeight();
        this.ownerId = event.getOwnerId();
        this.doerId = event.getDoerId();
        this.groupId = event.getGroupId();

        if(doerId == null || eventTitle == null || expectTime == null || ownerId == null){
            return null;
        }

        event.setEventTitle(getEventTitle());
        event.setExpectTime(getExpectTime());
        event.setWeight(getWeight());
        event.setOwnerId(getOwnerId());
        event.setDoerId(getDoerId());
        event.setGroupId(getGroupId());

        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(event);
        transaction.commit();
        HibernateSessionFactory.closeSession();

        return event;
    }

    public Boolean delete(IEvent event){

        Session session = null;
        Transaction transaction = null;

        try {

            session = HibernateSessionFactory.currentSession();
            transaction = session.beginTransaction();
            session.delete(event);
            transaction.commit();
        }catch (Exception e){

            System.err.println(e);
            transaction.rollback();
            return false;
        }finally {

            HibernateSessionFactory.closeSession();
        }

        return true;
    }
}
