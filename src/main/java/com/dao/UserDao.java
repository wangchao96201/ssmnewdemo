package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Author:   wangchao
 * Version：
 * Date:     2017/11/9
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * --------------------------------------------------------------
 * Why & What is modified:
 */
@Repository
public interface UserDao {
    User selectUserById(@Param("userId") Long userId);
}
