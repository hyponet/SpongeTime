package cn.updev.Action.Event;

import cn.updev.EventWeight.Rate.EventGroupRate;
import cn.updev.Users.Static.FuctionClass.Login;
import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupQuery;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupInfo;
import cn.updev.Users.Static.UserOrGroupInterface.IGroupUser;
import cn.updev.Users.Static.UserOrGroupInterface.IUser;
import cn.updev.Users.User.GroupUserInfo;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hypo on 15-12-4.
 */
public class TeamTaskAction extends ActionSupport {

    private Integer groupId;

    public String addTask(){

        Login login = new Login();

        if(login.isNotLogined()){
            return LOGIN;
        }

        IUser user = login.getLoginedUser();

        HttpServletRequest request = ServletActionContext.getRequest();

        if(groupId == null || groupId < 1){

            List<IGroupInfo> groupInfoList = new UserOrGroupQuery().queryGroupAllUserJoined(user.getUserId());
            List<IGroupInfo> createGroup = new ArrayList<IGroupInfo>();
            List<IGroupInfo> manageGroup = new ArrayList<IGroupInfo>();
            List<IGroupInfo> joinGroup = new ArrayList<IGroupInfo>();

            for(IGroupInfo info : groupInfoList){
                UserOrGroupQuery DAO = new UserOrGroupQuery();
                IGroupUser groupUser = DAO.queryGroupUser(user.getUserId(), info.getGroupId());

                if(groupUser.isCreater()){
                    createGroup.add(info);
                }else if(groupUser.isAdmin()){
                    manageGroup.add(info);
                }else if(groupUser.isUser()){
                    joinGroup.add(info);
                }
            }

            request.setAttribute("createGroup",createGroup);
            request.setAttribute("manageGroup",manageGroup);
            request.setAttribute("joinGroup",joinGroup);

            return INPUT;
        }

        // 获取团队信息
        UserOrGroupQuery DAO = new UserOrGroupQuery();
        IGroupInfo groupInfo = DAO.queryGroupInfoById(groupId);

        request.setAttribute("groupInfo",groupInfo);

        return SUCCESS;

    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
