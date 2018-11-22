package com.example.demo1.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Access(AccessType.FIELD)
public class ParentEntity implements Serializable {
    private static final long serialVersionUID = -4611815928732870812L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
