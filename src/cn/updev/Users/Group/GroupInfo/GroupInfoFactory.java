package cn.updev.Users.Group.GroupInfo;

/**
 * Created by blf2 on 15-9-29.
 */
public class GroupInfoFactory {
    private String groupName;
    private String groupIntro;

    public GroupInfoFactory(String groupName,String groupIntro){
        this.groupName = groupName;
        this.groupIntro = groupIntro;
    }

    private String getGroupName(){
        if(groupName.length()>20){
            groupName = groupName.substring(0,20);
        }
        return groupName;
    }
    private String getGroupIntro(){
        if(groupIntro.length() > 50){
            groupIntro = groupIntro.substring(0,50);
        }
        return groupIntro;
    }
    public GroupInfo getGroupInfo(){
        //数据库持久化获得ID
        GroupInfo groupinfo  = new GroupInfo(null,getGroupName(),getGroupIntro());


        //需要填充
        return groupinfo;
    }

}
