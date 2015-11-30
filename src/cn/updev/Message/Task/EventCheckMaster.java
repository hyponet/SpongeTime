package cn.updev.Message.Task;

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
     * 在Web应用启动时初始化任务
     */
    public void contextInitialized(ServletContextEvent event) {

        eventCheckJob= JobBuilder.newJob(EventCheckJob.class)
                .withIdentity("EventCheck","DAILYCHECK")
                .build();

        SchedulerFactory factory = new StdSchedulerFactory();
        try {
            scheduler = factory.getScheduler();
        } catch (SchedulerException e) {
            System.out.println("获得调度器失败");
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
            e.printStackTrace();
        }

    }
    /**
     * 在Web应用结束时停止任务
     */
    public void contextDestroyed(ServletContextEvent event) {
        try {
            scheduler.deleteJob(eventCheckJob.getKey());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}