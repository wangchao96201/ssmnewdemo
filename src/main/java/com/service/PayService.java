package com.service;

import com.pojo.Order;

/**
 * Author:   wangchao
 * Version：
 * Date:     2017/11/14
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * --------------------------------------------------------------
 * Why & What is modified:
 */
public interface PayService {
    boolean pay(Order order);
}
