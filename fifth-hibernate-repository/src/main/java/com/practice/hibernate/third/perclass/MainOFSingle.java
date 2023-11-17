package com.practice.hibernate.third.perclass;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainOFSingle {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernatefundamental.training");
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        System.out.println(session.isOpen());
        session.beginTransaction();

        CatPerClass catPerClass=new CatPerClass();
        catPerClass.setName("Garfield");
        catPerClass.setMeow("meowww");

        DogPerClass dogPerClass=new DogPerClass();
        dogPerClass.setName("Rogger");
        dogPerClass.setBark("Bhoww");


        session.save(catPerClass);
        session.save(dogPerClass);

        System.out.println("Saved");
        session.getTransaction().commit();
        session.close();


    }
}
