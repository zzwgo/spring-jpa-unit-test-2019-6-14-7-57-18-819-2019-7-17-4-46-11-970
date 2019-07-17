package com.oocl.web.sampleWebApp.jpaSample.entity;

import javax.persistence.*;

@Entity
public class RelatedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(nullable = false)
    SingleEntity singleEntity;

    public SingleEntity getSingleEntity() {
        return singleEntity;
    }

    public void setSingleEntity(SingleEntity singleEntity) {
        this.singleEntity = singleEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
