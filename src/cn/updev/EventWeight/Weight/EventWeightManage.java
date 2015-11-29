package cn.updev.EventWeight.Weight;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.Events.Event.EventDAO;
import cn.updev.Events.Static.IEvent;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

/**
 * Created by hypo on 15-11-25.
 */
public class EventWeightManage {
    public EventWeightManage() {
    }

    public EventWeight getEventWeight(Long eventId){

        Session session = HibernateSessionFactory.currentSession();
        Query query = session.createQuery("from EventWeight ew where ew.eventId=" + eventId);
        Date now = new Date();

        EventWeight weight = null;
        if(query.list().size() != 0){
            weight = (EventWeight) query.list().get(0);
        }

        HibernateSessionFactory.closeSession();
        if(weight == null || (now.getTime()/1000) - (weight.getUpdateTime().getTime()/1000) > 86400){
            weight = updateEventWeight(eventId);
        }

        return weight;
    }

    /*
     * 更新事件权重表
     * 以事件组为单位更新
     */
    private EventWeight updateEventWeight(Long eventId){

        EventDAO eventDAO = new EventDAO();
        IEvent event = eventDAO.getEventById(eventId);

        EventReckon eventReckon = null;

        if(event.getGroupId() != null){
            eventReckon = new EventReckon(event.getGroupId());
        }

        EventWeight weight = null;

        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();

        if(eventReckon != null){
            List<IEvent> events = eventReckon.getEvents();

            for(IEvent e : events){

                Query query = session.createQuery("from EventWeight ew where ew.eventId=" + e.getEventId());

                if(query.list().size() != 0){
                    weight = (EventWeight) query.list().get(0);
                }else {
                    weight = new EventWeight();
                }

                weight.setEventId(e.getEventId());
                weight.setGroupId(e.getGroupId());
                weight.setEventWeight(eventReckon.getWeight().get(e.getEventId()));
                weight.setEventExpect(eventReckon.getExpectTime().get(e.getEventId()));
                weight.setEventReckon(eventReckon.getReckonTime().get(e.getEventId()));
                weight.setUpdateTime(new Date());

                session.saveOrUpdate(weight);
            }
        }else {
            // 独立事件

            Query query = session.createQuery("from EventWeight ew where ew.eventId=" + event.getEventId());

            if(query.list().size() != 0){
                weight = (EventWeight) query.list().get(0);
            }else {
                weight = new EventWeight();
            }

            weight.setEventId(event.getEventId());
            weight.setGroupId(event.getGroupId());
            weight.setEventWeight(getSingleEventWeight(event));
            weight.setEventExpect(event.getExpectTime());
            weight.setEventReckon(event.getExpectTime());
            weight.setUpdateTime(new Date());

            session.saveOrUpdate(weight);

        }

        transaction.commit();
        HibernateSessionFactory.closeSession();

        return weight;
    }

    /*
     * 单例事件权重计算
     */
    private Double getSingleEventWeight(IEvent event){

        Double baseWeight = (event.getWeight().ordinal()+1) * 25.0 + 5;

        Long subTime = event.getExpectTime().getTime() - new Date().getTime();
        subTime /= 3600000 * 24;

        Double addPower;

        if(subTime >= 0){
            // 可能提前完成
            if(subTime > 7){
                // 如果有可能提前一周
                addPower = -subTime * 4.5;
            }else {
                addPower = -subTime * 3.5;
            }
        }else {
            subTime = -subTime;
            // 可能延期完成
            if(subTime > 7){
                // 如果延期超过一周
                addPower = subTime * 3.5 + 50;
            }else {
                addPower = subTime * 8.5;
            }
        }

        return baseWeight + addPower;
    }
}
