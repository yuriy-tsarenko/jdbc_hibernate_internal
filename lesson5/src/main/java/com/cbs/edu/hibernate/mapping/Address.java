package com.cbs.edu.hibernate.mapping;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Address extends BaseEntity {

    private String city;

}
