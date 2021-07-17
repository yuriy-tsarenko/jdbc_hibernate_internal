package com.cbs.edu.hibernate.mapping;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "entity_generator")
    @SequenceGenerator(name = "entity_generator",
                       sequenceName = "entity_seq",
                       allocationSize = 1)
    private Integer id;
}
