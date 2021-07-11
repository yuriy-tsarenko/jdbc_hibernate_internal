package com.jdbc_hibernate_internal.lesson3.service;

import com.jdbc_hibernate_internal.lesson3.entity.EmployeeEntity;
import com.jdbc_hibernate_internal.lesson3.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeService {

    private final SessionUtil sessionUtil = new SessionUtil();

    public EmployeeEntity getById(Integer id) {
        Session session = sessionUtil.getSession();
        EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, id);
        sessionUtil.close();
        return employeeEntity;
    }

    public List<EmployeeEntity> getAll() {
        Session session = sessionUtil.getSession();
        HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> query = criteriaBuilder.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> root = query.from(EmployeeEntity.class);
        CriteriaQuery<EmployeeEntity> select = query.select(root);
        TypedQuery<EmployeeEntity> all = session.createQuery(select);
        sessionUtil.close();
        return all.getResultList();
    }

    public void update(EmployeeEntity employeeEntity) {
        Session session = sessionUtil.getSession();
        session.update(employeeEntity);
        sessionUtil.close();
    }

    public void deleteById(Integer id) {
        Session session = sessionUtil.getSession();
        session.delete(id);
        sessionUtil.close();
    }

    public Integer create(EmployeeEntity employeeEntity) {
        Session session = sessionUtil.getSession();
        Integer id = (Integer) session.save(employeeEntity);
        sessionUtil.close();
        return id;
    }

}
