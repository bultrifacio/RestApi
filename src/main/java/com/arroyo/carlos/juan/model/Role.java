package com.arroyo.carlos.juan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "role_name", nullable = false)
    private String name;

    public Role() {}

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

}
