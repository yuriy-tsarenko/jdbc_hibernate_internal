package com.jdbc_hibernate_internal.homework.lesson2.service;


import com.jdbc_hibernate_internal.homework.lesson2.entity.EmployeeEntity;
import com.jdbc_hibernate_internal.homework.lesson2.repository.EmployeeRepository;
import com.jdbc_hibernate_internal.homework.lesson2.repository.EmployeeRepositoryImpl;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.getAllClients();
    }

    public EmployeeEntity getEmployeeById(Integer employeeNumber) {
        return employeeRepository.getClient(employeeNumber);
    }

    public void updateEmployee(Map<String, Object> args, Integer employeeNumber) {
        employeeRepository.updateClient(args, employeeNumber);
    }

    public void createEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.createClient(employeeEntity);
    }

}
