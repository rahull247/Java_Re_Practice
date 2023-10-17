package com.practice.junit.nine;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class NormalTagSystem {

    @Tag("IntegrationTag")
    @Test
    void normalDBTest() {
        System.out.println("$$$");
        System.out.println("Normal db test");
    }

    @Tag("SystemTag")
    @Test
    void normalSystemTest() {
        System.out.println("###");
        System.out.println("Normal System test");
    }

    @Tag("SystemTag")
    @Tag("IntegrationTag")
    @Test
    void commonTest(){
        System.out.println("***");
        System.out.println("Integration + System Testing");
    }

}
