package com.practice.hibernate.third.perclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cat_perclass")
public class CatPerClass extends AnimalPerClass {

    private String meow;

    public String getMeow() {
        return meow;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }
}
