package cn.updev.Action.Todo;

import cn.updev.EventWeight.Weight.EventWeight;
import cn.updev.EventWeight.Weight.EventWeightManage;
import cn.updev.Events.Event.EventDAO;
import cn.updev.Events.Static.IEvent;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hypo on 15-11-25.
 */
public class TodoListAction extends ActionSupport {

    public String execute() throws Exception {

        EventDAO eventDAO = new EventDAO();

        // 获得登录用户
        Integer userId = 1;
        List<IEvent> events = eventDAO.getUnfinishEventByUserId(userId);


        Collections.sort(events, new Comparator<IEvent>() {
            @Override
            public int compare(IEvent o1, IEvent o2) {
                EventWeightManage eventWeight = new EventWeightManage();
                EventWeight weight1 = eventWeight.getEventWeight(o1.getEventId());
                EventWeight weight2 = eventWeight.getEventWeight(o2.getEventId());
                return (int)(weight1.getEventWeight() - weight2.getEventWeight());
            }
        });

        Collections.sort(events, new Comparator<IEvent>() {
            @Override
            public int compare(IEvent o1, IEvent o2) {
                EventWeightManage eventWeight = new EventWeightManage();
                EventWeight weight1 = eventWeight.getEventWeight(o1.getEventId());
                EventWeight weight2 = eventWeight.getEventWeight(o2.getEventId());
                Long time1 = weight1.getEventExpect().getTime() / 1000;
                Long time2 = weight2.getEventExpect().getTime() / 1000;
                return (int)(time2 - time1);
            }
        });

        Collections.sort(events, new Comparator<IEvent>() {
            @Override
            public int compare(IEvent o1, IEvent o2) {
                EventWeightManage eventWeight = new EventWeightManage();
                EventWeight weight1 = eventWeight.getEventWeight(o1.getEventId());
                EventWeight weight2 = eventWeight.getEventWeight(o2.getEventId());
                Long time1 = weight1.getEventReckon().getTime() / 1000;
                Long time2 = weight2.getEventReckon().getTime() / 1000;
                return (int)(time1 - time2);
            }
        });

        for(IEvent event : events){
            EventWeightManage eventWeight = new EventWeightManage();
            EventWeight weight = eventWeight.getEventWeight(event.getEventId());
            System.out.println(event.getEventTitle() + " " + weight.getEventReckon());
        }

        return SUCCESS;
    }
}
