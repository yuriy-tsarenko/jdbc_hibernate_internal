package com.jdbc_hibernate_internal.lesson2.demo_app.service;


import com.jdbc_hibernate_internal.lesson2.demo_app.entity.ProductEntity;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<ProductEntity> getAllProducts();

    ProductEntity getProductById(String productCode);

    int updateProduct(Map<String, Object> args, String productCode);

    void createProduct(ProductEntity productEntity);
}
