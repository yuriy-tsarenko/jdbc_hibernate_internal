package com.jdbc_hibernate_internal.lesson2.demo_app.repository;


import com.jdbc_hibernate_internal.lesson2.demo_app.entity.ProductEntity;

import java.util.List;
import java.util.Map;

public interface ProductRepository extends Repository {

    void createProduct(ProductEntity productEntity);

    int updateProduct(Map<String, Object> args, String productCode);

    List<ProductEntity> getAllProducts();

    ProductEntity getProduct(String productCode);

}
