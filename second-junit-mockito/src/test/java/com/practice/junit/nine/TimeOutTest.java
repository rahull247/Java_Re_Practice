package com.practice.junit.nine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TimeOutTest {


    @Test
    void longRunningTest() throws InterruptedException {
        System.out.println("start: longRunningTest");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("end: longRunningTest");
    }
    @Test
    @Timeout(value = 3, unit = TimeUnit.SECONDS) //This Method will throw exception because timeout is 3 but in inside method there is time out is 5.
    void longRunningWithTimeTest() throws InterruptedException {
        System.out.println("start: longRunningTest");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("end: longRunningTest");
    }
}
