package com.cbs.edu.hibernate.querying;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cbs.edu.hibernate.mapping.Employee;

public class HqlJpqlTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_base_config");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Employee> fromEmployee = entityManager.createNamedQuery("get_all_employees", Employee.class);

        List<Employee> result = fromEmployee.getResultList();

        System.out.println(result);
    }
}
