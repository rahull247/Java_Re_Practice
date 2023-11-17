package com.practice.hibernate.second.singletable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Dog Class")
public class DogSingle extends AnimalSingle{
    private String bark;

    public String getBark() {
        return bark;
    }

    public void setBark(String bark) {
        this.bark = bark;
    }
}
