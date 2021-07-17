package com.cbs.edu.hibernate.mapping;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "department")
@EqualsAndHashCode(callSuper = true)
@Entity
@NamedQueries({
        @NamedQuery(name = "get_all_employees", query = "from Employee emp where emp.age=:age"),
        @NamedQuery(name = "get_employee_departments", query = "from Employee emp join Department where emp.id=:id"),
        /* SELECT * FROM employee e JOIN department d ON e.dept_id = d.id WHERE e.id=?*/
})
@Table(name = "employees")
@DynamicUpdate
public class Employee extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private int salary;

    @Embedded
    private CreditCard creditCard;

    @OneToOne
    @JoinColumn(name = "employee_details_id", referencedColumnName = "id")
    private EmployeeDetails employeeDetails;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "employees_projects",
            joinColumns = { @JoinColumn(name = "employee_id")},
            inverseJoinColumns = { @JoinColumn(name = "project_id")})
    private List<Project> projects;
}
