package com.jdbc_hibernate_internal.lesson2.demo_app.service;


import com.jdbc_hibernate_internal.lesson2.demo_app.entity.CustomerEntity;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<CustomerEntity> getAllCustomers();

    CustomerEntity getCustomerById(Integer customerNumber);

    int updateCustomer(Map<String, Object> args, Integer customerNumber);

    void createCustomer(CustomerEntity customerEntity);
}
