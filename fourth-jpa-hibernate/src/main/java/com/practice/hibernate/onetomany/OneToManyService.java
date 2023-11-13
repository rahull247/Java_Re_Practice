package com.practice.hibernate.onetomany;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class OneToManyService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveOneToMany(LearnerUni learnerUni){
        System.out.println("saveOneToMany() method called");
        entityManager.persist(learnerUni);
    }

}