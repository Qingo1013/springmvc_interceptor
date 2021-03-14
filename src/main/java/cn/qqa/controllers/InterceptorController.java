package cn.qqa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 拦截器演示
 * ·步骤：
 *      1.定义拦截器，必须要实现HandlerInterceptor接口
 *      2.在spring-mvc.xml中配置拦截器
 *     <mvc:interceptors>
 *         <bean class="cn.qqa.interceptors.MyInterceptor"></bean>
 *     </mvc:interceptors>
 *
 */
@Controller
public class InterceptorController {

    @RequestMapping("/test01")
    public String test01(){
        System.out.println("请求方法执行中");
        return "admin";
    }
}
