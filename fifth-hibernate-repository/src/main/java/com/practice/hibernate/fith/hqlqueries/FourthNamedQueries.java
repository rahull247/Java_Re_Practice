package com.practice.hibernate.fith.hqlqueries;

import com.practice.hibernate.entity.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FourthNamedQueries {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernatefundamental.training");
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        System.out.println(session.isOpen());
        session.beginTransaction();

        Query queryAll = session.createNamedQuery("user.NameFilter"); // User class already have query place with this named
        queryAll.setParameter("userName", "John Wick");

        List<User> listOfUsers = queryAll.list();
        listOfUsers.forEach(System.out::println);

        System.out.println("Saved");
        session.getTransaction().commit();
        session.close();


    }
}
