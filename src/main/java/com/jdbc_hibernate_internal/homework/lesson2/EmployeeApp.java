package com.jdbc_hibernate_internal.homework.lesson2;


import com.jdbc_hibernate_internal.homework.lesson2.entity.EmployeeEntity;
import com.jdbc_hibernate_internal.homework.lesson2.service.EmployeeService;
import com.jdbc_hibernate_internal.homework.lesson2.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * @author Ruslan
 * Homework_2
 * Написать DAO для манипуляцией сущностью employees из базы данных employee_db
 */


public class EmployeeApp {

    private static final EmployeeService employeeService = new EmployeeServiceImpl();

    public static void main(String[] args) {
        // work with the employees we get by the given id
        System.out.println("get by the given id: 1286");
        EmployeeEntity employeeEntityById = employeeService.getEmployeeById(1286);
        System.out.println(employeeEntityById);
        // work with the employees update by the given id
        employeeService.updateEmployee(Map.of("firstName", "Kati"), 1286);
        System.out.println("update by the given id: 1286");
        employeeEntityById = employeeService.getEmployeeById(1286);
        System.out.println(employeeEntityById);
        // work with the new employee
        System.out.println("the new employee:");
        EmployeeEntity employeeEntity = new EmployeeEntity(500, "Ivan", "Black",
                "x3333", "gblack@classicmodelcars.com",
                "3", 1000, "VP Sales");
        employeeService.createEmployee(employeeEntity);
        employeeEntityById = employeeService.getEmployeeById(500);
        System.out.println(employeeEntityById);
        // work with all records
        System.out.println("All records:");
        List<EmployeeEntity> allEmployeeEntities = EmployeeApp.employeeService.getAllEmployees();
        for (EmployeeEntity allEmployeeEntity : allEmployeeEntities) {
            System.out.println(allEmployeeEntity);

        }
    }


}

