package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
