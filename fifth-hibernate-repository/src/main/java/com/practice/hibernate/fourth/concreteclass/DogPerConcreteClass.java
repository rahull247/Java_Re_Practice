package com.practice.hibernate.fourth.concreteclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "dog_perconcreteclass")
public class DogPerConcreteClass extends AnimalPerConcreteClass {
    private String bark;

    public String getBark() {
        return bark;
    }

    public void setBark(String bark) {
        this.bark = bark;
    }
}
