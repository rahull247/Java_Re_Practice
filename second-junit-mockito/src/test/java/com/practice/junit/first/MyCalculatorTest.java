package com.practice.junit.first;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyCalculatorTest {

    @Test
    void first_testAdd() {
        MyCalculator myCalculator = new MyCalculator();
        int actual = myCalculator.add(10, 5);
        int expected = 15;
        assertEquals(expected, actual);
    }

    @Test
//before junit current version used to declare like this "(expected=RuntimeException.class)"
    void second_throwExceptionForFirstParameter() {
        MyCalculator myCalculator = new MyCalculator();
        assertThrows(RuntimeException.class, () -> myCalculator.add(0, 5));
    }

    @Test
//before junit current version used to declare like this "(expected=RuntimeException.class)"
    void second_throwExceptionForSecondParameter() {
        MyCalculator myCalculator = new MyCalculator();
        assertThrows(RuntimeException.class, () -> myCalculator.add(10, 0));
    }

    @Test
    void third_checkExceptionMessageForFirstParameter() {
        MyCalculator myCalculator = new MyCalculator();
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> myCalculator.add(0, 5));
        assertEquals("Zero is not allowed for first parameter", runtimeException.getMessage());
    }

    @Test
    void third_checkExceptionMessageForSecondParameter() {
        MyCalculator myCalculator = new MyCalculator();
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> myCalculator.add(10, 0));
        assertEquals("Zero is not allowed for second parameter", runtimeException.getMessage());
    }

}
