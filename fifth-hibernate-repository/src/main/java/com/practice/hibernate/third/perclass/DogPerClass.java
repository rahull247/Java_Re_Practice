package com.practice.hibernate.third.perclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "dog_perclass")
public class DogPerClass extends AnimalPerClass {
    private String bark;

    public String getBark() {
        return bark;
    }

    public void setBark(String bark) {
        this.bark = bark;
    }
}
