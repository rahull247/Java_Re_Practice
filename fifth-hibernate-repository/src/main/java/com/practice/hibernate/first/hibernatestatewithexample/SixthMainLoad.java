package com.practice.hibernate.first.hibernatestatewithexample;

import com.practice.hibernate.entity.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SixthMainLoad {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernatefundamental.training");
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.load(User.class, 102L);
        System.out.println("GET method called");
        System.out.println("User NAme:" + user.getName());
        System.out.println("*****************");


        User user1 = session.load(User.class, 102L);
        System.out.println("GET method called");
        System.out.println("User NAme:" + user1.getName());
        session.close();

    }
}
