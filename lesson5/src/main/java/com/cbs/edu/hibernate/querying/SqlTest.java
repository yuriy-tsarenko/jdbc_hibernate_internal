package com.cbs.edu.hibernate.querying;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import com.cbs.edu.hibernate.mapping.Employee;

public class SqlTest {
    public static void main(String[] args) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();

        NativeQuery<Employee> nativeQuery = session.createNativeQuery("SELECT * FROM employee", Employee.class);

        List<Employee> employees = nativeQuery.getResultList();

        System.out.println(employees);
    }
}
