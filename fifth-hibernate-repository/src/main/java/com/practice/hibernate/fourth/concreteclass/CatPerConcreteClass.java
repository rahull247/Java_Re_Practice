package com.practice.hibernate.fourth.concreteclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cat_perconcreteclass")
public class CatPerConcreteClass extends AnimalPerConcreteClass {

    private String meow;

    public String getMeow() {
        return meow;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }
}
