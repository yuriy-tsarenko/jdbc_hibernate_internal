package com.cbs.edu.hibernate;

import static java.util.Arrays.asList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.cbs.edu.hibernate.mapping.Department;
import com.cbs.edu.hibernate.mapping.Employee;
import com.cbs.edu.hibernate.mapping.Project;
import com.cbs.edu.hibernate.querying.HibernateUtil;

public class Test {
    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_base_config");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        queryCacheTest();

    }

    static void testLoad(EntityManager entityManager) {
        TypedQuery<Department> query = entityManager.createQuery("FROM Department p WHERE p.id=:id", Department.class);
        query.setParameter("id", 4);

        Department department = query.getSingleResult();
        System.out.println(department);
    }

    static void testDynamicUpdate(EntityManager entityManager) {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee p WHERE p.id=:id", Employee.class);
        query.setParameter("id", 56);

        Employee employee = query.getSingleResult();

        entityManager.getTransaction().begin();

        employee.setAge(232);
        employee.setSalary(722377);

        entityManager.persist(employee);

        entityManager.getTransaction().commit();
    }

    static void testCascade(EntityManager entityManager) {
        final Employee employee = new Employee();
        employee.setFirstName("Yevhenii");
        employee.setLastName("Deineka");
        employee.setAge(28);

        final Project atpProject = new Project();
        atpProject.setName("ATP");

        final Project dmpProject = new Project();
        dmpProject.setName("DMP");

        employee.setProjects(asList(atpProject, dmpProject));

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    static void firstLevelCacheTest() {
        final Session session = HibernateUtil.getSessionFactory().openSession();

        final Project project = session.load(Project.class, 106);
        System.out.println(project.getName());

        final Project projectCopy = session.load(Project.class, 106);
        System.out.println(projectCopy.getName());

        HibernateUtil.getSessionFactory().close();
    }

    static void secondLevelCacheTest() {
        final Session session1 = HibernateUtil.getSessionFactory().openSession();
        final Project project = session1.load(Project.class, 106);
        System.out.println(project.getName());
        session1.close();

        final Session session2 = HibernateUtil.getSessionFactory().openSession();
        final Project projectCopy = session2.load(Project.class, 106);
        System.out.println(projectCopy.getName());
        session2.close();

        HibernateUtil.getSessionFactory().close();
    }

    static void queryCacheTest() {
        final Session session = HibernateUtil.getSessionFactory().openSession();

        TypedQuery<Project> query = session.createQuery("FROM Project p WHERE p.name=:name", Project.class);
        query.setParameter("name", "Marketplace");

        final Project project = query.getSingleResult();
        System.out.println(project.getName());

        final Project projectCopy = query.getSingleResult();
        System.out.println(projectCopy.getName());
    }
}
