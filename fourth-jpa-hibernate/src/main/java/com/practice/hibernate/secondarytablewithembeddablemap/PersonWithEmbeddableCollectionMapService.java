package com.practice.hibernate.secondarytablewithembeddablemap;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class PersonWithEmbeddableCollectionMapService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void savePersonWithEmbeddableCollectionMap(PersonWithEmbeddableCollectionMap collectionMap){
        System.out.println("Inside savePersonWithEmbeddableCollectionMap() method");
        entityManager.persist(collectionMap);
    }
}
