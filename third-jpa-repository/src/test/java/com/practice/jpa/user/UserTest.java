package com.practice.jpa.user;

import com.practice.jpa.model.User;
import com.practice.jpa.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        List<User> all = userRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void findByNameJohnDoe() {
        List<User> all = userRepository.findByName("Johnny"); //findByName() have to give full string in parameter then it works.
        Assertions.assertEquals(1, all.size());
        System.out.println("------------------------------");
        all.forEach(System.out::println);
    }

    @Test
    void findByNameJamesBond() {
        List<User> all = userRepository.findByName("Jasmin");
        Assertions.assertEquals(1, all.size());
        System.out.println("------------------------------");
        all.forEach(System.out::println);
    }

    @Test
    void findByNameContainingDoe() {
        List<User> all = userRepository.findByNameContaining("Jimy");
        Assertions.assertEquals(2, all.size());
        System.out.println("------------------------------");
        all.forEach(System.out::println);
    }

    @Test
    void findByNameContainingBond() {
        List<User> all = userRepository.findByNameContaining("Alice");
        Assertions.assertEquals(1, all.size());
        System.out.println("------------------------------");
        all.forEach(System.out::println);
    }

    @Test
    void findByNameContainingIgnoreCaseLilyPotter() {
        List<User> all = userRepository.findByNameContainingIgnoreCase("aLiCe");
        Assertions.assertEquals(1, all.size());
        System.out.println("------------------------------");
        all.forEach(System.out::println);
    }

    @Test
    void findByFirstNameAndLastName() {
        List<User> all = userRepository.findByFirstNameAndLastName("James", "Bond");
        Assertions.assertEquals(1, all.size());
        System.out.println("------------------------------");
        all.forEach(System.out::println);
    }

    @Test
    void findByNameIn() {
        List<User> all = userRepository.findByNameIn("Jimy", "Bruno");
        Assertions.assertEquals(2, all.size());
        System.out.println("------------------------------");
        all.forEach(System.out::println);
    }

    @Test
    void findByAge() {
        List<User> all = userRepository.findByAge(24);
        Assertions.assertEquals(1, all.size());
        System.out.println("------------------------------");
        all.forEach(System.out::println);
    }

    @Test
    void findByAgeGreaterThan() {
        List<User> all = userRepository.findByAgeGreaterThan(25);
        Assertions.assertEquals(3, all.size());
        System.out.println("------------------------------");
        all.forEach(System.out::println);
    }

    @Test
    void findByAgeLessThan() {
        List<User> all = userRepository.findByAgeLessThan(25);
        Assertions.assertEquals(3, all.size());
        System.out.println("------------------------------");
        all.forEach(System.out::println);
    }

    @Test
    void findAllWithSortName() {
        Sort sortByName = Sort.by("name");
        List<User> users = userRepository.findAll(sortByName);
        System.out.println("------------------------------");
        users.forEach(u -> System.out.println(u.getName()));
    }
    @Test
    void findAllWithSortNameDesc() {
        Sort sortByName = Sort.by("name").descending();
        List<User> users = userRepository.findAll(sortByName);
        System.out.println("------------------------------");
        users.forEach(u -> System.out.println(u.getName()));
    }
    @Test
    void findAllWithSortAge() {
        Sort sortByName = Sort.by("age");
        List<User> users = userRepository.findAll(sortByName);
        System.out.println("------------------------------");
        users.forEach(u -> System.out.println(u.getName() +"----"+ u.getAge()));
    }
    @Test
    void findAllWithSortNameAndAge() {
        Sort sortByName = Sort.by("name");
        Sort sortByAge = Sort.by("age");
        Sort nameAndAge = sortByAge.and(sortByName);
        List<User> users = userRepository.findAll(nameAndAge);
        System.out.println("------------------------------");
        users.forEach(u -> System.out.println(u.getName() +"----"+ u.getAge()));
    }

    @Test
    void findAllWithPagination() {
        PageRequest pageRequest=PageRequest.of(1, 2);
        Page<User> users = userRepository.findAll(pageRequest);
        System.out.println("------------------------------");
        if (users.hasContent()) {
            List<User> content = users.getContent();
            users.forEach(u -> System.out.println(u.getName() +"----"+ u.getAge()));
        }
        System.out.println("Users :" + users);

    }
    @Test
    void findAllWithPaginationSortByName() {
        Sort sortingName = Sort.by("name");
        PageRequest pageRequest=PageRequest.of(0, 2, sortingName);
        Page<User> users = userRepository.findAll(pageRequest);
        System.out.println("------------------------------");
        if (users.hasContent()) {
            List<User> content = users.getContent();
            users.forEach(u -> System.out.println(u.getName() +"----"+ u.getAge()));
        }
        System.out.println("Users :" + users);

    }


}
