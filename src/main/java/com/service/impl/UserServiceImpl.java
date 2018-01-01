package com.service.impl;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    //@Transactional(propagation = Propagation.NEVER)
    @Cacheable(value = "selectUserById",key="#userId")
    public User selectUserById(Long userId)
    {
         return userDao.selectUserById(userId);
    }
}
