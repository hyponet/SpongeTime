package cn.updev.Events.Event;

import cn.updev.Events.Static.EventWeight;
import cn.updev.Events.Static.IEvent;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by hypo on 15-9-29.
 */
public class EventUpdate {
    private IEvent event;

    public EventUpdate(IEvent event) {
        this.event = event;
    }

    public void setDoerId(Integer doerId) {
        event.setDoerId(doerId);
    }

    //设置完成人ID
    private void setEnderId(Integer enderId) {
        event.setEnderId(enderId);
    }

    //清空完成人ID
    private void clearEnderId() {
        event.setEnderId(null);
    }

    public void setEventTitle(String eventTitle) {

        //长度限制
        if(eventTitle.length() > 20){
            eventTitle = eventTitle.substring(0,20);
        }
        event.setEventTitle(eventTitle);
    }

    public void setExpectTime(Date expectTime) {
        event.setExpectTime(new Timestamp(expectTime.getTime()));
    }

    //设置事件完成事件
    private void setFinishTime() {
        event.setFinishTime(new Timestamp(new Date().getTime()));
    }

    //清空事件完成事件
    private void clearFinishTime() {
        event.setFinishTime(null);
    }

    public void setWeight(EventWeight weight) {
        event.setWeight(weight);
    }

    //事件完成 设置完成人ID，添加完成事件
    public void eventFinish(Integer enderId){
        setEnderId(enderId);
        setFinishTime();
    }

    //取消事件完成 清空完成人ID，清除完成事件
    public void eventDisFinish(){
        clearEnderId();
        clearFinishTime();
    }

    public IEvent update(){

        //数据持久化

        if(event.getEventId() == null){
            //获取事件ID

        }

        return event;
    }

    public Boolean delete(){

        return false;
    }
}
