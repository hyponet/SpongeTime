package cn.updev.Message.Email;

/**
 * Created by hypo on 15-11-27.
 */
public class ThreadSenter implements Runnable {

    private MailSenderInfo mailInfo;

    public ThreadSenter(MailSenderInfo mailInfo) {
        this.mailInfo = mailInfo;
    }

    public void run(){

        // 发送邮件
        try {
            MailSender sms = new MailSender();
            sms.sendHtmlMail(mailInfo);//发送html格式
            System.out.println("[邮件发送成功]： "+mailInfo.getToAddress());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
