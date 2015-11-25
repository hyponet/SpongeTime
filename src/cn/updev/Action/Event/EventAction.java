package cn.updev.Action.Event;

import cn.updev.Events.Event.EventDAO;
import cn.updev.Events.Event.EventFactory;
import cn.updev.Events.Static.EventWeight;
import cn.updev.Events.Static.IEvent;
import cn.updev.Users.Static.FuctionClass.Login;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

/**
 * Created by hypo on 15-11-19.
 */
public class EventAction extends ActionSupport {

    private Long eventId;
    private String eventTitle;
    private Date expectTime;
    private Integer weight;
    private Integer groupId;

    public String execute() throws Exception {

        Login login = new Login();
        if(login.isNotLogined()){
            return LOGIN;
        }

        if(this.eventTitle == null || this.eventTitle.trim().length() == 0){
            return INPUT;
        }

        // 获得Session下的已经登录用户的ID
        int ownerId = new Login().getLoginedUser().getUserId();

        //权重
        EventWeight eventWeight = EventWeight.values()[this.weight];

        //创建事件
        EventFactory factory = new EventFactory(this.eventTitle, this.expectTime, ownerId, eventWeight);
        IEvent event = factory.getEvent();

        if(event != null){
            return SUCCESS;
        }

        return ERROR;
    }

    public String eventFinish(){

        Login login = new Login();
        if(login.isNotLogined()){
            return LOGIN;
        }

        if(this.eventId == null || this.eventId < 1){
            return ERROR;
        }

        IEvent event = new EventDAO().getEventById(this.eventId);
        this.groupId = event.getGroupId();
        if(this.groupId == null){
            this.groupId = 0;
        }


        if(event.isFinish()){
            event.setFinishTime(null);
        }else {
            event.setFinishTime(new Date());
        }

        EventFactory factory = new EventFactory();
        factory.update(event);

        return SUCCESS;
    }

    public String addEventToGroup(){

        Login login = new Login();
        if(login.isNotLogined()){
            return LOGIN;
        }

        if(this.groupId == null || this.groupId < 1){
            return ERROR;
        }

        if(this.eventTitle == null || this.eventTitle.trim().length() == 0){
            return SUCCESS;
        }

        // 获得Session下的已经登录用户的ID
        int ownerId = new Login().getLoginedUser().getUserId();

        //权重
        EventWeight eventWeight = EventWeight.values()[this.weight];

        //创建事件
        EventFactory factory = new EventFactory(this.eventTitle, this.expectTime, ownerId, eventWeight, groupId);
        IEvent event = factory.getEvent();

        if(event != null){
            return SUCCESS;
        }

        return ERROR;
    }

    public String updateEvent(){

        Login login = new Login();
        if(login.isNotLogined()){
            return LOGIN;
        }

        if(this.eventId == null || this.eventId < 1){
            return ERROR;
        }

        EventDAO dao = new EventDAO();
        IEvent event = dao.getEventById(eventId);

        if(event == null){
            return ERROR;
        }

        this.groupId = event.getGroupId();
        if(this.groupId == null){
            this.groupId = 0;
        }

        event.setEventTitle(this.eventTitle);
        event.setExpectTime(this.expectTime);
        event.setWeight(EventWeight.values()[this.weight]);

        EventFactory factory = new EventFactory();
        factory.update(event);

        return SUCCESS;
    }

    public String delEvent(){

        Login login = new Login();
        if(login.isNotLogined()){
            return LOGIN;
        }

        if(this.eventId == null || this.eventId < 1){
            return ERROR;
        }

        EventDAO dao = new EventDAO();
        IEvent event = dao.getEventById(eventId);

        if(event == null){
            return ERROR;
        }

        this.groupId = event.getGroupId();
        if(this.groupId == null){
            this.groupId = 0;
        }

        EventFactory factory = new EventFactory();
        factory.delete(event);

        return SUCCESS;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public Date getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Date expectTime) {
        this.expectTime = expectTime;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupId() {
        return groupId;
    }
}
