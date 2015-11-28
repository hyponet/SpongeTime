package cn.updev.Message.Task;

import org.apache.commons.lang.time.DateUtils;

import javax.servlet.ServletContextEvent;
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
     * 一周内的毫秒数
     */
    public static final long PERIOD_WEEK = PERIOD_DAY * 7;
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
        timer = new Timer("数据库表备份",true);
        //启动备份任务,每月(4个星期)执行一次
        timer.schedule(new BackUpTableTask(),NO_DELAY, PERIOD_WEEK * 4);
    }
    /**
     * 在Web应用结束时停止任务
     */
    public void contextDestroyed(ServletContextEvent event) {
        timer.cancel(); // 定时器销毁
    }
}