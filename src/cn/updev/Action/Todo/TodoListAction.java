package cn.updev.Action.Todo;

import cn.updev.EventWeight.Weight.EventWeight;
import cn.updev.EventWeight.Weight.EventWeightManage;
import cn.updev.Events.Event.EventDAO;
import cn.updev.Events.Event.EventFactory;
import cn.updev.Events.Static.EventInfo;
import cn.updev.Events.Static.IEvent;
import cn.updev.Users.Static.FuctionClass.Login;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by hypo on 15-11-25.
 */
public class TodoListAction extends ActionSupport {

    private Long eventId;

    public String execute() throws Exception {

        Login login = new Login();
        if(login.isNotLogined()){
            return LOGIN;
        }

        if(this.eventId != null && this.eventId >0){
            eventFinish();
        }

        EventDAO eventDAO = new EventDAO();

        // 获得登录用户
        Integer userId = new Login().getLoginedUser().getUserId();
        List<IEvent> events = eventDAO.getUnfinishEventByUserId(userId);

        Collections.sort(events, new Comparator<IEvent>() {
            @Override
            public int compare(IEvent o1, IEvent o2) {
                EventWeightManage eventWeight = new EventWeightManage();
                EventWeight weight1 = eventWeight.getEventWeight(o1.getEventId());
                EventWeight weight2 = eventWeight.getEventWeight(o2.getEventId());
                return (int)(weight2.getEventWeight() - weight1.getEventWeight());
            }
        });

        List<EventInfo> weightEventList = new ArrayList<EventInfo>();
        for(IEvent event : events){
            weightEventList.add(new EventInfo(event));
        }

        Collections.sort(events, new Comparator<IEvent>() {
            @Override
            public int compare(IEvent o1, IEvent o2) {
                EventWeightManage eventWeight = new EventWeightManage();
                EventWeight weight1 = eventWeight.getEventWeight(o1.getEventId());
                EventWeight weight2 = eventWeight.getEventWeight(o2.getEventId());
                Long time1 = weight1.getEventExpect().getTime() / 1000;
                Long time2 = weight2.getEventExpect().getTime() / 1000;
                return (int)(time1 - time2);
            }
        });

        List<EventInfo> expectEventList = new ArrayList<EventInfo>();
        for(IEvent event : events){
            expectEventList.add(new EventInfo(event));
        }

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

        List<EventInfo> reckonEventList = new ArrayList<EventInfo>();
        for(IEvent event : events){
            reckonEventList.add(new EventInfo(event));
        }

        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("weightEventList", weightEventList);
        request.setAttribute("expectEventList", expectEventList);
        request.setAttribute("reckonEventList", reckonEventList);

        return SUCCESS;
    }

    private void eventFinish(){

        IEvent event = new EventDAO().getEventById(this.eventId);

        if(event.isFinish()){
            event.setFinishTime(null);
        }else {
            event.setFinishTime(new Date());
        }

        EventFactory factory = new EventFactory();
        factory.update(event);

    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
