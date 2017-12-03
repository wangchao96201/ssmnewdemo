package com.service.impl;

import com.dao.ProductDao;
import com.pojo.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    JedisPool jedisPool;
    @Autowired
    private ProductDao productDao;
    public Product selectProductById(Long id)
    {
       return productDao.selectProductById(id);
    }
    public boolean updateProductById(int id, int buys)
    {
     /*   Map map=new HashMap();
        map.put("id",id);
        map.put("buys",buys);*/
        return productDao.updateProductById(id,buys)==1?true:false;
    }
    public boolean updateProductByRedis(int id, int buys)
    {
        Jedis jedis=null;
        try
        {
            jedis=jedisPool.getResource();
            int num=Integer.parseInt(jedis.get(String.valueOf(id)));
            if(num<buys)
            {
                return false;
            }
            return jedis.decrBy(String.valueOf(id),buys)>=0L?true:false;
        }
        finally {
            jedis.close();
        }
    }
    public int insertByRedis(Product product)
    {
        Jedis jedis=null;
        try
        {
            jedis=jedisPool.getResource();
            jedis.set(String.valueOf(product.getId()),String.valueOf(product.getNum()));
        }finally {
            jedis.close();
        }
        return 1;
    }
    public int getNumByRedis(int id)
    {
        Jedis jedis=null;
        try
        {
            jedis=jedisPool.getResource();
            return Integer.parseInt(jedis.get(String.valueOf(id)));
        }finally {
            jedis.close();
        }
    }
}
