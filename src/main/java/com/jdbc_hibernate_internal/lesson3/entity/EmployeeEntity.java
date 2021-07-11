package com.jdbc_hibernate_internal.lesson3.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeeEntity {
    //    @GeneratedValue(strategy = GenerationType.IDENTITY) ГЕНЕРАЦИЯ ID ПОЛАГАЕТСЯ НА БД

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees")
    @GenericGenerator(
            name = "employees",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "value_column", value = "employeeNumber"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "2")
            }
    )
    // здесь вариант генерации id в кастомном варианте c использованием встроенных генераторов
    private Integer employeeNumber;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "extension")
    private String extension;

    @Column(name = "email")
    private String email;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "officeCode")
    private String officeCode;

    @Column(name = "reportsTo")
    private Integer reportsTo;

}
