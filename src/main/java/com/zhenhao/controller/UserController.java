package com.zhenhao.controller;

import com.zhenhao.bean.User;
import com.zhenhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
//    @Autowired
//    private User user;
    //显示用户
    @ResponseBody
    @RequestMapping("/list")
    public List<User> index() throws Exception {
        return userService.getAllUser();
    }
    @ResponseBody
    @RequestMapping("/list/{id}")
    public User getUserById(@PathVariable int id ){
        return userService.getUserById(id);
    }
    @RequestMapping(value = "/main")
    public String main(Model model, User user){

        if(user!=null&&user.getName()!=null && user.getAge()!=0){
            userService.insertUser(user);
//        model.addAttribute("user",user);
        }
        List<User> lists = userService.getAllUser();
        model.addAttribute("lists",lists);
        return "views/main";
    }
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("name","请输入个人信息添加数据库");
        return "views/login";
    }

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable int id, Model model){
        userService.deleteById(id);
        List<User> lists = userService.getAllUser();
        model.addAttribute("lists",lists);
        return "views/list";
    }

    @RequestMapping("/edit/{id}")
    public String editByUser(@PathVariable("id") int id,Model model){

        User user = userService.getUserById(id);
        model.addAttribute("name",user.getName());
        model.addAttribute("age",user.getAge());
        model.addAttribute("id",user.getId());
        return "views/edit";
    }

    @RequestMapping("afterEdit")
    public String afterEdit(User user,Model model){
        userService.editByUser(user);
        List<User> lists = userService.getAllUser();
        model.addAttribute("lists",lists);
        return "views/list";
    }



}
