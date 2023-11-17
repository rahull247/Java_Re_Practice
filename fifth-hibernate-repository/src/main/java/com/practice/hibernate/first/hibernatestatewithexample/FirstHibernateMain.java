package com.practice.hibernate.first.hibernatestatewithexample;

import com.practice.hibernate.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnitUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FirstHibernateMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("hibernatefundamental.training");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        SessionFactory sessionFactory=entityManagerFactory.unwrap(SessionFactory.class);

        Session session=sessionFactory.openSession();
        session.beginTransaction();
        PersistenceUnitUtil persistenceUnitUtil=entityManagerFactory.getPersistenceUnitUtil();

        User user=new User();
        user.setName("John Doe");
        System.out.println("before contains:" + session.contains(user));
        Object identifier = persistenceUnitUtil.getIdentifier(user);
        System.out.println("before identifier:" + identifier);
        session.save(user);
        System.out.println("after contains:" + session.contains(user));
        Object identifier1 = persistenceUnitUtil.getIdentifier(user);
        System.out.println("after identifier:" + identifier1);
        session.getTransaction().commit();
        session.close();
    }
}
