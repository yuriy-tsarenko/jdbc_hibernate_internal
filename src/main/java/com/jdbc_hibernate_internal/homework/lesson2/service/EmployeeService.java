package com.jdbc_hibernate_internal.homework.lesson2.service;


import com.jdbc_hibernate_internal.homework.lesson2.entity.EmployeeEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<EmployeeEntity> getAllEmployees();

    EmployeeEntity getEmployeeById(Integer employeeNumber);

    void updateEmployee(Map<String, Object> args, Integer employeeNumber);

    void createEmployee(EmployeeEntity employeeEntity);

}
