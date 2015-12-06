package cn.updev.Message.Task;

import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by hypo on 15-11-27.
 */
public class EventCheckMaster implements ServletContextListener {

    private Scheduler scheduler;
    private JobDetail eventCheckJob;

    /**
     *  运行日志
     */
    private Logger logger = Logger.getLogger(EventCheckMaster.class);

    /**
     * 在Web应用启动时初始化任务
     */
    public void contextInitialized(ServletContextEvent event) {

        logger.info("web负责事件定时检查的监听器开始执行");

        eventCheckJob= JobBuilder.newJob(EventCheckJob.class)
                .withIdentity("EventCheck","DAILYCHECK")
                .build();

        SchedulerFactory factory = new StdSchedulerFactory();
        try {
            scheduler = factory.getScheduler();
        } catch (SchedulerException e) {
            logger.error("获得调度器失败");
            e.printStackTrace();
        }

        Trigger trigger= TriggerBuilder
                .newTrigger()
                .withIdentity("EventCheck_Trigger","DAILYCHECK")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 6 * * ?")
                )
                .build();

        try {
            scheduler.scheduleJob(eventCheckJob, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            logger.error("Scheduler执行被意外中断");
            e.printStackTrace();
        }

    }
    /**
     * 在Web应用结束时停止任务
     */
    public void contextDestroyed(ServletContextEvent event) {
        try {
            logger.info("web负责事件定时检查的监听器停止任务");
            scheduler.deleteJob(eventCheckJob.getKey());
        } catch (Exception e) {
            logger.error("web负责事件定时检查的监听器停止任务失败");
            e.printStackTrace();
        }
    }
}