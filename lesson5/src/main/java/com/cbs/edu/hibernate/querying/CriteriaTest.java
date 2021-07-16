package com.cbs.edu.hibernate.querying;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.cbs.edu.hibernate.mapping.Employee;
import lombok.Data;

public class CriteriaTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_base_config");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);

        Root<Employee> root = query.from(Employee.class);
        query.select(root);

        final List<Employee> employees = entityManager.createQuery(query).getResultList();
        System.out.println(employees);

        String sql = "select * from product where color=... and brand=...";

        final SearchRequest searchRequest = new SearchRequest();

        String baseQuery = "select * from product where";

        if (searchRequest.getBrand() != null) {
//            baseQuery = baseQuery + "color=" + searchRequest.getBrand();
            Path<Object> age = root.get("age");
            Predicate agePredicate = criteriaBuilder.equal(age, searchRequest.getBrand());
            query.where(agePredicate);
        }
    }

    @Data
    static class SearchRequest {
        private String brand;
        private String color;
        private Integer priceFrom;
        private Integer priceTo;
    }
}
