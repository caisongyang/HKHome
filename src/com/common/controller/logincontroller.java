package common.controller;


import common.bean.loginUser;
import common.service.loginservice;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/userLogin")
public class logincontroller {

    protected HttpSession session;

    @Autowired
    private  loginservice loginservice;

    //跳转到登录页面
    @RequestMapping("goLogin")
    private ModelAndView uploadTest(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login");
        return mv;
    }

    //跳转到登录页面
    @RequestMapping("dologin")
    @ResponseBody
    private Map<String,Object> dologin(HttpServletRequest request, HttpServletResponse response, String userName, String passWord) {
        Map<String,Object> ret = new HashMap<>();
        System.out.println("进入login"+userName+"||"+passWord);
        if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(passWord)){
            ret.put("statusCode","300");
            ret.put("message","请输入用户名或者密码");
            ret.put("errorCode","textnull");
            return ret;
        }
        Map<String,Object> val = new HashMap<String,Object>();
        val.put("userName",userName);
        val.put("passWord",passWord);
        try {
            Map<String,Object> selectval = loginservice.checkpasword(val);
            if("true".equals(selectval.get("status"))){
                session = request.getSession();
                session.setAttribute("loginUser",(Object)loginUser.newUser(selectval));
                ret.put("statusCode","200");
                ret.put("message",selectval.get("message"));
                ret.put("errorCode","");
                return ret;
            }else{
                ret.put("statusCode","300");
                ret.put("message",selectval.get("message"));
                ret.put("errorCode",selectval.get("errorCode"));
                return ret;
            }
        }catch (Exception e){
            System.out.println("登录报错");
            e.printStackTrace();
            ret.put("statusCode","300");
            ret.put("message","登录报错");
            ret.put("errorCode","login-error");
            return ret;
        }
    }

}
