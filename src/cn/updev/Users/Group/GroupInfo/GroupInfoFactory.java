package cn.updev.Users.Group.GroupInfo;

import java.util.Iterator;

/**
 * Created by blf2 on 15-9-29.
 */
public class GroupInfoFactory {
    private String groupName;
    private String groupIntro;
    private Integer userId;//userId为创建者Id

    public GroupInfoFactory(String groupName,String groupIntro,Integer userId){

    }

    private void setGroupName(String groupName){//用户组名只有大小写英文字母和下划线合法
        boolean flag = true;
        if(groupName.length() <= 15){
            for(int i = 0;i < groupName.length();i++){
                if(!(Character.isLowerCase(groupName.charAt(i)) || Character.isUpperCase(groupName.charAt(i)) ||
                        groupName.charAt(i) == '_')){
                    flag = false;
                    break;
                }
            }
            if(flag)
                this.groupName = groupName;
            else
                this.groupName = null;
        }else{
            this.groupName = null;
        }
    }

    private void setGroupIntro(String groupIntro){
        boolean flag = true;
        if(groupIntro.length() <= 50){
            for(int i = 0;i < groupIntro.length();i++){
                //if()
            }
        }
    }
}
