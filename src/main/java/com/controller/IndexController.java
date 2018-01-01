package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/index")
public class IndexController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/user/{id}",method= RequestMethod.GET)
    public String index(HttpServletRequest request, @PathVariable("id") Long id){
        User user=new User();
        user=userService.selectUserById(id);
        request.setAttribute("name","张三");
        request.setAttribute("User",user);
        return "Index";
    }
}
