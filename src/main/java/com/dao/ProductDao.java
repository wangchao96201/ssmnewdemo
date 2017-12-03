package com.dao;

import com.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

@Repository
public interface ProductDao {

    Product selectProductById(@Param("id") Long id);

    int updateProductById(@Param("id") int id,@Param("buys") int buys);
}
