package com.controller;

import com.context.PayContext;
import com.pojo.Order;
import com.service.PayService;
import com.service.impl.AliPayImpl.AliPayServiceImpl;
import com.service.impl.WXPayImpl.WxPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;

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
@RestController
public class PayController {

    @RequestMapping(value = "/pay",method= RequestMethod.GET)
    public ResponseEntity<String> pay()
    {
        try {
            PayContext payContext;
            boolean isPaySuccess=false;
            Order order=new Order();
            order.setOrdercode("c1234567");
            order.setPrice(new BigDecimal(2000));
            order.setProductId("123456");
            switch (1)
            {
                case 1:
                    payContext=new PayContext(new WxPayServiceImpl());
                    isPaySuccess=payContext.Pay(order);
                    break;
                case 2:
                    payContext=new PayContext(new AliPayServiceImpl());
                    isPaySuccess=payContext.Pay(order);
                    break;
            }
            if(isPaySuccess)
            {
                return new ResponseEntity<String>("支付成功", HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<String>("支付失败", HttpStatus.OK);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<String>("支付失败", HttpStatus.OK);
        }


    }
    @RequestMapping(value = "/test",method= RequestMethod.GET)
    public  void test()
    {
        BigInteger a=new BigInteger("300");
        BigInteger b=new BigInteger("300");

        System.out.println(a.equals(b)?"111":"2222");
    }
}
