package common.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author:Hongyuan.Niu
 * @todo 未登录过滤器
 * @DATE 2018年8月27日 下午1:50:51
 */
public class LoginFilter extends OncePerRequestFilter {
    private String LOGIN_VIEW = "/userLogin/goLogin";
    static String suffix[] = { ".png", ".css", ".js",".gif" };

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("request getContextPath = "+request.getContextPath());
        System.out.println("request getRequestURI = "+request.getRequestURI());
        //if("/HKHome/html/login.html".equals(request.getRequestURI())){
           // filterChain.doFilter(request, response);
        //}else{
            if (request.getSession().getAttribute("CURRENT_USER")==null&&notFilter(request.getRequestURI())){
                response.sendRedirect(request.getContextPath()+LOGIN_VIEW);
                return;
            }else{
                filterChain.doFilter(request, response);
            }
   //     }

    }



    private boolean notFilter(String url) {
        if (StringUtils.isNotEmpty(url) && url.indexOf(".") > -1) {
            if (ArrayUtils.contains(suffix, url.substring(url.lastIndexOf(".")))) {
                return true;
            }
        }
        return false;
    }
}
