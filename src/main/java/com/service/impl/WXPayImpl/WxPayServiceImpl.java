package com.service.impl.WXPayImpl;

import com.pojo.Order;
import com.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class WxPayServiceImpl implements PayService {

    @Autowired
    private PayService payService;
    @Override
    public boolean pay(Order order)
    {
       System.out.println("微信支付");
       return payService.pay(order);
    }
}
