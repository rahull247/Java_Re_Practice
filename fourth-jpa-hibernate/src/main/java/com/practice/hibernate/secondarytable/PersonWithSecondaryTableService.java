package com.practice.hibernate.secondarytable;

import com.practice.hibernate.embeddable.PersonWithEmbeddable;
import com.practice.hibernate.embeddable.PersonWithEmbeddableOverrideAddress;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class PersonWithSecondaryTableService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void savePersonWithSecondaryTable(PersonWithSecondaryTable person){
        System.out.println("Inside savePersonWithSecondaryTable() method");
        entityManager.persist(person);
    }
}
