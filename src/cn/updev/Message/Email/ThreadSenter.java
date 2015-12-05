package cn.updev.Message.Email;

import org.apache.log4j.Logger;

/**
 * Created by hypo on 15-11-27.
 */
public class ThreadSenter implements Runnable {

    private MailSenderInfo mailInfo;

    /**
     *  运行日志
     */
    private Logger logger = Logger.getLogger(ThreadSenter.class);

    public ThreadSenter(MailSenderInfo mailInfo) {
        this.mailInfo = mailInfo;
    }

    public void run(){

        // 发送邮件
        logger.info("邮件线程接受邮件任务，开始执行向 " + mailInfo.getToAddress() + "发送邮件");
        try {
            MailSender sms = new MailSender();
            sms.sendHtmlMail(mailInfo);//发送html格式
            System.out.println("[邮件发送成功]： " + mailInfo.getToAddress());
            logger.info("邮件发送执行成功 " + mailInfo.getToAddress());
        }catch (Exception e){
            System.out.println(e.getMessage());
            logger.error("邮件发送执行失败 " + mailInfo.getToAddress());
        }
        logger.info("邮件线程结束任务死亡");
    }
}
