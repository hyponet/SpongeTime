package cn.updev.Action.Admin;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户仪表盘
 * 作为用户后台的触发拦截器
 * Created by hypo on 15-11-22.
 */
public class UserDashboardAction extends ActionSupport {
    public String addEvents(){
        return SUCCESS;
    }

}
