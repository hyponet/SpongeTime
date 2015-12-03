package cn.updev.Action.User;

import cn.updev.EventWeight.Rate.EventGroupRate;
import cn.updev.Users.Group.GroupMemberRule.PrimaryUserRule;
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
 * Created by hypo on 15-12-3.
 */
public class UserGroupAction extends ActionSupport {

    private Integer groupId;
    private String groupName;
    private String groupIntro;

    public String createUserGroup(){

        Login login = new Login();

        if(login.isNotLogined()){
            return LOGIN;
        }

        if(groupName == null || groupName.trim().length() == 0){
            return INPUT;
        }

        IUser user = login.getLoginedUser();
        PrimaryUserRule createGroup = new PrimaryUserRule();
        IGroupInfo groupInfo = createGroup.createGroup(groupName, groupIntro, user.getUserId());

        if(groupInfo != null){

            groupId = groupInfo.getGroupId();
            return SUCCESS;
        }

        return INPUT;

    }

    public String groupManage(){

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

        UserOrGroupQuery DAO = new UserOrGroupQuery();

        IGroupInfo groupInfo = DAO.queryGroupInfoById(groupId);
        List<GroupUserInfo> groupUser = DAO.queryGroupMemberInfoAll(groupId);
        List<EventGroupRate> groupTask = new ArrayList<EventGroupRate>();
        IGroupUser userInfo = DAO.queryGroupUser(user.getUserId(), groupId);

        this.groupName = groupInfo.getGroupName();
        this.groupIntro = groupInfo.getGroupIntro();
        request.setAttribute("groupInfo",groupInfo);
        request.setAttribute("groupUser",groupUser);
        request.setAttribute("groupTask",groupTask);
        request.setAttribute("userInfo",userInfo);

        return SUCCESS;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupIntro() {
        return groupIntro;
    }

    public void setGroupIntro(String groupIntro) {
        this.groupIntro = groupIntro;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
