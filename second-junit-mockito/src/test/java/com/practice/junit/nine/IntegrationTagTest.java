package com.practice.junit.nine;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTag")
public class IntegrationTagTest {


    @Test
    void oracleDBTest() {
        System.out.println("$$$");
        System.out.println("Oracle db test");
    }

    @Test
    void mongoDBTest() {
        System.out.println("$$$");
        System.out.println("Mongo db test");
    }
}
