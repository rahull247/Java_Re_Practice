package com.practice.hibernate.secondarytablewithembeddablemap;

import javax.persistence.Embeddable;

@Embeddable
public class PersonWithTicketMap {

    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
