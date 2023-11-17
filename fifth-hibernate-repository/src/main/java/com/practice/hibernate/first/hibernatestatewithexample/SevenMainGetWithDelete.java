package com.practice.hibernate.first.hibernatestatewithexample;

import com.practice.hibernate.entity.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SevenMainGetWithDelete {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernatefundamental.training");
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, 102L);
        System.out.println("GET method called");
        System.out.println("User Name:" + user.getName());
        System.out.println(session.contains(user));
        System.out.println("*****************");


        session.delete(user);
        System.out.println("Delete method called");
        System.out.println(session.contains(user));
        session.close();

    }
}
