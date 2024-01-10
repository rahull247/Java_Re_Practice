package com.practice.firstms.dto;

public class PersonDto {

    private Integer id;

    private String name;

    private int age;

    private String nickName;

    public PersonDto(Integer id, String name, int age, String nickName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nickName = nickName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
