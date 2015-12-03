package cn.updev.Action.User;

import cn.updev.Users.Static.FuctionClass.Login;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupQuery;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupUser;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hypo on 15-12-4.
 */
public class UserGroupInviteAction extends ActionSupport{

    /**
     * userInfo : 在团队邀请新成员时作为新成员的信息查询
     *            既可以是用户邮箱，也可以是用户名
     */
    private String userInfo;
    private Integer groupId;

    public String inviteNewUser(){

        Login login = new Login();

        if(login.isNotLogined()){
            return LOGIN;
        }

        if(groupId < 1){

            return ERROR;
        }

        if(userInfo == null || userInfo.trim().length() == 0){

            return SUCCESS;
        }

        IUser user = login.getLoginedUser();

        UserOrGroupQuery DAO = new UserOrGroupQuery();

        // 1 获得被邀请的成员
        IUser inviter = DAO.queryUserByName(userInfo);
        if(inviter == null){
            inviter = DAO.queryUserByEMail(userInfo);
        }
        if(inviter == null){
            String err = "用户 " + userInfo + " 不存在，请核实！";
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("error", err);
            return SUCCESS;
        }

        // 2 判断被邀请的成员是否在用户组中
        IGroupUser groupUser = DAO.queryGroupUser(inviter.getUserId(), groupId);

        if(groupUser != null){
            return SUCCESS;
        }

        // 3 发送邀请信息
        System.out.println("正在邀请：" + inviter.getNickName());

        return SUCCESS;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
