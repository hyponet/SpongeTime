package cn.updev.Action.Event;

import cn.updev.Events.Event.EventFactory;
import cn.updev.Events.Group.EventGroupFactory;
import cn.updev.Events.Group.EventGroupInfo;
import cn.updev.Events.Static.EventWeight;
import cn.updev.Events.Static.IEvent;
import cn.updev.Events.Static.ITeamEvents;
import cn.updev.Events.Static.IUserEvents;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hypo on 15-11-19.
 */
public class EventGroupAction extends ActionSupport {

    private String groupTitle;
    private Date groupExpect;
    private Integer weight;
    private Integer user;



    public String execute() throws Exception {

        if(this.groupTitle == null){

            return INPUT;
        }

        // 获得Session下的登录用户的ID
        Integer ownerId = 1;

        //小组权重
        EventWeight groupWeightl = EventWeight.values()[this.weight - 1];

        //为事件组安装事件组信息并持久化
        EventGroupFactory factory = new EventGroupFactory(this.groupExpect, this.groupTitle, ownerId, groupWeightl);
        EventGroupInfo groupInfo = factory.getGroupInfo();

        //获得事件组事件
        List<IEvent> list = new ArrayList<IEvent>();
        HttpServletRequest request = ServletActionContext.getRequest();
        for(int i = 1;i < 100;i++){
            String eventTitle = (String)request.getParameter("eventTitle" + i);

            if(eventTitle == null){
                break;
            }else {
                eventTitle = eventTitle.trim();
            }

            if(eventTitle.length() == 0){
                continue;
            }

            IEvent event = new EventFactory(eventTitle, groupExpect, ownerId, groupWeightl, groupInfo.getGroupId()).getEvent();
            if(event != null){
                list.add(event);
            }
        }

        //为事件组安装事件
        factory.setList(list);

        if(this.user == 1){
            IUserEvents events = factory.getUserEvents();

            if(events != null){
                return "usertodo";
            }
        }else if(this.user == -1){
            ITeamEvents events = factory.getTeamEvents();

            if(events != null){
                return "teamtodo";
            }
        }

        return ERROR;
    }

    public Date getGroupExpect() {
        return groupExpect;
    }

    public void setGroupExpect(Date groupExpect) {
        this.groupExpect = groupExpect;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }
}
