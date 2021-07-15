package com.cbs.edu.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionTest {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        MetadataSources sources = new MetadataSources(registry);
        Metadata metadata = sources.getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        Employee employee = new Employee("Anna", 24, 10200);

        session.persist(employee);

        transaction.commit();
        sessionFactory.close();
    }
}
