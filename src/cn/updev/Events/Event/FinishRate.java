package cn.updev.Events.Event;

import cn.updev.Events.Static.IEvent;
import cn.updev.Users.Static.FuctionClass.Login;
import org.apache.commons.lang.time.DateUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by hypo on 15-11-28.
 */
public class FinishRate {

    private Integer aheadTimeFinish;
    private Integer laterTimeFinish;
    private Integer normalTimeFinish;
    private Integer longTimeNotFinish;
    private HttpSession session;

    /**
     * 每天的毫秒数
     */
    public static final long PERIOD_DAY = DateUtils.MILLIS_IN_DAY;

    public FinishRate() {
        HttpServletRequest request = ServletActionContext.getRequest();
        session = request.getSession();
    }

    private void update(){

        Integer userId = (new Login()).getLoginedUser().getUserId();
        EventDAO eventDAO = new EventDAO();
        List<IEvent> finishEvnets = eventDAO.getFinishEventByUserId(userId);
        List<IEvent> unFinishEvnets = eventDAO.getUnfinishEventByUserId(userId);

        Integer sum = finishEvnets.size() + unFinishEvnets.size();
        Integer aheadTime = 0;
        Integer laterTime = 0;
        Integer normalTime = 0;

        for(IEvent event : finishEvnets){
            Date expectTime = event.getExpectTime();
            Date finishTime = event.getFinishTime();
            Long sub = expectTime.getTime() - finishTime.getTime();

            if(sub > 0){
                // 在预定前完成
                if(sub > PERIOD_DAY * 2){
                    aheadTime++;
                }else {
                    normalTime++;
                }
            }else {
                // 在预定后完成
                sub = -sub;

                if(sub > PERIOD_DAY * 3){
                    normalTime++;
                }else {
                    laterTime++;
                }
            }
        }

        Integer longTimeNot = 0;
        for(IEvent event : unFinishEvnets){
            Date expectTime = event.getExpectTime();
            Date now = new Date();
            Long sub = expectTime.getTime() - now.getTime();

            if(sub < 0){
                //超期 转换到秒
                sub = -sub/1000;
                if(sub > (PERIOD_DAY * 3)/100){
                    longTimeNot++;
                }
            }
        }

        if(sum != 0){

            aheadTimeFinish = 100 * aheadTime/sum;
            laterTimeFinish = 100 * laterTime/sum;
            longTimeNotFinish = 100 * longTimeNot/sum;
            normalTimeFinish = 100 * normalTime/sum;
        }else {
            aheadTimeFinish = 0;
            laterTimeFinish = 0;
            longTimeNotFinish = 0;
            normalTimeFinish = 0;
        }

        session.setAttribute("aheadTimeFinish",aheadTimeFinish);
        session.setAttribute("laterTimeFinish",laterTimeFinish);
        session.setAttribute("longTimeNotFinish",longTimeNotFinish);
        session.setAttribute("normalTimeFinish",normalTimeFinish);

    }

    public Integer getAheadTimeFinish() {

        aheadTimeFinish = (Integer) session.getAttribute("aheadTimeFinish");

        if(aheadTimeFinish == null){
            update();
        }

        return aheadTimeFinish;
    }

    public Integer getLaterTimeFinish() {

        laterTimeFinish = (Integer) session.getAttribute("laterTimeFinish");

        if(laterTimeFinish == null){
            update();
        }

        return laterTimeFinish;
    }

    public Integer getLongTimeNotFinish() {

        longTimeNotFinish = (Integer) session.getAttribute("longTimeNotFinish");

        if(longTimeNotFinish == null){
            update();
        }

        return longTimeNotFinish;
    }

    public Integer getNormalTimeFinish() {

        normalTimeFinish = (Integer) session.getAttribute("normalTimeFinish");

        if(normalTimeFinish == null){
            update();
        }

        return normalTimeFinish;
    }
}
