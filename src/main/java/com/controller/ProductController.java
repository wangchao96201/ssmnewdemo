package com.controller;

import com.pojo.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ProductController {
    private AtomicInteger goodSales=new AtomicInteger();
    private AtomicInteger accoutNum=new AtomicInteger();

    private final  int buys=1;
    private final  int id=1;
    @Autowired
    private ProductService productService;
    @RequestMapping(value = "/product",method= RequestMethod.GET,produces="application/json")
    public ResponseEntity<String> product()
    {
        try
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
        catch (InterruptedException ex)
        {

        }
        return new ResponseEntity<String>("成功", HttpStatus.OK);
    }
    @RequestMapping(value = "/insert",method= RequestMethod.GET)
    public void insert()
    {
        Product product=new Product();
        product.setId(new Long(1));
        product.setNum(2);
        productService.insertByRedis(product);
    }
    @RequestMapping(value = "/msproduct",method= RequestMethod.GET,produces="application/json")
    public ResponseEntity<String> msRedis()
    {
        try
        {
            for(int i=0;i<10;i++)
            {
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(productService.updateProductByRedis(id,buys))
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
            System.out.println("剩余商品的数量"+productService.getNumByRedis(1));

        }
        catch (InterruptedException ex)
        {

        }
        return new ResponseEntity<String>("成功", HttpStatus.OK);
    }
}
