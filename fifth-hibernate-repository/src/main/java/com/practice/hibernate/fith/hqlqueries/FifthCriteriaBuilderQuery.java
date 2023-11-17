package com.practice.hibernate.fith.hqlqueries;

import com.practice.hibernate.entity.User;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FifthCriteriaBuilderQuery {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernatefundamental.training");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();

        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        Path<Integer> id = root.get("id");
        Path<String> name = root.get("name");

        CriteriaQuery<User> listOfUsers = query.select(root).where(
                criteriaBuilder.and(
                        criteriaBuilder.ge(id, 102),
                        criteriaBuilder.like(name, "%ohn%")
                )
        );

        TypedQuery<User> query1 = entityManager.createQuery(listOfUsers);
        List<User> resultList = query1.getResultList();
        resultList.forEach(System.out::println);
        transaction.commit();
        entityManager.close();
    }
}
