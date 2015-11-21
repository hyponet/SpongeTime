package cn.updev.Action.Admin;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 作为后台的第一层拦截器
 * 作为区分普通用户和超级管理员用户进行分流
 * Created by hypo on 15-11-22.
 */
public class AdminAction extends ActionSupport {
    public String login(){
        return LOGIN;
    }

    public String execute() throws Exception {
        return "user";
    }
}
