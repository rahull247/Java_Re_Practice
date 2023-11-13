package com.practice.hibernate.secondarytablewithembeddcollection;

import javax.persistence.Embeddable;

@Embeddable
public class PersonWithTicket {

    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
