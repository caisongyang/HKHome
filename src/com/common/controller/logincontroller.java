package common.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/userLogin")
public class logincontroller {


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
        return ret;
    }

}
