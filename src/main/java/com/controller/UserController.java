package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:   wangchao
 * Version：
 * Date:     2017/11/10
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * --------------------------------------------------------------
 * Why & What is modified:
 */
/*@RequestMapping(value = "/user",method= RequestMethod.GET)*/
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/user",method= RequestMethod.GET,produces="application/json")
    public ResponseEntity<User> getUser(@RequestParam("userid") Long userId)
    {
        return new ResponseEntity<User>(userService.selectUserById(userId),HttpStatus.OK);
    }
    @RequestMapping(value = "/userid",method= RequestMethod.GET,produces="application/json")
    @ResponseBody
    public User getUserId(@RequestParam("userid") Long userId)
    {
        return userService.selectUserById(userId);
    }
    @RequestMapping(value = "/login",method= RequestMethod.GET,produces="application/json")
    public ResponseEntity<Boolean> login(@RequestParam("username") String username,@RequestParam("pwd") String password)
    {
        return new ResponseEntity<Boolean>(userService.selectUserByPassword(username,password),HttpStatus.OK);
    }
}
