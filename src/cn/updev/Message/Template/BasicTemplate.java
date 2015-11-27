package cn.updev.Message.Template;

/**
 * Created by hypo on 15-11-27.
 */
public class BasicTemplate {
    private String title;
    private String content;

    public BasicTemplate(String title, String content) {
        this.content = content;
        this.title = title;
    }

    public String getTitle(){
        return "[SpongeTime]" + this.title;
    }

    public String getContent(){

        String rnt = "<body style=\"background-color: #f2f4f8\"><div style=\"margin-top: 10px; width: 96%; margin-left: 2%;box-shadow:2px 2px 5px #ccc;\">"+
                "<div id=\"HEADER\" style=\"padding: 15px; background-color: #000; border-radius:5px 5px 0px 0px;\"><a class=\"navbar-brand\" href=\"http://todo.updev.cn\" style=\"text-decoration:none; color: #fff; font-size: 18px;\"><span style=\"color: #30a5ff; padding-left: 10px;\">SPONGE</span>TIME</a><span style=\"color: #ccc; font-size: 13px; padding: 10px;\"> 一个用心的时间助手</span></div>"+
                "<div id=\"BODY\" style=\"padding: 20px; background-color: #fff;\"><h2>"+this.title+"</h2>"+
                "<p>" + this.content + "</p><hr/>" +
                "<p style=\"font-size: 10px;\">* 本邮件由系统自动发送，请勿回复</p>" +
                "</div><div id=\"FOOTER\" style=\"padding: 10px; padding-left: 15px; background-color: #f6f6f6;\"><small style=\"color: #c0c0c0\">&copy;SpongeTime <a href=\"http://todo.updev.cn/login\" style=\"text-decoration:none\">Login</a></small>"+
                "</div></div></body></html>";

        return rnt;
    }
}
