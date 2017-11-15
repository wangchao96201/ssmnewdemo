package com.context;

import com.pojo.Order;
import com.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

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
public class PayContext {
    @Autowired
    private PayService payService;

    public  PayContext(PayService payService)
    {
        this.payService=payService;
    }
    public void setPayService(PayService payService)
    {
        this.payService=payService;
    }
    public boolean Pay(Order order)
    {
        return this.payService.Pay(order);
    }
}
