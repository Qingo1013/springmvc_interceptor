package cn.qqa.interceptors;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class MyInterceptor implements HandlerInterceptor {
    /**
     * 处理方法之前执行 日志、权限控制、记录调用时间
     * @param request 可以再请求处理之前更改requset中的属性值
     * @param response
     * @param handler 封装了处理方法的相关信息
     * @return  true代表后续拦截器调用链继续执行 false代表后续拦截器调用链终止执行
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //只有在请求能映射到对应的处理方法时，实现类才是HandlerMethod
        //如果是view-controller视图控制器配置的映射，实现类是ParameterizableViewController
        //所以不能随便强转
        if(handler instanceof HandlerMethod){
            HandlerMethod handler1 = (HandlerMethod) handler;
        }
        System.out.println("----处理方法前执行----preHandle");
/*        System.out.println("----类：["+handler1.getBean().getClass().getName()+
                "]方法名：["+ handler1.getMethod()+
                "]参数名：["+ Arrays.toString(handler1.getMethod().getParameters())+"]");*/
        return true;
        //return false;
        //false :拦截器与过滤器类似，也是一层层的，false就代表到这一层就终止了
    }

    /**
     *  如果preHandle返回false,则不会执行该方法
     *  处理方法之后执行，在视图渲染之前执行，当处理方法出现了异常则不会执行方法
     *  记录异常的日志不能写在这儿
     * @param request
     * @param response 可以更改response中的信息
     * @param handler
     * @param modelAndView 封装了model和view，处理方法结束后可以修改/新增model中的数据，也可以修改view视图
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("----方法后执行，在视图渲染之前----postHandle");

    }

    /**
     * 如果preHandle返回false,则不会执行该方法
     * 在视图渲染之后执行 相当于try-catch-finally中的finally，出现异常也会执行该方法
     * @param request
     * @param response
     * @param handler
     * @param ex Exception对象，在该方法中做一些记录异常日志的功能或者清除资源（例如需要关闭close的对象）
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("----在视图渲染之后----afterCompletion");


    }
}
