package com.practice.hibernate.second.singletable;

import com.practice.hibernate.entity.User;
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

        CatSingle catSingle=new CatSingle();
        catSingle.setName("Garfield");
        catSingle.setMeow("meowww");

        DogSingle dogSingle=new DogSingle();
        dogSingle.setName("Rogger");
        dogSingle.setBark("Bhoww");


        session.save(catSingle);
        session.save(dogSingle);

        System.out.println("Saved");
        session.getTransaction().commit();
        session.close();


    }
}
