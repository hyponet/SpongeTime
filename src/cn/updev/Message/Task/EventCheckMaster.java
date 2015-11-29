package cn.updev.Message.Task;

import org.apache.commons.lang.time.DateUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * Created by hypo on 15-11-27.
 */
public class EventCheckMaster implements ServletContextListener {
    /**
     * 每天的毫秒数
     */
    public static final long PERIOD_DAY = DateUtils.MILLIS_IN_DAY;
    /**
     * 无延迟
     */
    public static final long NO_DELAY = 0;
    /**
     * 定时器
     */
    private Timer timer;
    /**
     * 在Web应用启动时初始化任务
     */
    public void contextInitialized(ServletContextEvent event) {
        //定义定时器
        timer = new Timer("EventNeedToDoCheck",true);

        Date now = new Date();
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ft = dateFormat1.format(now);
        Date firstTime = null;
        try {
            firstTime = dateFormat2.parse(ft + " " + "06:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
            firstTime = now;
        }
        System.out.println("首次执行任务时间为：" + firstTime);
        //启动事件检查任务，每天6点开始执行
        timer.schedule(new EventCheck(),firstTime, PERIOD_DAY);
    }
    /**
     * 在Web应用结束时停止任务
     */
    public void contextDestroyed(ServletContextEvent event) {
        timer.cancel(); // 定时器销毁
    }
}