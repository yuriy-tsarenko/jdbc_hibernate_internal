package com.cbs.edu.hibernate.mapping;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NamedQueries({
        @NamedQuery(name = "get_all_employees", query = "from Employee emp where emp.age=:age"),
        @NamedQuery(name = "get_employee_departments", query = "from Employee emp join Department where emp.id=:id"),
        /* SELECT * FROM employee e JOIN department d ON e.dept_id = d.id WHERE e.id=?*/
})
public class Employee extends BaseEntity {

    @Column
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private int salary;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToMany
    @JoinTable(name = "employees_projects",
            joinColumns = { @JoinColumn(name = "employee_id")},
            inverseJoinColumns = { @JoinColumn(name = "project_id")})
    private Set<Project> projects;
}
