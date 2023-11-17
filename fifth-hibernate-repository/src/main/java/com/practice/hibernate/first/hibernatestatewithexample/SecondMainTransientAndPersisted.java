package com.practice.hibernate.first.hibernatestatewithexample;

import com.practice.hibernate.entity.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SecondMainTransientAndPersisted {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernatefundamental.training");
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = new User(); //Transient state
        user.setName("John Wick");

        System.out.println(session.contains(user));
        session.save(user); //Persistent state
        System.out.println(session.contains(user));
        session.getTransaction().commit();
        session.close();

    }
}
