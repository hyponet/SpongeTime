package cn.updev.Message.Task;

import cn.updev.Database.HibernateSessionFactory;
import cn.updev.EventWeight.Weight.EventWeight;
import cn.updev.Events.Event.EventDAO;
import cn.updev.Events.Static.IEvent;
import cn.updev.Message.Email.MailSenderInfo;
import cn.updev.Message.Email.ThreadSenter;
import cn.updev.Message.Template.BasicTemplate;
import cn.updev.Message.Template.EmailCheckFinishTemplate;
import cn.updev.Message.Template.EventRemidTemplate;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupQuery;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import org.apache.commons.lang.time.DateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.List;

/**
 * Created by hypo on 15-11-30.
 */
public class EventCheckJob implements Job {

    public static final long PERIOD_DAY = DateUtils.MILLIS_PER_DAY;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("执行事件检查！");

        Session session = HibernateSessionFactory.currentSession();
        String hql = "FROM EventWeight WHERE 1=1";
        Query query = session.createQuery(hql);

        List<EventWeight> list = query.list();

        HibernateSessionFactory.closeSession();

        EventDAO eventDAO = new EventDAO();
        Date now = new Date();
        Long nowLong = now.getTime();
        Integer sentNum = 0;

        for (EventWeight eventWeight : list){

            IEvent event = eventDAO.getEventById(eventWeight.getEventId());
            if(!event.isFinish()){

                Date eventExpect = eventWeight.getEventExpect();
                Long expectLong = eventExpect.getTime();
                Long subTime = expectLong - nowLong;
                if(subTime >= 0 && subTime <= 2 * PERIOD_DAY){
                    sentNum++;
                    sentMassage(event, eventWeight);
                }
            }
        }
        checkFinish(list.size(), sentNum, now);
    }

    private void sentMassage(IEvent event, EventWeight eventWeight){

        UserOrGroupQuery userDAO = new UserOrGroupQuery();
        IUser user = userDAO.queryUserById(event.getDoerId());

        try {
            // 设置邮件
            MailSenderInfo mailInfo = new MailSenderInfo();
            mailInfo.setToAddress(user.geteMail());
            BasicTemplate template = new EventRemidTemplate(user.getNickName(),event, eventWeight).getTemplate();
            mailInfo.setSubject(template.getTitle());
            mailInfo.setContent(template.getContent());

            new Thread(new ThreadSenter(mailInfo)).start();

        }catch (Exception e){
            System.out.println("[邮件发送失败]： eventId=" + event.getEventId() + "  userEmail=" + user.geteMail());
            System.out.println(e.getMessage());
        }

    }

    private void checkFinish(Integer checkNum, Integer setnNum, Date startTime){
        try {
            // 设置邮件
            MailSenderInfo mailInfo = new MailSenderInfo();
            mailInfo.setToAddress("i@ihypo.net");
            BasicTemplate template = new EmailCheckFinishTemplate(startTime,checkNum,setnNum).getTemplate();
            mailInfo.setSubject(template.getTitle());
            mailInfo.setContent(template.getContent());

            new Thread(new ThreadSenter(mailInfo)).start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
