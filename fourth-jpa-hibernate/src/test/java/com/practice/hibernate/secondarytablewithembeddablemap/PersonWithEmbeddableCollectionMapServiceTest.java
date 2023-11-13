package com.practice.hibernate.secondarytablewithembeddablemap;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonWithEmbeddableCollectionMapServiceTest {

    @Autowired
    private PersonWithEmbeddableCollectionMapService mapService;

    @Test
    void savePersonWithEmbeddableCollectionMap() {
        PersonWithEmbeddableCollectionMap person=new PersonWithEmbeddableCollectionMap();
        person.setName("Ganesh");

        PersonWithTicketMap ticket1=new PersonWithTicketMap();
        ticket1.setNumber("ABCD");

        person.addTicket(ticket1);

        ticket1=new PersonWithTicketMap();
        ticket1.setNumber("PQRS");

        person.addTicket(ticket1);

        person.addAttribute("VIP", "Yes");
        person.addAttribute("Important", "No");

        mapService.savePersonWithEmbeddableCollectionMap(person);
    }
}