package com.practice.hibernate.third.perclass;

import jakarta.persistence.*;

@Entity
@Table(name = "animal_perclass")
@Inheritance(strategy = InheritanceType.JOINED)
public class AnimalPerClass {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
