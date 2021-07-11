package com.jdbc_hibernate_internal.lesson3.service;

import com.jdbc_hibernate_internal.lesson3.entity.CustomerEntity;
import com.jdbc_hibernate_internal.lesson3.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerService {

    private final SessionUtil sessionUtil = new SessionUtil();

    public CustomerEntity getById(Integer id) {
        Session session = sessionUtil.getSession();
        CustomerEntity customerEntity = session.get(CustomerEntity.class, id);
        sessionUtil.close();
        return customerEntity;
    }

    public List<CustomerEntity> getAll() {
        Session session = sessionUtil.getSession();
        HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CustomerEntity> query = criteriaBuilder.createQuery(CustomerEntity.class);
        Root<CustomerEntity> root = query.from(CustomerEntity.class);
        CriteriaQuery<CustomerEntity> select = query.select(root);
        TypedQuery<CustomerEntity> all = session.createQuery(select);
        List<CustomerEntity> resultList = all.getResultList();
        sessionUtil.close();
        return resultList;
    }

    public void update(CustomerEntity customerEntity) {
        Session session = sessionUtil.getSession();
        session.update(customerEntity);
        sessionUtil.close();
    }

    public void delete(CustomerEntity customerEntity) {
        Session session = sessionUtil.getSession();
        session.delete(customerEntity);
        sessionUtil.close();
    }


    public Integer create(CustomerEntity customerEntity) {
        Session session = sessionUtil.getSession();
        Integer saved = (Integer) session.save(customerEntity);
        sessionUtil.close();
        return saved;
    }

}
