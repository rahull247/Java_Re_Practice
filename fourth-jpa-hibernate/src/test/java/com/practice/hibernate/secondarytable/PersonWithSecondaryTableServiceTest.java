package com.practice.hibernate.secondarytable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonWithSecondaryTableServiceTest {


    @Autowired
    private PersonWithSecondaryTableService personWithSecondaryTableService;

    @Test
    void savePersonWithSecondaryTable() {
        PersonWithSecondaryTable person=new PersonWithSecondaryTable();
        person.setName("James Bond");
        person.setCity("Alaska");
        person.setStreet("Adak");
        person.setZipcode("99546");
        person.setCountryCode("1");
        person.setPhoneNumber("9999999999");

        personWithSecondaryTableService.savePersonWithSecondaryTable(person);
    }
}