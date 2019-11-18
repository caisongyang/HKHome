package common.filter;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:Hongyuan.Niu
 * @todo 未登录过滤器
 * @DATE 2018年8月27日 下午1:50:51
 */
public class LoginFilter extends OncePerRequestFilter {
    private String LOGIN_VIEW = "/module/common/login.html";
    static String suffix[] = { ".png", ".css", ".js" };

    static Map<String, String> mobileUrlMap;
    static{
        mobileUrlMap = new HashMap<String,String>();
    }

    private static Logger logger = LogManager.getLogger(LoginFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if(mobileUrlMap.get(request.getRequestURI().replace("//", "/"))!=null&&!"".equals(mobileUrlMap.get(request.getRequestURI().replace("//", "/")))){
            filterChain.doFilter(request, response);
        }else{
            // 如果没有登录.
            String requestURI = "";
            if("/".equals(request.getRequestURI()))
                requestURI = "/";
            else
                requestURI = request.getRequestURI().substring(request.getRequestURI().indexOf("/", 1),
                        request.getRequestURI().length());
            logger.info("requestURI:"+requestURI);
            String contextPath = "";
            if(contextPath!=null&&!"".equals(contextPath.trim()))
                contextPath = request.getContextPath();
            else
                contextPath = "/AiEO";
            if (request.getSession().getAttribute("CURRENT_USER") == null && !this.notFilter(requestURI) && !requestURI.contains("login")) {
                response.sendRedirect(contextPath+LOGIN_VIEW);
                return;
            }

            filterChain.doFilter(request, response);
        }
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
