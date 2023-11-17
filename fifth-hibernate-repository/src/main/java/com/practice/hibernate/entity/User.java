package com.practice.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_data")
@NamedQueries({
        @NamedQuery(name = "user.NameFilter", query = "from User u where u.name = :userName")
})
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
