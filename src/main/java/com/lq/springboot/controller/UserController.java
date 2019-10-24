package com.lq.springboot.controller;

import com.lq.springboot.entities.User;
import com.lq.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String list(User user, Map<String,Object> map){
        List<User> users = userService.getUsers(user);
        map.put("users",users);
        map.put("user",user);
        return "user/list";
    }

    @GetMapping("/user/{id}")
    public String view(@PathVariable("id")Integer id, @RequestParam(value = "type",defaultValue = "view") String type, Map<String,Object> map){
        User user = userService.getById(id);
        map.put("user",user);
        return "user/" + type;
    }

    @PostMapping("/user/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/user/add")
    public String toAdd(){
        return "user/add";
    }

    @PostMapping("/user/add")
    public String add(User user){
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/user/{id}")
    public String delete(@PathVariable("id") Integer id){
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/user/pwd")
    public String toPwd(){
        return "main/password";
    }

    @PostMapping("/user/pwd/{oldPassword}")
    @ResponseBody
    public Boolean check(@PathVariable("oldPassword") String oldPassword, HttpSession session){
        User user = (User) session.getAttribute("user");
        return oldPassword.equals(user.getPassword());
    }

    @PostMapping("/user/updatePwd")
    public String updatePwd(String password,HttpSession session){
        User user = (User) session.getAttribute("user");
        user.setPassword(password);
        userService.update(user);
        return "redirect:/logout";
    }

}
