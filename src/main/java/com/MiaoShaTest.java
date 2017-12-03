package com;

import com.pojo.User;
import com.service.ProductService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicInteger;

public class MiaoShaTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    public static void main(String[] args) throws InterruptedException{
        MiaoShaTest ts=new MiaoShaTest();
       // ts.ms();
        ts.miaosha();
    }
    private AtomicInteger goodSales=new AtomicInteger();
    private AtomicInteger accoutNum=new AtomicInteger();

    private final  int buys=3;
    private final  int id=1;
    public void ms() throws InterruptedException
    {
        for(int i=0;i<10;i++)
        {
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    if(productService.updateProductById(id,buys))
                    {
                        accoutNum.incrementAndGet();
                        goodSales.addAndGet(buys);
                    }
                }
            });
            thread.start();
            thread.join();

        }
        System.out.println("成功购买商品的数量"+accoutNum);
        System.out.println("成功卖出商品的数量"+goodSales);
    }

    public void miaosha()
    {
       // boolean a=productService.updateProductById(id,buys);
        User user=userService.selectUserById(new Long(1));
    }
}
