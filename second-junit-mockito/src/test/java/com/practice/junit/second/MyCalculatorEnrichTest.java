package com.practice.junit.second;

import com.practice.junit.second.MyCalculatorEnrich;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyCalculatorEnrichTest {

    @Test
    void first_testAdd() {
        MyCalculatorEnrich myCalculator = new MyCalculatorEnrich();
        int actual = myCalculator.add(10, 5);
        int expected = 19;
        assertEquals(expected, actual);
    }

    @Test
//before junit current version used to declare like this "(expected=RuntimeException.class)"
    void second_throwExceptionForFirstParameter() {
        MyCalculatorEnrich myCalculator = new MyCalculatorEnrich();
        assertThrows(RuntimeException.class, () -> myCalculator.add(0, 5));
    }

    @Test
//before junit current version used to declare like this "(expected=RuntimeException.class)"
    void second_throwExceptionForSecondParameter() {
        MyCalculatorEnrich myCalculator = new MyCalculatorEnrich();
        assertThrows(RuntimeException.class, () -> myCalculator.add(10, 0));
    }

    @Test
    void third_checkExceptionMessageForFirstParameter() {
        MyCalculatorEnrich myCalculator = new MyCalculatorEnrich();
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> myCalculator.add(0, 5));
        assertEquals("Zero is not allowed for first parameter", runtimeException.getMessage());
    }

    @Test
    void third_checkExceptionMessageForSecondParameter() {
        MyCalculatorEnrich myCalculator = new MyCalculatorEnrich();
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> myCalculator.add(10, 0));
        assertEquals("Zero is not allowed for second parameter", runtimeException.getMessage());
    }

}
