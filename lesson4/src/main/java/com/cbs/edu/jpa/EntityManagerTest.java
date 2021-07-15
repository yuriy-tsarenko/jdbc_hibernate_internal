package com.cbs.edu.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityManagerTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_base_config");



        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Employee employee = new Employee("Yevhenii", 28, 1000);

        entityManager.persist(employee);

        transaction.commit();
        entityManager.close();
    }
}
