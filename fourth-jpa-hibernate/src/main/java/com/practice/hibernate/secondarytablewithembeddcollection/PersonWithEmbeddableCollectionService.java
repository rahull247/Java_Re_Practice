package com.practice.hibernate.secondarytablewithembeddcollection;

import com.practice.hibernate.secondarytable.PersonWithSecondaryTable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class PersonWithEmbeddableCollectionService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void savePersonWithEmbeddableCollection(PersonWithEmbeddableCollection person){
        System.out.println("Inside savePersonWithEmbeddableCollection() method");
        entityManager.persist(person);
    }
}
