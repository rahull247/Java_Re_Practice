package com.practice.hibernate.onetoone;

import com.practice.hibernate.onetomany.LearnerUni;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class OneToOneService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveOneToOne(ManagerUni managerUni){
        System.out.println("saveOneToOne() method called");
        entityManager.persist(managerUni);
    }


}
