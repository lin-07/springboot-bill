package com.lq.springboot.controller;

import com.lq.springboot.entities.User;
import com.lq.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(HttpSession session,String username, String password, Map<String,Object> map){
        if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)){
            User user = userService.getUserByUserName(username);
            if(user != null && password.equals(user.getPassword())){
                session.setAttribute("user",user);
                return "redirect:/main.html";
            }
        }
        map.put("msg","用户名或者密码错误");
        return "main/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        // 清空session中用户信息
        session.removeAttribute("user");
        // 注销session
        session.invalidate();
        // 返回登录页面
        return "redirect:/index.html";
    }
}
