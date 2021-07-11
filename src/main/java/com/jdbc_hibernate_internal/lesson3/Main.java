package com.jdbc_hibernate_internal.lesson3;


import com.jdbc_hibernate_internal.lesson3.entity.CustomerEntity;
import com.jdbc_hibernate_internal.lesson3.entity.EmployeeEntity;
import com.jdbc_hibernate_internal.lesson3.service.CustomerService;
import com.jdbc_hibernate_internal.lesson3.service.EmployeeService;

import java.util.List;

public class Main {
    private static final CustomerService customerService = new CustomerService();
    private static final EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
//
//        List<CustomerEntity> all = customerService.getAll();
//        all.forEach(System.out::println);
//        System.out.println();
//        CustomerEntity customer = customerService.getById(129);
//        System.out.println("by id:" + customer);
//
//        CustomerEntity customer1 = new CustomerEntity(13, "JOHN",
//                "null", "null", "null", "null", "null",
//                "null", "null", "null", "null", 12, null,
//                "null");
//        Integer newCustomerId = customerService.create(customer1);
//
//        CustomerEntity byId = customerService.getById(newCustomerId);
//        System.out.println(byId);
//
//        CustomerEntity newCustomer = customerService.getById(byId.getCustomerNumber());
//        System.out.println("created: " + newCustomer);
//
////        customerService.delete(customer3);
//        CustomerEntity customer4 = customerService.getById(byId.getCustomerNumber());
//        System.out.println("deleted: " + customer4);


        EmployeeEntity entity = new EmployeeEntity(null, "Test employee", "David", "", "",
                "", "3", 1);

        Integer id = employeeService.create(entity);

        EmployeeEntity employeeById = employeeService.getById(id);

        System.out.println(employeeById);
    }
}
