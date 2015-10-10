package cn.updev.Users.Group.GroupInfo;

/**
 * Created by blf2 on 15-9-29.
 */
public class GroupInfoFactory {
    private String groupName;
    private String groupIntro;
    private Integer userId;//userId为创建者Id

    public GroupInfoFactory(String groupName,String groupIntro,Integer userId){
        this.groupName = groupName;
        this.groupIntro = groupIntro;
        this.userId = userId;
    }

    public String getGroupName(){
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
    private Integer getUserId(){
        //判断此userId是否存在，若存在
        return userId;
    }
    public boolean updateGroupInfo(){
        GroupInfo gi = new GroupInfo(null,getGroupName(),getGroupIntro(),getUserId());
        return gi.updateGroupInfo();
    }
    public GroupInfo getGroupInfo(){
        //数据库持久化获得ID
        GroupInfo groupinfo  = new GroupInfo(null,getGroupName(),getGroupIntro(),getUserId());

        //需要填充
        return groupinfo;
    }
    public boolean dismissGroup() {
        return new GroupInfo().dismissGroup();
    }

}
