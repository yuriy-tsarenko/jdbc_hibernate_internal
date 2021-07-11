package com.jdbc_hibernate_internal.lesson3.util;

import com.jdbc_hibernate_internal.lesson3.entity.CustomerEntity;
import com.jdbc_hibernate_internal.lesson3.entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionUtil {
    private Transaction transaction;
    private Session session;

    private void init() {
        Configuration configure = new Configuration().configure("hibernate_configuration.xml");
        configure.addAnnotatedClass(CustomerEntity.class);
        configure.addAnnotatedClass(EmployeeEntity.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configure.getProperties())
                .build();

        SessionFactory factory = configure.buildSessionFactory(registry);
        session = factory.openSession();
        transaction = session.beginTransaction();
    }

    public Session getSession() {
        if (session == null && transaction == null) {
            init();
        } else if (session != null && !session.isOpen()) {
            init();
        }
        return session;
    }

    public void close() {
        if (transaction.isActive()) {
            transaction.commit();
        }
        session.close();
    }
}
