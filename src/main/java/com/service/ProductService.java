package com.service;

import com.pojo.Product;

public interface ProductService {

   Product selectProductById(Long id);

   boolean updateProductById(int id,int buys);

   int insertByRedis(Product product);
   boolean updateProductByRedis(int id, int buys);
   int getNumByRedis(int id);
}
