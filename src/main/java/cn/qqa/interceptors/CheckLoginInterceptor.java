package cn.qqa.interceptors;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * 验证用户登录拦截器
 */
@Controller
public class CheckLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(StringUtils.isEmpty(session.getAttribute("username"))){
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }else{
            return true;
        }
    }
}
