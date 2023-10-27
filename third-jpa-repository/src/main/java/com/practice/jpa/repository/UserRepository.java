package com.practice.jpa.repository;

import com.practice.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    //"FindBy" is prefix & "Name" is from User class - It should be a camel case name for method(eg. User class "firstName" here in repo class after prefix it should be "FirstName").
    List<User> findByName(String name);

    //"Containing" if string containing any word.
    List<User> findByNameContaining(String name);

    //"IgnoreCase" should be ignoring word is in uppercase or lowercase.
    List<User> findByNameContainingIgnoreCase(String name);

    List<User> findByFirstNameAndLastName(String firstName, String lastName);

    List<User> findByNameIn(String... name);

    List<User> findByAge(int age);

    List<User> findByAgeGreaterThan(int age);

    List<User> findByAgeLessThan(int age);


}
