package com.jdbc_hibernate_internal.homework.lesson2.repository;

import com.jdbc_hibernate_internal.homework.lesson2.entity.EmployeeEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository extends Repository {

    void createClient(EmployeeEntity employeeEntity);

    int updateClient(Map<String, Object> args, Integer employeeNumber);

    List<EmployeeEntity> getAllClients();

    EmployeeEntity getClient(Integer employeeNumber);

}
