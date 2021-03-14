package cn.qqa.controllers;

import org.omg.PortableInterceptor.AdapterManagerIdHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @PostMapping("/login")
    public String login(HttpSession session){
        //查询数据库
        //假设登录被允许
        session.setAttribute("username","qqa");
        return "admin";
    }
    @GetMapping("/login")
    public String login(){

        return "login";
    }
}
