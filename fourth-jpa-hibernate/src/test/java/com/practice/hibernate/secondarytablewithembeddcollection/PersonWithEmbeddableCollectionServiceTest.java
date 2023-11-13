package com.practice.hibernate.secondarytablewithembeddcollection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonWithEmbeddableCollectionServiceTest {

    @Autowired
    private PersonWithEmbeddableCollectionService personWithEmbeddableCollectionService;

    @Test
    void savePersonWithEmbeddableCollection() {
        PersonWithEmbeddableCollection person=new PersonWithEmbeddableCollection();
        person.setName("Sammuel");

        PersonWithTicket ticket1=new PersonWithTicket();
        ticket1.setNumber("123");

        person.addTicket(ticket1);

        ticket1=new PersonWithTicket();
        ticket1.setNumber("7897");

        person.addTicket(ticket1);

        personWithEmbeddableCollectionService.savePersonWithEmbeddableCollection(person);
    }
}