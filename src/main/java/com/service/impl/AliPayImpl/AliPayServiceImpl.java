package com.service.impl.AliPayImpl;

import com.pojo.Order;
import com.service.PayService;
import org.springframework.stereotype.Service;

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
public class AliPayServiceImpl implements PayService{

    private PayService payService;
    @Override
    public boolean pay(Order order)
    {
        System.out.println("支付宝支付成功！");
        return payService.pay(order);
    }
}
