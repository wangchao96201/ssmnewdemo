package com.service;

import com.pojo.User;

import java.util.List;

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
public interface UserService {
    User selectUserById(Long userId);
}
