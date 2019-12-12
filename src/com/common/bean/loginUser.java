package common.bean;

import java.util.Map;

public class loginUser {
    String userId;
    String userRole;
    String userNmae;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserNmae() {
        return userNmae;
    }

    public void setUserNmae(String userNmae) {
        this.userNmae = userNmae;
    }

    public static loginUser newUser(Map<String, Object> val){
        loginUser ret = new loginUser();
        ret.setUserId(val.get("user_id").toString());
        ret.setUserNmae(val.get("user_name").toString());
        ret.setUserRole(val.get("user_role").toString());
        return ret;
    }


}
