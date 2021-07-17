package com.cbs.edu.hibernate.mapping;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "employee")
@Table(name = "employee_details")
public class EmployeeDetails extends BaseEntity {

    private String country;

    private String iban;

    @OneToOne(mappedBy = "employeeDetails")
    private Employee employee;
}
