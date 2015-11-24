package cn.updev.Action.Event;

import cn.updev.Events.Event.EventFactory;
import cn.updev.Events.Group.*;
import cn.updev.Events.Static.EventWeight;
import cn.updev.Events.Static.IEvent;
import cn.updev.Events.Static.ITeamEvents;
import cn.updev.Events.Static.IUserEvents;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hypo on 15-11-19.
 */
public class EventGroupAction extends ActionSupport {

    private Integer groupId;
    private String groupTitle;
    private Date groupExpect;
    private String groupExpectTime;
    private Integer weight;

    /*
     * 判断是用户事件组还是团队事件组
     * 用户事件组是 1
     * 团队事件组是 -1
     */
    private Integer user;

    public String execute() throws Exception {

        if(this.groupTitle == null){

            return INPUT;
        }

        // 获得Session下的登录用户的ID
        Integer ownerId = 1;

        //小组权重
        EventWeight groupWeightl = EventWeight.values()[this.weight];

        //获得事件组事件
        List<IEvent> list = new ArrayList<IEvent>();
        HttpServletRequest request = ServletActionContext.getRequest();
        List<String> eventTitles = new ArrayList<String>();
        for(int i = 1;i < 100;i++){
            String eventTitle = (String)request.getParameter("eventTitle" + i);
            if(eventTitle == null){
                break;
            }else {
                eventTitle = eventTitle.trim();

                if(eventTitle.length() > 0){
                    eventTitles.add(eventTitle);
                }
            }
        }

        if(eventTitles.size() < 2){
            return ERROR;
        }

        //为事件组安装事件组信息并持久化
        EventGroupFactory factory = new EventGroupFactory(this.groupExpect, this.groupTitle, ownerId, groupWeightl);
        EventGroupInfo groupInfo = factory.getGroupInfo();

        // 事件组事件持久化
        for(String eventTitle : eventTitles){

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

    public String getUserEventGroup(){

        HttpServletRequest request = ServletActionContext.getRequest();

        String groupIdString = request.getParameter("groupId");
        if(groupIdString == null){

            return INPUT;
        }

        Integer groupId = Integer.parseInt(groupIdString);
        if(groupId < 1){

            return INPUT;
        }

        EventGroupDAO groupDAO = new EventGroupDAO();
        IUserEvents eventGroup = groupDAO.getUserEventGroup(groupId);

        if(eventGroup == null){

            return ERROR;
        }

        request.setAttribute("groupId", groupId);
        request.getSession().setAttribute("eventGroup", eventGroup);
        // 重构事件组信息
        this.groupTitle = eventGroup.getGroupInfo().getGroupTitle();
        this.groupExpect = eventGroup.getGroupInfo().getGroupExpect();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.groupExpectTime = dateFormat.format(groupExpect);
        this.weight = eventGroup.getGroupInfo().getWeight().ordinal();
        request.setAttribute("weight", this.weight);

        List<IEvent> events = eventGroup.getList();
        request.setAttribute("events", events);

        return SUCCESS;
    }

    public String updateUserEventGroup(){

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();

        IUserEvents eventGroup = (IUserEvents) session.getAttribute("eventGroup");
        if(eventGroup == null){
            return ERROR;
        }

        // 更新事件组信息 EventGroupInfo
        EventGroupInfo groupInfo = eventGroup.getGroupInfo();
        groupInfo.setGroupTitle(groupTitle);
        groupInfo.setWeight(EventWeight.values()[this.weight]);
        groupInfo.setGroupExpect(this.groupExpect);

        // 更新事件组中的事件信息
        List<String> eventTitles = new ArrayList<String>();
        for(int i = 1;i < 100;i++){
            String eventTitle = (String)request.getParameter("eventTitle" + i);
            if(eventTitle == null){
                break;
            }else {
                eventTitle = eventTitle.trim();

                if(eventTitle.length() > 0){
                    eventTitles.add(eventTitle);
                }
            }
        }

        Integer newLen = eventTitles.size();
        if(newLen < 2){
            return ERROR;
        }

        List<IEvent> events = eventGroup.getList();
        Integer oldLen = events.size();

        EventFactory factory = new EventFactory();

        if(oldLen >= newLen){

            // 如果对事件组进行了删减操作
            for(int i = 0;i < oldLen;i++){

                IEvent event = events.get(i);
                if(i >= newLen){
                    factory.delete(event);
                    continue;
                }

                String newEventTitle = eventTitles.get(i);

                if(!newEventTitle.equals(event.getEventTitle())){
                    // 获得目前用户ID
                    Integer ownerId = 1;

                    event.setEventTitle(newEventTitle);
                    event.setOwnerId(ownerId);
                    event.setDoerId(ownerId);
                    event.setCreateTime(new Date());
                }
                event.setExpectTime(this.groupExpect);
                event.setWeight(EventWeight.values()[this.weight]);

                factory.update(event);
            }
        }else {

            //如果对事件组进行的新增操作
            for(int i = 0;i < newLen;i++){

                String newEventTitle = eventTitles.get(i);
                if(i >= oldLen){

                    // 获取当前用户ID
                    Integer ownerId = 1;
                    IEvent event = new EventFactory(newEventTitle, this.groupExpect, ownerId,
                            EventWeight.values()[this.weight], groupInfo.getGroupId()).getEvent();
                    if(event != null){
                        events.add(event);
                    }
                    continue;
                }

                IEvent event = events.get(i);

                if(!newEventTitle.equals(event.getEventTitle())){
                    // 获取当前用户ID
                    Integer ownerId = 1;

                    event.setEventTitle(newEventTitle);
                    event.setOwnerId(ownerId);
                    event.setDoerId(ownerId);
                    event.setCreateTime(new Date());
                }
                event.setExpectTime(this.groupExpect);
                event.setWeight(EventWeight.values()[this.weight]);

                factory.update(event);
            }
        }

        UserEventGroup newGroup = new UserEventGroup(groupInfo, events);
        EventGroupFactory groupFactory = new EventGroupFactory();

        groupFactory.update(newGroup);

        return SUCCESS;
    }

    public String delEventGroup(){

        if(this.groupId == null || this.groupId < 1 || this.user == null){
            return INPUT;
        }

        EventGroupFactory factory = new EventGroupFactory();
        EventGroupDAO groupDAO = new EventGroupDAO();
        AbstractEventGroup group = null;

        if(this.user == 1){
            group = (AbstractEventGroup) groupDAO.getUserEventGroup(groupId);
        }else if(this.user == -1){
            group = (AbstractEventGroup) groupDAO.getTeamEventGroup(groupId);
        }

        if(group == null){
            return ERROR;
        }

        factory.delete(group);

        return SUCCESS;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Date getGroupExpect() {
        return groupExpect;
    }

    public void setGroupExpect(Date groupExpect) {
        this.groupExpect = groupExpect;
    }

    public String getGroupExpectTime() {
        return groupExpectTime;
    }

    public void setGroupExpectTime(String groupExpectTime) {
        this.groupExpectTime = groupExpectTime;
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
