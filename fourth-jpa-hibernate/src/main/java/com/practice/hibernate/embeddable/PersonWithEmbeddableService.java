package com.practice.hibernate.embeddable;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class PersonWithEmbeddableService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void savePersonWithEmbeddableAddress(PersonWithEmbeddable person){
        System.out.println("Inside savePersonWithEmbeddableAddress() method");
        entityManager.persist(person);
    }
    @Transactional
    public void savePersonWithOverrideEmbeddedAddress(PersonWithEmbeddableOverrideAddress overrideAddress){
        System.out.println("Inside savePersonWithOverrideEmbeddedAddress() method");
        entityManager.persist(overrideAddress);
    }
}
