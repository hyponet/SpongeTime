package cn.updev.Message.Template;

import cn.updev.EventWeight.Weight.EventWeight;
import cn.updev.Events.Group.EventGroupDAO;
import cn.updev.Events.Group.EventGroupInfo;
import cn.updev.Events.Static.IEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hypo on 15-11-27.
 */
public class EventRemidTemplate {

    private String userNickName;
    private String title;
    private String content;
    private IEvent event;
    private String eventTitle;
    private EventWeight eventWeight;

    public EventRemidTemplate(String userNickName, IEvent event, EventWeight eventWeight) {
        this.userNickName = userNickName;
        this.event = event;
        this.eventWeight = eventWeight;

        if(event.getGroupId() != null){

            EventGroupInfo groupInfo = new EventGroupDAO().getEventGroupInfo(event.getGroupId());
            this.eventTitle = groupInfo.getGroupTitle() + " " + event.getEventTitle();
        }else {
            this.eventTitle = event.getEventTitle();
        }

    }

    public String getContent() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Long eventExpect = eventWeight.getEventExpect().getTime();
        Long eventReckon = eventWeight.getEventReckon().getTime();
        Long sub = eventExpect - eventReckon;
        String status;

        if(sub > 0){
            status = "就目前进度来看，有可能提前完成。请继续加油！";
        }else {
            sub = -sub / (1000 * 3600 * 24);
            if(sub > 4){

                status = "就目前进度来看，进展过慢，很有可能无法按理想时间完成任务，还需按轻重缓急及时调整，继续努力。";
            }else {

                status = "就目前进度来看，进展稍慢，有可能无法按计划及时完成任务，还需努力。";
            }
        }

        this.content = "<p>客官 "+userNickName+"：</p><p>早上好！ 这是一封事件提醒邮件。</p>"+
                "<p>您的事件 <b>" + eventTitle + "</b> ，曾计划于"+dateFormat.format(eventWeight.getEventExpect())+"完成，到您收到这封邮件为止，你的预计时间余额不足两天。</p>"+
                "<p>我们预计这件事件将在"+dateFormat.format(eventWeight.getEventReckon())+"完成，"+status+"</p><p>小的汇报完毕，暂行告退。Have a Good Day！</p><p>还在加班的SpongeTime任务进度控制君敬上！</p><p>"+(new Date())+"</p>";
        return content;
    }

    public String getTitle() {

        title = "客官，有任务！ " + eventTitle;

        return title;

    }

    public BasicTemplate getTemplate(){
        return new BasicTemplate(getTitle(),getContent());
    }
}
