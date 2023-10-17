package com.practice.junit.eight;

import org.junit.jupiter.api.*;

//@TestMethodOrder(MethodOrderer.Alphanumeric.class)
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExecutionMethodOrdering {

    @Test
    @DisplayName("1")
    @Order(1)
    void cmethod1(){
        System.out.println("method 1");
    }
    @Test
    @DisplayName("2")
    @Order(2)
    void amethod2(){
        System.out.println("method 2");
    }
    @Test
    @DisplayName("3")
    @Order(3)
    void bmethod1(){
        System.out.println("method 3");
    }
}
