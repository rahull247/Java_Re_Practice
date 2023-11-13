package com.practice.hibernate.embeddable;


import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Table(name = "personwithoverrideaddressembeddable")
public class PersonWithEmbeddableOverrideAddress {

    @Id
    @GeneratedValue
    private int id;
    private String Name;

    private AddressEmbeddable address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name ="city", column = @Column(name = "billing_city")),
            @AttributeOverride(name ="streetName", column = @Column(name = "billing_streetname")),
            @AttributeOverride(name ="zipCode", column = @Column(name = "billing_zipcode"))
    })
    private  AddressEmbeddable billingAddress;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public AddressEmbeddable getAddress() {
        return address;
    }

    public void setAddress(AddressEmbeddable address) {
        this.address = address;
    }

    public AddressEmbeddable getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AddressEmbeddable billingAddress) {
        this.billingAddress = billingAddress;
    }
}
