package cn.updev.Action.Event;

import cn.updev.Events.Event.EventDAO;
import cn.updev.Events.Group.EventGroupDAO;
import cn.updev.Events.Group.UserEventGroup;
import cn.updev.Events.Static.IEvent;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by hypo on 15-11-22.
 */
public class EventManageAction extends ActionSupport {

    private Integer groupId;

    public String execute() throws Exception {
        System.out.println(new Date());
        //获得当前用户
        Integer userId = 1;

        EventGroupDAO groupDAO = new EventGroupDAO();
        List<UserEventGroup> groups = groupDAO.getAllUserEventGroup(userId);

        HttpServletRequest request = ServletActionContext.getRequest();

        // 把该用户的所有事件组放入request
        request.setAttribute("groups", groups);

        EventDAO eventDAO = new EventDAO();
        List<IEvent> events = null;
        if(this.groupId == null || this.groupId < 1){

            events = eventDAO.getSingleEventByUserId(userId);
            request.setAttribute("groupId", 0);
        }else if(groups != null){

            // 确保返回的事件组事件是该用户创建的
            Boolean getEvents = false;
            for(UserEventGroup group : groups){
                if(group.getGroupInfo().getGroupId() == groupId){

                    getEvents = true;
                    events = eventDAO.getEventByEventGroupId(groupId);
                }
            }

            if(!getEvents){
                return ERROR;
            }
            request.setAttribute("groupId", groupId);
        }

        request.setAttribute("events", events);

        return SUCCESS;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
