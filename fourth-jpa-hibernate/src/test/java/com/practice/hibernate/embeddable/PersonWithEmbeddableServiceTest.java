package com.practice.hibernate.embeddable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonWithEmbeddableServiceTest {

    @Autowired
    private PersonWithEmbeddableService personWithEmbeddableService;

    @Test
    void savePersonWithEmbeddableAddress() {
        AddressEmbeddable addressEmbeddable=new AddressEmbeddable();
        addressEmbeddable.setCity("Pune");
        addressEmbeddable.setStreetName("Walhekarwadi Chinchwad");
        addressEmbeddable.setZipCode("411033");

        PersonWithEmbeddable person=new PersonWithEmbeddable();
        person.setName("Rahul");
        person.setAddress(addressEmbeddable);

        personWithEmbeddableService.savePersonWithEmbeddableAddress(person);
    }
    @Test
    void savePersonWithOverrideEmbeddedAddress() {
        AddressEmbeddable addressEmbeddable=new AddressEmbeddable();
        addressEmbeddable.setCity("Pune");
        addressEmbeddable.setStreetName("Walhekarwadi Chinchwad");
        addressEmbeddable.setZipCode("411033");

        AddressEmbeddable billingAddress=new AddressEmbeddable();
        billingAddress.setCity("Pimpri");
        billingAddress.setStreetName("Bijlinagar Chinchwad");
        billingAddress.setZipCode("411033");



        PersonWithEmbeddableOverrideAddress person=new PersonWithEmbeddableOverrideAddress();
        person.setName("Rahul");
        person.setAddress(addressEmbeddable);
        person.setBillingAddress(billingAddress);
        personWithEmbeddableService.savePersonWithOverrideEmbeddedAddress(person);
    }
}