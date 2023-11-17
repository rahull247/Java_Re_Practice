package com.practice.hibernate.fith.hqlqueries;

import com.practice.hibernate.entity.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class SecondParameterQuery {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernatefundamental.training");
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        System.out.println(session.isOpen());
        session.beginTransaction();

        Query queryAll = session.createQuery("select u from User u where" +
                " u.id > ?1 and u.name like ?2");
        queryAll.setParameter(1, 203l);
        queryAll.setParameter(2, "%ohn%");

        List<User> listOfUsers = queryAll.list();
        listOfUsers.forEach(System.out::println);

        System.out.println("Saved");
        session.getTransaction().commit();
        session.close();


    }
}
