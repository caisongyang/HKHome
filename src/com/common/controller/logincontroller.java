package common.controller;


import common.service.loginservice;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/userLogin")
public class logincontroller {

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
    private Map<String,Object> dologin(HttpServletRequest request,String userName,String passWord) {
        Map<String,Object> ret = new HashMap<>();
        System.out.println("进入login"+userName+"||"+passWord);
        if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(passWord)){
            ret.put("statusCode","300");
            ret.put("message","请输入用户名或者密码");
            return ret;
        }
        Map<String,Object> val = new HashMap<String,Object>();
        val.put("userName",userName);
        val.put("passWord",passWord);
        return loginservice.checkpasword(val);
    }

}
