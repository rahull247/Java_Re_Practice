package com.practice.hibernate.fourth.concreteclass;

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

        CatPerConcreteClass catPerConcreteClass=new CatPerConcreteClass();
        catPerConcreteClass.setName("Garfield");
        catPerConcreteClass.setMeow("meowww");

        DogPerConcreteClass dogPerConcreteClass=new DogPerConcreteClass();
        dogPerConcreteClass.setName("Rogger");
        dogPerConcreteClass.setBark("Bhoww");


        session.save(catPerConcreteClass);
        session.save(dogPerConcreteClass);

        System.out.println("Saved");
        session.getTransaction().commit();
        session.close();


    }
}
