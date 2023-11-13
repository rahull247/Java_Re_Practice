package com.practice.hibernate.manytomany;

import com.practice.hibernate.onetoone.ManagerUni;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class ManyToManyService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveManyToMany(StudentBi student){
        System.out.println("saveManyToMany() method called");
        entityManager.persist(student);
    }

}
