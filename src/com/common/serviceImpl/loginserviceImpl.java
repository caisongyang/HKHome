package common.serviceImpl;

import common.dao.loginDao;
import common.service.loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
@Service
public class loginserviceImpl implements loginservice {
    @Autowired
    private loginDao loginDao;
    @Override
    public Map<String, Object> checkpasword(Map<String, Object> map) {
        Map<String,Object> ret = new HashMap<>();
        //先验证是否存在此账号
        if("0".equals(loginDao.checkuserName(map))){
            //不存在账号
            ret.put("status","false");
            ret.put("errorCode","noUserName");
            ret.put("message","用户名不存在");
        }else{
            Map<String,Object> selectval =   loginDao.checkpasword(map);
            if(selectval == null||selectval.size() == 0){
                ret.put("status","false");
                ret.put("errorCode","passworderror");
                ret.put("message","用户名或密码错误");
            }else{
                ret.put("status","true");
                ret.put("errorCode","");
                ret.put("user_id",selectval.get("user_id"));
                ret.put("user_name",selectval.get("user_name"));
                ret.put("user_role",selectval.get("user_role"));
                ret.put("message","登录成功");
            }
        }
        //System.out.println("ret = "+ret);
        return ret;
    }

    @Override
    public Map<String, Object> newloginUser(Map<String, Object> map) throws Exception {
        Map<String,Object> ret = new HashMap<>();
        //先验证是否存在此账号
        if("0".equals(loginDao.checkuserName(map))){
            loginDao.newLoginUser(map);
            ret.put("status","true");
            ret.put("errorCode","");
            ret.put("message","新用户注册成功");
        }else{
            //存在账号
            ret.put("status","false");
            ret.put("errorCode","repeatUserName");
            ret.put("message","用户名存在");
        }
        return ret;
    }
}
