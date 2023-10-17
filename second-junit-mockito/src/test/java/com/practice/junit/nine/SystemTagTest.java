package com.practice.junit.nine;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("SystemTag")
public class SystemTagTest {

    @Test
    void halfSystemTest() {
        System.out.println("###");
        System.out.println("Half System test");
    }

    @Test
    void fullSystemTest() {
        System.out.println("###");
        System.out.println("full System test");
    }

}
