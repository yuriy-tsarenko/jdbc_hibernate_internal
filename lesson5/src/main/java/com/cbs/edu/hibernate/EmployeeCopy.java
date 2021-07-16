package com.cbs.edu.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
public class EmployeeCopy {

    private String name;

    private int age;

    private int salary;


    public static void main(String[] args) {
        final EmployeeCopy em = EmployeeCopy.builder()
                .age(121)
                .name("sds")
                .build();
    }
}
