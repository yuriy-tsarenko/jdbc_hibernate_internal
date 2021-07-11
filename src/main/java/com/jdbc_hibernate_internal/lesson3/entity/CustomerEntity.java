package com.jdbc_hibernate_internal.lesson3.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class CustomerEntity implements Serializable {
    //    @GeneratedValue(strategy = GenerationType.IDENTITY) ГЕНЕРАЦИЯ ID ПОЛАГАЕТСЯ НА БД

    @Id
    @Column(name = "customerNumber")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    // здесь используем автоматическую генерацию id и генератор инкремент
    private Integer customerNumber;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "contactLastName")
    private String contactLastName;

    @Column(name = "contactFirstName")
    private String contactFirstName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "addressLine1")
    private String addressLineOne;

    @Column(name = "addressLine2")
    private String addressLineTwo;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "salesRepEmployeeNumber")
    private Integer salesRepEmployeeNumber;

    @Column(name = "creditLimit")
    private BigDecimal creditLimit;

    @Column(name = "customer_category")
    private String customerCategory;

}
