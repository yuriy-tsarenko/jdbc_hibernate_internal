package com.cbs.edu.hibernate.mapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;

@Entity
@Table(name = "projects")
@Data
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Project extends BaseEntity {

    private String name;
}
