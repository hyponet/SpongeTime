package cn.updev.EventWeight.Rate;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hypo on 15-11-24.
 */
public class EventGroupRateManage {

    HttpServletRequest request;
    HttpSession session;

    public EventGroupRateManage() {
        this.request = ServletActionContext.getRequest();
        this.session = request.getSession();
    }

    public void setEventGroupRate(List<Integer> groupIds){

        List<EventGroupRate> list = new ArrayList<EventGroupRate>();

        for(Integer groupId : groupIds){
            EventGroupRate groupRate = new EventGroupRate(groupId);
            if(groupRate.getGroupRate() != 100){

                list.add(groupRate);
            }
        }

        session.setAttribute("eventGroupRate", list);
    }
}
