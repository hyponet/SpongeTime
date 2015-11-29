package cn.updev.Message.Template;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hypo on 15-11-28.
 */
public class EmailCheckFinishTemplate {

    private Integer checkNum;
    private Integer sentNum;
    private Date startTime;
    private Date endTime;
    private String content;

    public EmailCheckFinishTemplate(Date startTime, Integer checkNum, Integer sentNum) {
        this.startTime = startTime;
        this.checkNum = checkNum;
        this.sentNum = sentNum;
        this.endTime = new Date();
    }

    private String getTitle(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "" + dateFormat.format(startTime) + "邮件提醒完成";
    }

    private String getContent(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.content = "<p>尊敬Master：</p>"+
                "<p>报告Master，<b>我还活着！</b>而且，"+dateFormat.format(startTime) +"的事件检查和邮件提醒任务我成功已经完成。</p>"+
                "<p>本次检查开始时间："+this.startTime+"</p>"+
                "<p>本次检查结束时间："+this.endTime+"</p>"+
                "<p>本次检查总共检查事件数："+this.checkNum+"</p>"+
                "<p>本次检查发送提醒邮件数："+this.sentNum+"</p>"+
                "<p>报告Master，吾辈深知事件检查线程的脆弱性，Master看到这封邮件意味着直到目前为止我还活着，"+
                "请Master放心，吾辈会在明日再次发送邮件报告任务完成情况。如果明日未收到吾辈邮件，劳烦Master务必去重启下服务器_(:з」∠)_</p>"+
                "<p>坚强的任务事件检查君敬上！</p>"+
                "<p>"+(new Date())+"</p>";
        return this.content;
    }

    public BasicTemplate getTemplate(){
        return new BasicTemplate(getTitle(),getContent());
    }
}
